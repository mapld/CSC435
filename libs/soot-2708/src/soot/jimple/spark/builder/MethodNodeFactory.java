/* Soot - a J*va Optimization Framework
 * Copyright (C) 2002 Ondrej Lhotak
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.jimple.spark.builder;
import soot.jimple.spark.*;
import soot.jimple.spark.pag.*;
import soot.jimple.*;
import soot.*;
import soot.util.*;
import soot.toolkits.scalar.Pair;
import soot.jimple.spark.internal.*;
import soot.jimple.toolkits.callgraph.Edge;
import soot.shimple.*;
import java.util.*;

/** Class implementing builder parameters (this decides
 * what kinds of nodes should be built for each kind of Soot value).
 * @author Ondrej Lhotak
 */
public class MethodNodeFactory extends AbstractShimpleValueSwitch {
    public MethodNodeFactory( PAG pag, MethodPAG mpag ) {
	this.pag = pag;
	this.mpag = mpag;
        setCurrentMethod( mpag.getMethod() );
    }
    /** Sets the method for which a graph is currently being built. */
    private void setCurrentMethod( SootMethod m ) {
	method = m;
        if( !m.isStatic() ) {
            SootClass c = m.getDeclaringClass();
            if( c == null ) {
                throw new RuntimeException( "Method "+m+" has no declaring lass" );
            }
            caseThis();
        }
        for( int i = 0; i < m.getParameterCount(); i++ ) {
            if( m.getParameterType(i) instanceof RefLikeType ) {
                caseParm( i );
            }
        }
        Type retType = m.getReturnType();
        if( retType instanceof RefLikeType ) {
            caseRet();
        }
    }

    public Node getNode( Value v ) {
        v.apply( this );
        return getNode();
    }
    /** Adds the edges required for this statement to the graph. */
    final public void handleStmt( Stmt s ) {
	if( s.containsInvokeExpr() ) {
	    return;
	}
	s.apply( new AbstractStmtSwitch() {
	    final public void caseAssignStmt(AssignStmt as) {
                Value l = as.getLeftOp();
                Value r = as.getRightOp();
		if( !( l.getType() instanceof RefLikeType ) ) return;
		l.apply( MethodNodeFactory.this );
		Node dest = getNode();
		r.apply( MethodNodeFactory.this );
		Node src = getNode();
                if( l instanceof InstanceFieldRef ) {
                    ((InstanceFieldRef) l).getBase().apply( MethodNodeFactory.this );
                    pag.addDereference( (VarNode) getNode() );
                }
                if( r instanceof InstanceFieldRef ) {
                    ((InstanceFieldRef) r).getBase().apply( MethodNodeFactory.this );
                    pag.addDereference( (VarNode) getNode() );
                }
		mpag.addInternalEdge( src, dest );
	    }
	    final public void caseReturnStmt(ReturnStmt rs) {
		if( !( rs.getOp().getType() instanceof RefLikeType ) ) return;
		rs.getOp().apply( MethodNodeFactory.this );
                Node retNode = getNode();
                mpag.addInternalEdge( retNode, caseRet() );
	    }
	    final public void caseIdentityStmt(IdentityStmt is) {
		if( !( is.getLeftOp().getType() instanceof RefLikeType ) ) return;
		is.getLeftOp().apply( MethodNodeFactory.this );
		Node dest = getNode();
		is.getRightOp().apply( MethodNodeFactory.this );
		Node src = getNode();
		mpag.addInternalEdge( src, dest );
	    }
	    final public void caseThrowStmt(ThrowStmt ts) {
		ts.getOp().apply( MethodNodeFactory.this );
		mpag.addOutEdge( getNode(), pag.nodeFactory().caseThrow() );
	    }
	} );
    }
    final public Node getNode() {
	return (Node) getResult();
    }
    final public Node caseThis() {
	VarNode ret = pag.makeLocalVarNode(
		    new Pair( method, PointsToAnalysis.THIS_NODE ),
		    method.getDeclaringClass().getType(), method );
        ret.setInterProcTarget();
        return ret;
    }

    final public Node caseParm( int index ) {
        VarNode ret = pag.makeLocalVarNode(
                    new Pair( method, new Integer( index ) ),
                    method.getParameterType( index ), method );
        ret.setInterProcTarget();
        return ret;
    }

    final public void casePhiExpr(PhiExpr e) {
        Pair phiPair = new Pair( e, PointsToAnalysis.PHI_NODE );
        Node phiNode = pag.makeLocalVarNode( phiPair, e.getType(), method );
        for(Iterator opsIt = e.getValues().iterator(); opsIt.hasNext();){
            Value op = (Value) opsIt.next();
            op.apply( MethodNodeFactory.this );
            Node opNode = getNode();
            mpag.addInternalEdge( opNode, phiNode );
        }
        setResult( phiNode );
    }
    
    final public Node caseRet() {
        VarNode ret = pag.makeLocalVarNode(
                    Parm.v( method, PointsToAnalysis.RETURN_NODE ),
                    method.getReturnType(), method );
        ret.setInterProcSource();
        return ret;
    }
    final public Node caseArray( VarNode base ) {
	return pag.makeFieldRefNode( base, ArrayElement.v() );
    }
    /* End of public methods. */
    /* End of package methods. */

    // OK, these ones are public, but they really shouldn't be; it's just
    // that Java requires them to be, because they override those other
    // public methods.
    final public void caseArrayRef( ArrayRef ar ) {
    	caseLocal( (Local) ar.getBase() );
	setResult( caseArray( (VarNode) getNode() ) );
    }
    final public void caseCastExpr( CastExpr ce ) {
	Pair castPair = new Pair( ce, PointsToAnalysis.CAST_NODE );
	ce.getOp().apply( this );
	Node opNode = getNode();
	Node castNode = pag.makeLocalVarNode( castPair, ce.getCastType(), method );
	mpag.addInternalEdge( opNode, castNode );
	setResult( castNode );
    }
    final public void caseCaughtExceptionRef( CaughtExceptionRef cer ) {
	setResult( pag.nodeFactory().caseThrow() );
    }
    final public void caseInstanceFieldRef( InstanceFieldRef ifr ) {
	if( pag.getOpts().field_based() || pag.getOpts().vta() ) {
	    setResult( pag.makeGlobalVarNode( 
			ifr.getField(), 
			ifr.getField().getType() ) );
	} else {
	    setResult( pag.makeLocalFieldRefNode( 
			ifr.getBase(), 
			ifr.getBase().getType(),
			ifr.getField(),
                        method ) );
	}
    }
    final public void caseLocal( Local l ) {
	setResult( pag.makeLocalVarNode( l,  l.getType(), method ) );
    }
    final public void caseNewArrayExpr( NewArrayExpr nae ) {
        setResult( pag.makeAllocNode( nae, nae.getType(), method ) );
    }
    final public void caseNewExpr( NewExpr ne ) {
        if( pag.getOpts().merge_stringbuffer() 
        && ne.getType().equals( RefType.v("java.lang.StringBuffer" ) ) ) {
            setResult( pag.makeAllocNode( ne.getType(), ne.getType(), null ) );
        } else {
            setResult( pag.makeAllocNode( ne, ne.getType(), method ) );
        }
    }
    final public void caseNewMultiArrayExpr( NewMultiArrayExpr nmae ) {
        ArrayType type = (ArrayType) nmae.getType();
        AllocNode prevAn = pag.makeAllocNode(
            new Pair( nmae, new Integer( type.numDimensions ) ), type, method );
        VarNode prevVn = pag.makeLocalVarNode( prevAn, prevAn.getType(), method );
        mpag.addInternalEdge( prevAn, prevVn );
        setResult( prevAn );
        while( true ) {
            Type t = type.getElementType();
            if( !( t instanceof ArrayType ) ) break;
            type = (ArrayType) t;
            AllocNode an = pag.makeAllocNode(
                new Pair( nmae, new Integer( type.numDimensions ) ), type, method );
            VarNode vn = pag.makeLocalVarNode( an, an.getType(), method );
            mpag.addInternalEdge( an, vn );
            mpag.addInternalEdge( vn, pag.makeFieldRefNode( prevVn, ArrayElement.v() ) );
            prevAn = an;
            prevVn = vn;
        }
    }
    final public void caseParameterRef( ParameterRef pr ) {
	setResult( caseParm( pr.getIndex() ) );
    }
    final public void caseStaticFieldRef( StaticFieldRef sfr ) {
	setResult( pag.makeGlobalVarNode( 
		    sfr.getField(), 
		    sfr.getField().getType() ) );
    }
    final public void caseStringConstant( StringConstant sc ) {
        AllocNode stringConstant;
        if( pag.getOpts().string_constants()
        || Scene.v().containsClass(sc.value) 
        || ( sc.value.length() > 0 && sc.value.charAt(0) == '[' ) ) {
            stringConstant = pag.makeStringConstantNode( sc.value );
        } else {
            stringConstant = pag.makeAllocNode(
                PointsToAnalysis.STRING_NODE,
                RefType.v( "java.lang.String" ), null );
        }
        VarNode stringConstantLocal = pag.makeGlobalVarNode(
            stringConstant,
            RefType.v( "java.lang.String" ) );
        pag.addEdge( stringConstant, stringConstantLocal );
        setResult( stringConstantLocal );
    }
    final public void caseThisRef( ThisRef tr ) {
	setResult( caseThis() );
    }
    final public void caseNullConstant( NullConstant nr ) {
	setResult( null );
    }
    final public void caseClassConstant( ClassConstant cc ) {
        AllocNode classConstant = pag.makeClassConstantNode(cc);
        VarNode classConstantLocal = pag.makeGlobalVarNode(
            classConstant,
            RefType.v( "java.lang.Class" ) );
        pag.addEdge(classConstant, classConstantLocal);
        setResult(classConstantLocal);
    }
    final public void defaultCase( Object v ) {
	throw new RuntimeException( "failed to handle "+v );
    }
    protected PAG pag;
    protected MethodPAG mpag;
    protected SootMethod method;
}


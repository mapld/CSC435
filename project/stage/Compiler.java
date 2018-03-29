/*
 * Compiler.java
 *
 * A starting place for the unamed language compiler for CSC 435/535
 *
 */

import org.antlr.runtime.*;
import java.io.*;
import AST.*;
import IR.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Compiler {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Test filename.ul");
			return;
		}
		else {
      input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

    String progName = (new File(args[0])).getName();
    if(progName.indexOf(".") > 0){
      progName = progName.substring(0, progName.lastIndexOf("."));
    }

		// The name of the grammar here is "ulNoActions",
		// so ANTLR generates ulNoActionsLexer and ulNoActionsParser
		ulLexer lexer = new ulLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulParser parser = new ulParser(tokens);

		try {
			Program program = parser.program();
      TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor();
      program.accept(typeCheckVisitor);
      if(typeCheckVisitor.semanticErrors.size() > 0){
        return;
      }
      IRVisitor irVisitor = new IRVisitor(progName);
      IR ir = (IR)program.accept(irVisitor);
      ir.printIR("tests/ir/" + progName + ".ir");
      ir.printJasmin("tests/j/" + progName + ".j");
		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}

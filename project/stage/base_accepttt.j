.source base_accept.ir
.class public base_accept
.super java/lang/Object

.method public static __main()V
	.limit locals 7
	.var 0 is T0  I from L_0 to L_1
	.var 1 is T1  Z from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  I from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  Z from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 0
	ldc 0
	istore 1
	ldc 0
	istore 2
	ldc 0
	istore 3
	ldc 0
	istore 4
	ldc 0
	istore 5
	ldc 0
	istore 6
.line 11
;		  T2 := 5;
	ldc 5
	istore 2
.line 12
;		  T0 := T2;
	iload 2
	istore 0
.line 13
;		  T3 := T0 I* T0;
	iload 0
	iload 0
	imul
	istore 3
.line 14
;		  T4 := T3 I+ T0;
	iload 3
	iload 0
	iadd
	istore 4
.line 15
;		  T5 := T0 I- T0;
	iload 0
	iload 0
	isub
	istore 5
.line 16
;		  T6 := T4 I== T5;
	iload 4
	iload 5
	isub
	ifeq L_8
	ldc 0
	goto L_9
L_8:
	ldc 1
L_9:
	istore 6
.line 17
;		  T1 := T6;
	iload 6
	istore 1
.line 18
;		  RETURN;
	return
L_1:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 4
	invokestatic base_accept/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

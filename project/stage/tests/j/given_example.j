.class public given_example
.super java/lang/Object

.method public static factorial(I)I
.limit locals 11
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 Z from L_0 to L_1
.var 3 is T3 Z from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.var 6 is T6 I from L_0 to L_1
.var 7 is T7 F from L_0 to L_1
.var 8 is T8 I from L_0 to L_1
.var 9 is T9 I from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.limit stack 16
L_0:
;   T1 := 1
ldc 1
istore 1
;   T2 := T0 I== T1
iload 0
iload 1
isub
ifeq L_2
ldc 0
goto L_3
L_2:
ldc 1
L_3:
istore 2
;   T3 := Z! T2
iload 2
ldc 1
ixor
istore 3
;   IF T3 GOTO L0
iload 3
ifne L0
;   T4 := 1
ldc 1
istore 4
;   RETURN T4
iload 4
ireturn
;   GOTO L1
goto L1
; L0:
L0:
;   T5 := 1
ldc 1
istore 5
;   T6 := T0 I- T5
iload 0
iload 5
isub
istore 6
;   T8 := CALL factorial(T6 )
iload 6
invokestatic given_example/factorial(I)I
istore 8
;   T9 := T0 I* T8
iload 0
iload 8
imul
istore 9
;   RETURN T9
iload 9
ireturn
; L1:
L1:
;   T10 := 0
ldc 0
istore 10
;   RETURN T10
iload 10
ireturn
L_1:
.end method

.method public static __main()V
.limit locals 4
.var 0 is T0 Ljava/lang/String; from L_4 to L_5
.var 1 is T1 I from L_4 to L_5
.var 2 is T2 F from L_4 to L_5
.var 3 is T3 I from L_4 to L_5
.limit stack 16
L_4:
;   T0 := "The factorial of 8 is "
ldc "The factorial of 8 is "
astore 0
;   PRINTU T0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 0
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   T1 := 8
ldc 8
istore 1
;   T3 := CALL factorial(T1 )
iload 1
invokestatic given_example/factorial(I)I
istore 3
;   PRINTLNI T3
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 3
invokevirtual java/io/PrintStream/println(I)V
;   RETURN
return
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic given_example/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

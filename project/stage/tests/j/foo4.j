.class public foo4
.super java/lang/Object

.method public static foo(II)I
.limit locals 4
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.limit stack 16
L_0:
;   T2 := T0 I+ T1
iload 0
iload 1
iadd
istore 2
;   RETURN T2
iload 2
ireturn
;   T3 := 0
ldc 0
istore 3
;   RETURN T3
iload 3
ireturn
L_1:
.end method

.method public static __main()V
.limit locals 5
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 F from L_2 to L_3
.var 3 is T3 F from L_2 to L_3
.var 4 is T4 I from L_2 to L_3
.limit stack 16
L_2:
;   T0 := 2
ldc 2
istore 0
;   T1 := 3
ldc 3
istore 1
;   T4 := CALL foo(T0 T1 )
iload 0
iload 1
invokestatic foo4/foo(II)I
istore 4
;   PRINTLNI T4
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 4
invokevirtual java/io/PrintStream/println(I)V
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic foo4/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.class public aaf
.super java/lang/Object

.method public static __main()V
.limit locals 6
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 F from L_0 to L_1
.var 5 is T5 F from L_0 to L_1
.limit stack 16
L_0:
;   T2 := 3
ldc 3
istore 2
;   T0 := T2
iload 2
istore 0
;   T3 := 4
ldc 4
istore 3
;   T1 := T3
iload 3
istore 1
;   T5 := I2F T1
iload 1
i2f
fstore 5
;   CALL foo(T0 T5 )
iload 0
fload 5
invokestatic aaf/foo(IF)V
;   RETURN
return
L_1:
.end method

.method public static foo(IF)V
.limit locals 2
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 F from L_2 to L_3
.limit stack 16
L_2:
;   PRINTI T0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/print(I)V
;   PRINTF T1
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual java/io/PrintStream/print(F)V
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aaf/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

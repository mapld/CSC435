.class public aae
.super java/lang/Object

.method public static __main()V
.limit locals 0
.limit stack 16
L_0:
;   RETURN
return
L_1:
.end method

.method public static foo(I)I
.limit locals 4
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 I from L_2 to L_3
.var 3 is T3 I from L_2 to L_3
.limit stack 16
L_2:
;   T1 := 1
ldc 1
istore 1
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
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aae/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

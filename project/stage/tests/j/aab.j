.class public aab
.super java/lang/Object

.method public static __main()V
.limit locals 0
.limit stack 16
L_0:
;   RETURN
return
L_1:
.end method

.method public static foo1(F)I
.limit locals 2
.var 0 is T0 F from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.limit stack 16
L_2:
;   T1 := 0
ldc 0
istore 1
;   RETURN T1
iload 1
ireturn
L_3:
.end method

.method public static foo2(F)I
.limit locals 2
.var 0 is T0 F from L_4 to L_5
.var 1 is T1 I from L_4 to L_5
.limit stack 16
L_4:
;   T1 := 0
ldc 0
istore 1
;   RETURN T1
iload 1
ireturn
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aab/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

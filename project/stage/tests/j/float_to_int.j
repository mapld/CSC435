.class public float_to_int
.super java/lang/Object

.method public static __main()V
.limit locals 5
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 F from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 F from L_0 to L_1
.var 4 is T4 F from L_0 to L_1
.limit stack 16
L_0:
;   T2 := 1
ldc 1
istore 2
;   T0 := T2
iload 2
istore 0
;   T3 := 1.0
ldc 1.0
fstore 3
;   T1 := T3
fload 3
fstore 1
;   T4 := I2F T0
iload 0
i2f
fstore 4
;   T1 := T4
fload 4
fstore 1
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic float_to_int/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

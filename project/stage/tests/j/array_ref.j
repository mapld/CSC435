.class public array_ref
.super java/lang/Object

.method public static __main()V
.limit locals 14
.var 0 is T0 [I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 F from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.var 6 is T6 I from L_0 to L_1
.var 7 is T7 I from L_0 to L_1
.var 8 is T8 I from L_0 to L_1
.var 9 is T9 I from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.var 11 is T11 F from L_0 to L_1
.var 12 is T12 I from L_0 to L_1
.var 13 is T13 I from L_0 to L_1
.limit stack 16
L_0:
;   T0 := NEWARRAY I 10
ldc 10
newarray int
astore 0
;   T3 := 1
ldc 1
istore 3
;   T4 := 5
ldc 5
istore 4
;   T0[T4] := T3
aload 0
iload 4
iload 3
iastore 
;   T5 := 5
ldc 5
istore 5
;   T6 := T0[T5]
aload 0
iload 5
iaload 
istore 6
;   T7 := 1200
ldc 1200
istore 7
;   T8 := T6 I+ T7
iload 6
iload 7
iadd
istore 8
;   T1 := T8
iload 8
istore 1
;   T9 := 5
ldc 5
istore 9
;   T10 := T0[T9]
aload 0
iload 9
iaload 
istore 10
;   T11 := I2F T10
iload 10
i2f
fstore 11
;   T2 := T11
fload 11
fstore 2
;   T12 := 5
ldc 5
istore 12
;   T13 := T0[T12]
aload 0
iload 12
iaload 
istore 13
;   PRINTI T13
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 13
invokevirtual java/io/PrintStream/print(I)V
;   PRINTF T2
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 2
invokevirtual java/io/PrintStream/print(F)V
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic array_ref/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

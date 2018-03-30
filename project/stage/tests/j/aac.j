.class public aac
.super java/lang/Object

.method public static __main()V
.limit locals 12
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 F from L_0 to L_1
.var 5 is T5 F from L_0 to L_1
.var 6 is T6 F from L_0 to L_1
.var 7 is T7 I from L_0 to L_1
.var 8 is T8 I from L_0 to L_1
.var 9 is T9 F from L_0 to L_1
.var 10 is T10 F from L_0 to L_1
.var 11 is T11 I from L_0 to L_1
.limit stack 16
L_0:
;   T1 := 2
ldc 2
istore 1
;   T2 := 2
ldc 2
istore 2
;   T3 := 9
ldc 9
istore 3
;   T7 := CALL sum(T1 T2 T3 )
iload 1
iload 2
iload 3
invokestatic aac/sum(III)I
istore 7
;   T8 := 2
ldc 2
istore 8
;   T11 := CALL mult(T7 T8 )
iload 7
iload 8
invokestatic aac/mult(II)I
istore 11
;   T0 := T11
iload 11
istore 0
;   RETURN
return
L_1:
.end method

.method public static sum(III)I
.limit locals 5
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 I from L_2 to L_3
.var 3 is T3 I from L_2 to L_3
.var 4 is T4 I from L_2 to L_3
.limit stack 16
L_2:
;   T3 := T0 I+ T1
iload 0
iload 1
iadd
istore 3
;   T2 := T3
iload 3
istore 2
;   RETURN T2
iload 2
ireturn
;   T4 := 0
ldc 0
istore 4
;   RETURN T4
iload 4
ireturn
L_3:
.end method

.method public static mult(II)I
.limit locals 5
.var 0 is T0 I from L_4 to L_5
.var 1 is T1 I from L_4 to L_5
.var 2 is T2 I from L_4 to L_5
.var 3 is T3 I from L_4 to L_5
.var 4 is T4 I from L_4 to L_5
.limit stack 16
L_4:
;   T3 := T0 I* T1
iload 0
iload 1
imul
istore 3
;   T2 := T3
iload 3
istore 2
;   RETURN T2
iload 2
ireturn
;   T4 := 0
ldc 0
istore 4
;   RETURN T4
iload 4
ireturn
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aac/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

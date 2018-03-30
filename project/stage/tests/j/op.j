.class public op
.super java/lang/Object

.method public static __main()V
.limit locals 14
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 Z from L_0 to L_1
.var 4 is T4 Z from L_0 to L_1
.var 5 is T5 Z from L_0 to L_1
.var 6 is T6 I from L_0 to L_1
.var 7 is T7 I from L_0 to L_1
.var 8 is T8 I from L_0 to L_1
.var 9 is T9 I from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.var 11 is T11 Z from L_0 to L_1
.var 12 is T12 Z from L_0 to L_1
.var 13 is T13 Z from L_0 to L_1
.limit stack 16
L_0:
;   T6 := 1
ldc 1
istore 6
;   T0 := T6
iload 6
istore 0
;   T7 := 2
ldc 2
istore 7
;   T1 := T7
iload 7
istore 1
;   T8 := T0 I+ T1
iload 0
iload 1
iadd
istore 8
;   T2 := T8
iload 8
istore 2
;   T9 := T2 I* T2
iload 2
iload 2
imul
istore 9
;   T0 := T9
iload 9
istore 0
;   T10 := T2 I- T0
iload 2
iload 0
isub
istore 10
;   T1 := T10
iload 10
istore 1
;   T11 := T0 I< T2
iload 0
iload 2
isub
iflt L_2
ldc 0
goto L_3
L_2:
ldc 1
L_3:
istore 11
;   T3 := T11
iload 11
istore 3
;   T12 := T0 I== T2
iload 0
iload 2
isub
ifeq L_4
ldc 0
goto L_5
L_4:
ldc 1
L_5:
istore 12
;   T4 := T12
iload 12
istore 4
;   T13 := T1 I< T2
iload 1
iload 2
isub
iflt L_6
ldc 0
goto L_7
L_6:
ldc 1
L_7:
istore 13
;   T5 := T13
iload 13
istore 5
;   PRINTZ T3
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 3
invokevirtual java/io/PrintStream/print(Z)V
;   PRINTZ T4
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 4
invokevirtual java/io/PrintStream/print(Z)V
;   PRINTZ T5
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 5
invokevirtual java/io/PrintStream/print(Z)V
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic op/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

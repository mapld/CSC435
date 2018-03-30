.class public aad
.super java/lang/Object

.method public static __main()V
.limit locals 14
.var 0 is T0 Z from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 F from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 Z from L_0 to L_1
.var 5 is T5 Z from L_0 to L_1
.var 6 is T6 Ljava/lang/String; from L_0 to L_1
.var 7 is T7 Z from L_0 to L_1
.var 8 is T8 Z from L_0 to L_1
.var 9 is T9 Ljava/lang/String; from L_0 to L_1
.var 10 is T10 Z from L_0 to L_1
.var 11 is T11 I from L_0 to L_1
.var 12 is T12 Ljava/lang/String; from L_0 to L_1
.var 13 is T13 F from L_0 to L_1
.limit stack 16
L_0:
;   T3 := 5
ldc 5
istore 3
;   T1 := T3
iload 3
istore 1
;   T4 := TRUE
ldc 1
istore 4
;   T5 := Z! T4
iload 4
ldc 1
ixor
istore 5
;   IF T5 GOTO L0
iload 5
ifne L0
;   T6 := "true if statement"
ldc "true if statement"
astore 6
;   PRINTU T6
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 6
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
; L0:
L0:
;   T7 := TRUE
ldc 1
istore 7
;   T0 := T7
iload 7
istore 0
; L1:
L1:
;   T8 := Z! T0
iload 0
ldc 1
ixor
istore 8
;   IF T8 GOTO L2
iload 8
ifne L2
;   T9 := "looping while once"
ldc "looping while once"
astore 9
;   PRINTU T9
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 9
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   T10 := FALSE
ldc 0
istore 10
;   T0 := T10
iload 10
istore 0
;   GOTO L1
goto L1
; L2:
L2:
;   T11 := 5
ldc 5
istore 11
;   PRINTI T11
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 11
invokevirtual java/io/PrintStream/print(I)V
;   T12 := "new line"
ldc "new line"
astore 12
;   PRINTLNU T12
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 12
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   T13 := I2F T1
iload 1
i2f
fstore 13
;   T2 := T13
fload 13
fstore 2
;   RETURN
return
L_1:
.end method

.method public static foo()F
.limit locals 3
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 F from L_2 to L_3
.limit stack 16
L_2:
;   T1 := 5
ldc 5
istore 1
;   T0 := T1
iload 1
istore 0
;   T2 := I2F T0
iload 0
i2f
fstore 2
;   RETURN T2
fload 2
freturn
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aad/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

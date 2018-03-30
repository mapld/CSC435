.class public literals
.super java/lang/Object

.method public static printChar(C)V
.limit locals 2
.var 0 is T0 C from L_0 to L_1
.var 1 is T1 C from L_0 to L_1
.limit stack 16
L_0:
;   T1 := T0
iload 0
istore 1
;   PRINTLNC T1
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 1
invokevirtual java/io/PrintStream/println(C)V
;   RETURN
return
L_1:
.end method

.method public static doMath(II)I
.limit locals 7
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 I from L_2 to L_3
.var 3 is T3 I from L_2 to L_3
.var 4 is T4 I from L_2 to L_3
.var 5 is T5 I from L_2 to L_3
.var 6 is T6 I from L_2 to L_3
.limit stack 16
L_2:
;   T2 := T0 I* T0
iload 0
iload 0
imul
istore 2
;   T3 := T2 I* T0
iload 2
iload 0
imul
istore 3
;   T4 := T1 I+ T3
iload 1
iload 3
iadd
istore 4
;   T5 := T0 I* T4
iload 0
iload 4
imul
istore 5
;   RETURN T5
iload 5
ireturn
;   T6 := 0
ldc 0
istore 6
;   RETURN T6
iload 6
ireturn
L_3:
.end method

.method public static __main()V
.limit locals 34
.var 0 is T0 C from L_4 to L_5
.var 1 is T1 I from L_4 to L_5
.var 2 is T2 Ljava/lang/String; from L_4 to L_5
.var 3 is T3 F from L_4 to L_5
.var 4 is T4 Z from L_4 to L_5
.var 5 is T5 C from L_4 to L_5
.var 6 is T6 F from L_4 to L_5
.var 7 is T7 I from L_4 to L_5
.var 8 is T8 I from L_4 to L_5
.var 9 is T9 F from L_4 to L_5
.var 10 is T10 F from L_4 to L_5
.var 11 is T11 I from L_4 to L_5
.var 12 is T12 Z from L_4 to L_5
.var 13 is T13 Z from L_4 to L_5
.var 14 is T14 I from L_4 to L_5
.var 15 is T15 I from L_4 to L_5
.var 16 is T16 I from L_4 to L_5
.var 17 is T17 I from L_4 to L_5
.var 18 is T18 F from L_4 to L_5
.var 19 is T19 F from L_4 to L_5
.var 20 is T20 I from L_4 to L_5
.var 21 is T21 Ljava/lang/String; from L_4 to L_5
.var 22 is T22 Z from L_4 to L_5
.var 23 is T23 Z from L_4 to L_5
.var 24 is T24 F from L_4 to L_5
.var 25 is T25 F from L_4 to L_5
.var 26 is T26 Z from L_4 to L_5
.var 27 is T27 Z from L_4 to L_5
.var 28 is T28 I from L_4 to L_5
.var 29 is T29 Z from L_4 to L_5
.var 30 is T30 Z from L_4 to L_5
.var 31 is T31 I from L_4 to L_5
.var 32 is T32 I from L_4 to L_5
.var 33 is T33 Ljava/lang/String; from L_4 to L_5
.limit stack 16
L_4:
;   T5 := 'a'
ldc 97
istore 5
;   T0 := T5
iload 5
istore 0
;   PRINTC T0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/print(C)V
;   CALL printChar(T0 )
iload 0
invokestatic literals/printChar(C)V
;   T7 := 5
ldc 5
istore 7
;   T1 := T7
iload 7
istore 1
;   T8 := 6
ldc 6
istore 8
;   T11 := CALL doMath(T1 T8 )
iload 1
iload 8
invokestatic literals/doMath(II)I
istore 11
;   T12 := TRUE
ldc 1
istore 12
;   T4 := T12
iload 12
istore 4
;   T13 := Z! T4
iload 4
ldc 1
ixor
istore 13
;   IF T13 GOTO L0
iload 13
ifne L0
;   T14 := 7
ldc 7
istore 14
;   T15 := T1 I+ T14
iload 1
iload 14
iadd
istore 15
;   T16 := T1 I* T15
iload 1
iload 15
imul
istore 16
;   T17 := 10
ldc 10
istore 17
;   T20 := CALL doMath(T16 T17 )
iload 16
iload 17
invokestatic literals/doMath(II)I
istore 20
;   PRINTLNI T20
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 20
invokevirtual java/io/PrintStream/println(I)V
; L0:
L0:
;   T21 := "abc123__  fff"
ldc "abc123__  fff"
astore 21
;   T2 := T21
aload 21
astore 2
;   T22 := FALSE
ldc 0
istore 22
;   T23 := Z! T22
iload 22
ldc 1
ixor
istore 23
;   IF T23 GOTO L1
iload 23
ifne L1
;   PRINTU T2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   PRINTU T2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   PRINTU T2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
; L1:
L1:
;   T24 := 1.0
ldc 1.0
fstore 24
;   T3 := T24
fload 24
fstore 3
;   T25 := 2.0
ldc 2.0
fstore 25
;   T26 := T3 F< T25
fload 3
fload 25
fcmpg
iflt L_6
ldc 0
goto L_7
L_6:
ldc 1
L_7:
istore 26
;   T27 := Z! T26
iload 26
ldc 1
ixor
istore 27
;   IF T27 GOTO L2
iload 27
ifne L2
; L4:
L4:
;   T28 := 10
ldc 10
istore 28
;   T29 := T1 I< T28
iload 1
iload 28
isub
iflt L_8
ldc 0
goto L_9
L_8:
ldc 1
L_9:
istore 29
;   T30 := Z! T29
iload 29
ldc 1
ixor
istore 30
;   IF T30 GOTO L5
iload 30
ifne L5
;   T31 := 1
ldc 1
istore 31
;   T32 := T1 I+ T31
iload 1
iload 31
iadd
istore 32
;   T1 := T32
iload 32
istore 1
;   PRINTLNF T3
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 3
invokevirtual java/io/PrintStream/println(F)V
;   PRINTU T2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   GOTO L4
goto L4
; L5:
L5:
;   GOTO L3
goto L3
; L2:
L2:
;   T33 := "nope"
ldc "nope"
astore 33
;   PRINTLNU T33
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 33
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
; L3:
L3:
;   RETURN
return
;   RETURN
return
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic literals/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.class public statements
.super java/lang/Object

.method public static func([I)I
.limit locals 4
.var 0 is T0 [I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.limit stack 16
L_0:
;   T1 := 5
ldc 5
istore 1
;   T2 := T0[T1]
aload 0
iload 1
iaload 
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
.limit locals 31
.var 0 is T0 [I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 I from L_2 to L_3
.var 3 is T3 I from L_2 to L_3
.var 4 is T4 I from L_2 to L_3
.var 5 is T5 I from L_2 to L_3
.var 6 is T6 Z from L_2 to L_3
.var 7 is T7 Z from L_2 to L_3
.var 8 is T8 Ljava/lang/String; from L_2 to L_3
.var 9 is T9 I from L_2 to L_3
.var 10 is T10 I from L_2 to L_3
.var 11 is T11 I from L_2 to L_3
.var 12 is T12 Z from L_2 to L_3
.var 13 is T13 Z from L_2 to L_3
.var 14 is T14 Ljava/lang/String; from L_2 to L_3
.var 15 is T15 Ljava/lang/String; from L_2 to L_3
.var 16 is T16 I from L_2 to L_3
.var 17 is T17 I from L_2 to L_3
.var 18 is T18 I from L_2 to L_3
.var 19 is T19 I from L_2 to L_3
.var 20 is T20 I from L_2 to L_3
.var 21 is T21 Z from L_2 to L_3
.var 22 is T22 Z from L_2 to L_3
.var 23 is T23 Ljava/lang/String; from L_2 to L_3
.var 24 is T24 I from L_2 to L_3
.var 25 is T25 I from L_2 to L_3
.var 26 is T26 I from L_2 to L_3
.var 27 is T27 Ljava/lang/String; from L_2 to L_3
.var 28 is T28 Ljava/lang/String; from L_2 to L_3
.var 29 is T29 F from L_2 to L_3
.var 30 is T30 I from L_2 to L_3
.limit stack 16
L_2:
;   T0 := NEWARRAY I 100
ldc 100
newarray int
astore 0
;   T2 := 1
ldc 1
istore 2
;   T1 := T2
iload 2
istore 1
;   T0[T1] := T1
aload 0
iload 1
iload 1
iastore 
;   T3 := 1
ldc 1
istore 3
;   T4 := T0[T3]
aload 0
iload 3
iaload 
istore 4
;   T5 := 1
ldc 1
istore 5
;   T6 := T4 I== T5
iload 4
iload 5
isub
ifeq L_4
ldc 0
goto L_5
L_4:
ldc 1
L_5:
istore 6
;   T7 := Z! T6
iload 6
ldc 1
ixor
istore 7
;   IF T7 GOTO L0
iload 7
ifne L0
;   T8 := "ehh"
ldc "ehh"
astore 8
;   PRINTU T8
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 8
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
; L0:
L0:
;   T9 := 1
ldc 1
istore 9
;   T10 := T0[T9]
aload 0
iload 9
iaload 
istore 10
;   T11 := 2
ldc 2
istore 11
;   T12 := T10 I== T11
iload 10
iload 11
isub
ifeq L_6
ldc 0
goto L_7
L_6:
ldc 1
L_7:
istore 12
;   T13 := Z! T12
iload 12
ldc 1
ixor
istore 13
;   IF T13 GOTO L1
iload 13
ifne L1
;   T14 := "nehh"
ldc "nehh"
astore 14
;   PRINTU T14
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 14
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   GOTO L2
goto L2
; L1:
L1:
;   T15 := " lmao"
ldc " lmao"
astore 15
;   PRINTU T15
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 15
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
; L2:
L2:
;   T16 := 5
ldc 5
istore 16
;   T0[T16] := T1
aload 0
iload 16
iload 1
iastore 
;   T17 := 0
ldc 0
istore 17
;   T1 := T17
iload 17
istore 1
; L3:
L3:
;   T18 := 5
ldc 5
istore 18
;   T19 := T0[T18]
aload 0
iload 18
iaload 
istore 19
;   T20 := 1
ldc 1
istore 20
;   T21 := T19 I== T20
iload 19
iload 20
isub
ifeq L_8
ldc 0
goto L_9
L_8:
ldc 1
L_9:
istore 21
;   T22 := Z! T21
iload 21
ldc 1
ixor
istore 22
;   IF T22 GOTO L4
iload 22
ifne L4
;   T23 := "ok"
ldc "ok"
astore 23
;   PRINTLNU T23
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 23
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   T24 := 1
ldc 1
istore 24
;   T25 := T1 I+ T24
iload 1
iload 24
iadd
istore 25
;   T1 := T25
iload 25
istore 1
;   T26 := 1000000
ldc 1000000
istore 26
;   T0[T1] := T26
aload 0
iload 1
iload 26
iastore 
;   GOTO L3
goto L3
; L4:
L4:
;   T27 := "Running a program "
ldc "Running a program "
astore 27
;   PRINTLNU T27
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 27
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   T28 := "having a good time"
ldc "having a good time"
astore 28
;   PRINTU T28
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 28
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   T30 := CALL func(T0 )
aload 0
invokestatic statements/func([I)I
istore 30
;   PRINTLNI T30
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 30
invokevirtual java/io/PrintStream/println(I)V
;   RETURN
return
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic statements/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

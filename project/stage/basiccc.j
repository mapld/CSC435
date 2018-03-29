.source basic.ir
.class public basic
.super java/lang/Object

.method public static foo()I
	.limit locals 1
	.var 0 is T0  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 0
.line 5
;		  T0 := 1;
	ldc 1
	istore 0
.line 6
;		  RETURN T0;
	iload 0
	ireturn
L_1:
.end method

.method public static __main()V
	.limit locals 47
	.var 0 is T0  I from L_2 to L_3
	.var 1 is T1  I from L_2 to L_3
	.var 2 is T2  F from L_2 to L_3
	.var 3 is T3  Ljava/lang/String; from L_2 to L_3
	.var 4 is T4  Z from L_2 to L_3
	.var 5 is T5  C from L_2 to L_3
	.var 6 is T6  [I from L_2 to L_3
	.var 7 is T7  I from L_2 to L_3
	.var 8 is T8  F from L_2 to L_3
	.var 9 is T9  Ljava/lang/String; from L_2 to L_3
	.var 10 is T10  C from L_2 to L_3
	.var 11 is T11  Z from L_2 to L_3
	.var 12 is T12  Z from L_2 to L_3
	.var 13 is T13  I from L_2 to L_3
	.var 14 is T14  I from L_2 to L_3
	.var 15 is T15  I from L_2 to L_3
	.var 16 is T16  I from L_2 to L_3
	.var 17 is T17  I from L_2 to L_3
	.var 18 is T18  Ljava/lang/String; from L_2 to L_3
	.var 19 is T19  I from L_2 to L_3
	.var 20 is T20  I from L_2 to L_3
	.var 21 is T21  Z from L_2 to L_3
	.var 22 is T22  F from L_2 to L_3
	.var 23 is T23  Z from L_2 to L_3
	.var 24 is T24  F from L_2 to L_3
	.var 25 is T25  Z from L_2 to L_3
	.var 26 is T26  I from L_2 to L_3
	.var 27 is T27  I from L_2 to L_3
	.var 28 is T28  I from L_2 to L_3
	.var 29 is T29  I from L_2 to L_3
	.var 30 is T30  Z from L_2 to L_3
	.var 31 is T31  I from L_2 to L_3
	.var 32 is T32  I from L_2 to L_3
	.var 33 is T33  Z from L_2 to L_3
	.var 34 is T34  Z from L_2 to L_3
	.var 35 is T35  I from L_2 to L_3
	.var 36 is T36  I from L_2 to L_3
	.var 37 is T37  Ljava/lang/String; from L_2 to L_3
	.var 38 is T38  I from L_2 to L_3
	.var 39 is T39  I from L_2 to L_3
	.var 40 is T40  Z from L_2 to L_3
	.var 41 is T41  Z from L_2 to L_3
	.var 42 is T42  Ljava/lang/String; from L_2 to L_3
	.var 43 is T43  I from L_2 to L_3
	.var 44 is T44  I from L_2 to L_3
	.var 45 is T45  I from L_2 to L_3
	.var 46 is T46  Ljava/lang/String; from L_2 to L_3
	.limit stack 16
L_2:
	ldc 0
	istore 0
	ldc 0
	istore 1
	ldc 0.0
	fstore 2
	aconst_null 
	astore 3
	ldc 0
	istore 4
	ldc 0
	istore 5
	aconst_null 
	astore 6
	ldc 0
	istore 7
	ldc 0.0
	fstore 8
	aconst_null 
	astore 9
	ldc 0
	istore 10
	ldc 0
	istore 11
	ldc 0
	istore 12
	ldc 0
	istore 13
	ldc 0
	istore 14
	ldc 0
	istore 15
	ldc 0
	istore 16
	ldc 0
	istore 17
	aconst_null 
	astore 18
	ldc 0
	istore 19
	ldc 0
	istore 20
	ldc 0
	istore 21
	ldc 0.0
	fstore 22
	ldc 0
	istore 23
	ldc 0.0
	fstore 24
	ldc 0
	istore 25
	ldc 0
	istore 26
	ldc 0
	istore 27
	ldc 0
	istore 28
	ldc 0
	istore 29
	ldc 0
	istore 30
	ldc 0
	istore 31
	ldc 0
	istore 32
	ldc 0
	istore 33
	ldc 0
	istore 34
	ldc 0
	istore 35
	ldc 0
	istore 36
	aconst_null 
	astore 37
	ldc 0
	istore 38
	ldc 0
	istore 39
	ldc 0
	istore 40
	ldc 0
	istore 41
	aconst_null 
	astore 42
	ldc 0
	istore 43
	ldc 0
	istore 44
	ldc 0
	istore 45
	aconst_null 
	astore 46
.line 57
;		  T6 := NEWARRAY I 5;
	ldc 5
	newarray int
	astore 6
.line 58
;		  T7 := 1;
	ldc 1
	istore 7
.line 59
;		  T0 := T7;
	iload 7
	istore 0
.line 60
;		  T8 := 2.0;
	ldc 2.000000
	fstore 8
.line 61
;		  T2 := T8;
	fload 8
	fstore 2
.line 62
;		  T9 := "Hello";
	ldc "Hello"
	astore 9
.line 63
;		  T3 := T9;
	aload 9
	astore 3
.line 64
;		  T10 := 'c';
	ldc 99
	istore 10
.line 65
;		  T5 := T10;
	iload 10
	istore 5
.line 66
;		  T11 := FALSE;
	ldc 0
	istore 11
.line 67
;		  T4 := T11;
	iload 11
	istore 4
.line 68
;		  T12 := TRUE;
	ldc 1
	istore 12
.line 69
;		  T4 := T12;
	iload 12
	istore 4
.line 70
;		  T13 := 333;
	ldc 333
	istore 13
.line 71
;		  T14 := 4;
	ldc 4
	istore 14
.line 72
;		  T6[T14] := T13;
	aload 6
	iload 14
	iload 13
	iastore
.line 73
;		  T15 := 1;
	ldc 1
	istore 15
.line 74
;		  PRINTLNI T15;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 15
	invokevirtual java/io/PrintStream/println(I)V
.line 75
;		  T16 := 4;
	ldc 4
	istore 16
.line 76
;		  T17 := T6[T16];
	aload 6
	iload 16
	iaload
	istore 17
.line 77
;		  T1 := T17;
	iload 17
	istore 1
.line 78
;		  PRINTI T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/print(I)V
.line 79
;		  PRINTI T0;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/print(I)V
.line 80
;		  T18 := "hello";
	ldc "hello"
	astore 18
.line 81
;		  PRINTLNU T18;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 18
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
.line 82
;		  T19 := 4;
	ldc 4
	istore 19
.line 83
;		  T20 := T6[T19];
	aload 6
	iload 19
	iaload
	istore 20
.line 84
;		  T21 := T20 I== T0;
	iload 20
	iload 0
	isub
	ifeq L_4
	ldc 0
	goto L_5
L_4:
	ldc 1
L_5:
	istore 21
.line 85
;		  T4 := T21;
	iload 21
	istore 4
.line 86
;		  T22 := I2F T0;
	iload 0
	i2f
	fstore 22
.line 87
;		  T23 := T2 F== T22;
	fload 2
	fload 22
	fcmpg
	ifeq L_6
	ldc 0
	goto L_7
L_6:
	ldc 1
L_7:
	istore 23
.line 88
;		  T4 := T23;
	iload 23
	istore 4
.line 89
;		  PRINTLNZ T4;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
.line 90
;		  T24 := I2F T0;
	iload 0
	i2f
	fstore 24
.line 91
;		  T25 := T24 F< T2;
	fload 24
	fload 2
	fcmpg
	iflt L_8
	ldc 0
	goto L_9
L_8:
	ldc 1
L_9:
	istore 25
.line 92
;		  T4 := T25;
	iload 25
	istore 4
.line 93
;		  PRINTLNZ T4;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 4
	invokevirtual java/io/PrintStream/println(Z)V
.line 94
;		  T26 := T0 I+ T0;
	iload 0
	iload 0
	iadd
	istore 26
.line 95
;		  T27 := T26 I+ T0;
	iload 26
	iload 0
	iadd
	istore 27
.line 96
;		  T1 := T27;
	iload 27
	istore 1
.line 97
;		  PRINTLNI T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
.line 98
;		  T28 := T1 I* T0;
	iload 1
	iload 0
	imul
	istore 28
.line 99
;		  T29 := T28 I- T0;
	iload 28
	iload 0
	isub
	istore 29
.line 100
;		  T1 := T29;
	iload 29
	istore 1
.line 101
;		  PRINTLNI T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
.line 102
;		  T30 := Z! T4;
	iload 4
	ldc 1
	ixor
	istore 30
.line 103
;		  IF T30 GOTO L0;
	iload 30
	ifne L0
.line 104
;		  T31 := 500;
	ldc 500
	istore 31
.line 105
;		  T0 := T31;
	iload 31
	istore 0
.line 106
;		  GOTO L1;
	goto L1
.line 107
;		L0:;
L0:
.line 108
;		  T32 := 600;
	ldc 600
	istore 32
.line 109
;		  T0 := T32;
	iload 32
	istore 0
.line 110
;		  T33 := TRUE;
	ldc 1
	istore 33
.line 111
;		  T34 := Z! T33;
	iload 33
	ldc 1
	ixor
	istore 34
.line 112
;		  IF T34 GOTO L2;
	iload 34
	ifne L2
.line 113
;		  T35 := 5;
	ldc 5
	istore 35
.line 114
;		  T1 := T35;
	iload 35
	istore 1
.line 115
;		  GOTO L3;
	goto L3
.line 116
;		L2:;
L2:
.line 117
;		  T36 := 7;
	ldc 7
	istore 36
.line 118
;		  T1 := T36;
	iload 36
	istore 1
.line 119
;		L3:;
L3:
.line 120
;		  T37 := "testing if statements";
	ldc "testing if statements"
	astore 37
.line 121
;		  PRINTLNU T37;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 37
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
.line 122
;		L1:;
L1:
.line 123
;		  PRINTLNI T0;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
.line 124
;		  PRINTLNI T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
.line 125
;		  T38 := 0;
	ldc 0
	istore 38
.line 126
;		  T0 := T38;
	iload 38
	istore 0
.line 127
;		L4:;
L4:
.line 128
;		  T39 := 5;
	ldc 5
	istore 39
.line 129
;		  T40 := T0 I< T39;
	iload 0
	iload 39
	isub
	iflt L_18
	ldc 0
	goto L_19
L_18:
	ldc 1
L_19:
	istore 40
.line 130
;		  T41 := Z! T40;
	iload 40
	ldc 1
	ixor
	istore 41
.line 131
;		  IF T41 GOTO L5;
	iload 41
	ifne L5
.line 132
;		  T42 := "counting ";
	ldc "counting "
	astore 42
.line 133
;		  PRINTU T42;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 42
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 134
;		  PRINTLNI T0;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
.line 135
;		  T43 := 1;
	ldc 1
	istore 43
.line 136
;		  T44 := T0 I+ T43;
	iload 0
	iload 43
	iadd
	istore 44
.line 137
;		  T0 := T44;
	iload 44
	istore 0
.line 138
;		  GOTO L4;
	goto L4
.line 139
;		L5:;
L5:
.line 140
;		  T45 := CALL foo();
	invokestatic basic/foo()I
	istore 45
.line 141
;		  PRINTLNI T45;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 45
	invokevirtual java/io/PrintStream/println(I)V
.line 142
;		  T46 := "done";
	ldc "done"
	astore 46
.line 143
;		  PRINTLNU T46;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 46
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
.line 144
;		  RETURN;
	return
L_3:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 4
	invokestatic basic/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

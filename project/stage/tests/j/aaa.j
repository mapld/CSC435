.class public aaa
.super java/lang/Object

.method public static __main()V
.limit locals 29
.var 0 is T0 Ljava/lang/String; from L_0 to L_1
.var 1 is T1 Ljava/lang/String; from L_0 to L_1
.var 2 is T2 Ljava/lang/String; from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.var 6 is T6 F from L_0 to L_1
.var 7 is T7 F from L_0 to L_1
.var 8 is T8 F from L_0 to L_1
.var 9 is T9 C from L_0 to L_1
.var 10 is T10 C from L_0 to L_1
.var 11 is T11 C from L_0 to L_1
.var 12 is T12 Z from L_0 to L_1
.var 13 is T13 [I from L_0 to L_1
.var 14 is T14 I from L_0 to L_1
.var 15 is T15 I from L_0 to L_1
.var 16 is T16 I from L_0 to L_1
.var 17 is T17 I from L_0 to L_1
.var 18 is T18 Ljava/lang/String; from L_0 to L_1
.var 19 is T19 Ljava/lang/String; from L_0 to L_1
.var 20 is T20 Ljava/lang/String; from L_0 to L_1
.var 21 is T21 C from L_0 to L_1
.var 22 is T22 C from L_0 to L_1
.var 23 is T23 C from L_0 to L_1
.var 24 is T24 F from L_0 to L_1
.var 25 is T25 F from L_0 to L_1
.var 26 is T26 F from L_0 to L_1
.var 27 is T27 Z from L_0 to L_1
.var 28 is T28 Z from L_0 to L_1
.limit stack 16
L_0:
;   T13 := NEWARRAY I 4
ldc 4
newarray int
astore 13
;   T14 := 1
ldc 1
istore 14
;   T15 := 1
ldc 1
istore 15
;   T13[T15] := T14
aload 13
iload 15
iload 14
iastore 
;   T16 := 1
ldc 1
istore 16
;   T17 := T13[T16]
aload 13
iload 16
iaload 
istore 17
;   PRINTI T17
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 17
invokevirtual java/io/PrintStream/print(I)V
;   T18 := "a"
ldc "a"
astore 18
;   T0 := T18
aload 18
astore 0
;   T19 := "b"
ldc "b"
astore 19
;   T1 := T19
aload 19
astore 1
;   T20 := T0 U+ T1
new java/lang/StringBuffer
dup
invokenonvirtual java/lang/StringBuffer/<init>()V
aload 0
invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
aload 1
invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;
astore 20
;   T2 := T20
aload 20
astore 2
;   T21 := 'a'
ldc 97
istore 21
;   T9 := T21
iload 21
istore 9
;   T22 := 'b'
ldc 98
istore 22
;   T10 := T22
iload 22
istore 10
;   T23 := T10 C- T9
iload 10
iload 9
isub
istore 23
;   T11 := T23
iload 23
istore 11
;   T24 := 1.1
ldc 1.1
fstore 24
;   T6 := T24
fload 24
fstore 6
;   T25 := 2.2
ldc 2.2
fstore 25
;   T7 := T25
fload 25
fstore 7
;   T26 := T6 F* T7
fload 6
fload 7
fmul
fstore 26
;   T8 := T26
fload 26
fstore 8
;   T27 := T9 C< T10
iload 9
iload 10
isub
iflt L_2
ldc 0
goto L_3
L_2:
ldc 1
L_3:
istore 27
;   T12 := T27
iload 27
istore 12
;   T28 := T6 F== T7
fload 6
fload 7
fcmpg
ifeq L_4
ldc 0
goto L_5
L_4:
ldc 1
L_5:
istore 28
;   T12 := T28
iload 28
istore 12
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic aaa/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

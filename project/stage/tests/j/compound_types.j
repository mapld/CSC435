.class public compound_types
.super java/lang/Object

.method public static doMath([FFI)Z
.limit locals 12
.var 0 is T0 [F from L_0 to L_1
.var 1 is T1 F from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 Z from L_0 to L_1
.var 6 is T6 Z from L_0 to L_1
.var 7 is T7 F from L_0 to L_1
.var 8 is T8 F from L_0 to L_1
.var 9 is T9 I from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.var 11 is T11 Z from L_0 to L_1
.limit stack 16
L_0:
;   T4 := 0
ldc 0
istore 4
;   T3 := T4
iload 4
istore 3
; L0:
L0:
;   T5 := T3 I< T2
iload 3
iload 2
isub
iflt L_2
ldc 0
goto L_3
L_2:
ldc 1
L_3:
istore 5
;   T6 := Z! T5
iload 5
ldc 1
ixor
istore 6
;   IF T6 GOTO L1
iload 6
ifne L1
;   T7 := T0[T3]
aload 0
iload 3
faload 
fstore 7
;   T8 := T7 F* T1
fload 7
fload 1
fmul
fstore 8
;   T0[T3] := T8
aload 0
iload 3
fload 8
fastore 
;   T9 := 1
ldc 1
istore 9
;   T10 := T3 I+ T9
iload 3
iload 9
iadd
istore 10
;   T3 := T10
iload 10
istore 3
;   GOTO L0
goto L0
; L1:
L1:
;   T11 := TRUE
ldc 1
istore 11
;   RETURN T11
iload 11
ireturn
L_1:
.end method

.method public static __main()V
.limit locals 19
.var 0 is T0 [I from L_4 to L_5
.var 1 is T1 [Ljava/lang/String; from L_4 to L_5
.var 2 is T2 [C from L_4 to L_5
.var 3 is T3 [Z from L_4 to L_5
.var 4 is T4 [F from L_4 to L_5
.var 5 is T5 F from L_4 to L_5
.var 6 is T6 I from L_4 to L_5
.var 7 is T7 I from L_4 to L_5
.var 8 is T8 F from L_4 to L_5
.var 9 is T9 I from L_4 to L_5
.var 10 is T10 F from L_4 to L_5
.var 11 is T11 F from L_4 to L_5
.var 12 is T12 F from L_4 to L_5
.var 13 is T13 Z from L_4 to L_5
.var 14 is T14 Z from L_4 to L_5
.var 15 is T15 Z from L_4 to L_5
.var 16 is T16 Z from L_4 to L_5
.var 17 is T17 Ljava/lang/String; from L_4 to L_5
.var 18 is T18 Ljava/lang/String; from L_4 to L_5
.limit stack 16
L_4:
;   T0 := NEWARRAY I 5
ldc 5
newarray int
astore 0
;   T1 := NEWARRAY U 3333
ldc 3333
anewarray java/lang/String
astore 1
;   T2 := NEWARRAY C 50
ldc 50
newarray char
astore 2
;   T3 := NEWARRAY Z 300
ldc 300
newarray boolean
astore 3
;   T4 := NEWARRAY F 1000
ldc 1000
newarray float
astore 4
;   T5 := 1.5
ldc 1.5
fstore 5
;   T6 := 0
ldc 0
istore 6
;   T4[T6] := T5
aload 4
iload 6
fload 5
fastore 
;   T7 := 0
ldc 0
istore 7
;   T8 := T4[T7]
aload 4
iload 7
faload 
fstore 8
;   T9 := 100
ldc 100
istore 9
;   T13 := CALL doMath(T4 T8 T9 )
aload 4
fload 8
iload 9
invokestatic compound_types/doMath([FFI)Z
istore 13
;   T14 := TRUE
ldc 1
istore 14
;   T15 := T13 Z== T14
iload 13
iload 14
isub
ifeq L_6
ldc 0
goto L_7
L_6:
ldc 1
L_7:
istore 15
;   T16 := Z! T15
iload 15
ldc 1
ixor
istore 16
;   IF T16 GOTO L0
iload 16
ifne L0
;   T17 := "Yes"
ldc "Yes"
astore 17
;   PRINTLNU T17
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 17
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   GOTO L1
goto L1
; L0:
L0:
;   T18 := "No"
ldc "No"
astore 18
;   PRINTLNU T18
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 18
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
; L1:
L1:
;   RETURN
return
;   RETURN
return
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic compound_types/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.class public parens
.super java/lang/Object

.method public static __main()V
.limit locals 32
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.var 6 is T6 I from L_0 to L_1
.var 7 is T7 I from L_0 to L_1
.var 8 is T8 I from L_0 to L_1
.var 9 is T9 I from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.var 11 is T11 I from L_0 to L_1
.var 12 is T12 I from L_0 to L_1
.var 13 is T13 I from L_0 to L_1
.var 14 is T14 I from L_0 to L_1
.var 15 is T15 I from L_0 to L_1
.var 16 is T16 I from L_0 to L_1
.var 17 is T17 I from L_0 to L_1
.var 18 is T18 I from L_0 to L_1
.var 19 is T19 I from L_0 to L_1
.var 20 is T20 I from L_0 to L_1
.var 21 is T21 I from L_0 to L_1
.var 22 is T22 I from L_0 to L_1
.var 23 is T23 I from L_0 to L_1
.var 24 is T24 I from L_0 to L_1
.var 25 is T25 I from L_0 to L_1
.var 26 is T26 I from L_0 to L_1
.var 27 is T27 I from L_0 to L_1
.var 28 is T28 I from L_0 to L_1
.var 29 is T29 I from L_0 to L_1
.var 30 is T30 I from L_0 to L_1
.var 31 is T31 I from L_0 to L_1
.limit stack 16
L_0:
;   T4 := 5
ldc 5
istore 4
;   T0 := T4
iload 4
istore 0
;   T5 := 10
ldc 10
istore 5
;   T1 := T5
iload 5
istore 1
;   T6 := 2
ldc 2
istore 6
;   T2 := T6
iload 6
istore 2
;   T7 := 7
ldc 7
istore 7
;   T3 := T7
iload 7
istore 3
;   T8 := T1 I* T1
iload 1
iload 1
imul
istore 8
;   T9 := T0 I+ T8
iload 0
iload 8
iadd
istore 9
;   T10 := T9 I+ T0
iload 9
iload 0
iadd
istore 10
;   T11 := T10 I+ T0
iload 10
iload 0
iadd
istore 11
;   T12 := T0 I* T0
iload 0
iload 0
imul
istore 12
;   T13 := T0 I+ T1
iload 0
iload 1
iadd
istore 13
;   T14 := T12 I* T13
iload 12
iload 13
imul
istore 14
;   T15 := T14 I* T2
iload 14
iload 2
imul
istore 15
;   T16 := T0 I* T1
iload 0
iload 1
imul
istore 16
;   T17 := T16 I* T1
iload 16
iload 1
imul
istore 17
;   T18 := T0 I+ T0
iload 0
iload 0
iadd
istore 18
;   T19 := T0 I* T18
iload 0
iload 18
imul
istore 19
;   T20 := T0 I+ T1
iload 0
iload 1
iadd
istore 20
;   T21 := T20 I* T2
iload 20
iload 2
imul
istore 21
;   T22 := T2 I* T3
iload 2
iload 3
imul
istore 22
;   T23 := T21 I* T22
iload 21
iload 22
imul
istore 23
;   T24 := T19 I* T23
iload 19
iload 23
imul
istore 24
;   T25 := T17 I* T24
iload 17
iload 24
imul
istore 25
;   T26 := T15 I+ T25
iload 15
iload 25
iadd
istore 26
;   T27 := T11 I+ T26
iload 11
iload 26
iadd
istore 27
;   T28 := T27 I+ T0
iload 27
iload 0
iadd
istore 28
;   T29 := T0 I* T1
iload 0
iload 1
imul
istore 29
;   T30 := T29 I* T2
iload 29
iload 2
imul
istore 30
;   T31 := T28 I+ T30
iload 28
iload 30
iadd
istore 31
;   T3 := T31
iload 31
istore 3
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic parens/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

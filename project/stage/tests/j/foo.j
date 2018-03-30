.class public foo
.super java/lang/Object

.method public static foo(II)I
.limit locals 12
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 F from L_0 to L_1
.var 3 is T3 Ljava/lang/String; from L_0 to L_1
.var 4 is T4 C from L_0 to L_1
.var 5 is T5 [I from L_0 to L_1
.var 6 is T6 C from L_0 to L_1
.var 7 is T7 I from L_0 to L_1
.var 8 is T8 Ljava/lang/String; from L_0 to L_1
.var 9 is T9 F from L_0 to L_1
.var 10 is T10 I from L_0 to L_1
.var 11 is T11 I from L_0 to L_1
.limit stack 16
L_0:
;   T5 := NEWARRAY I 3
ldc 3
newarray int
astore 5
;   T6 := 'A'
ldc 65
istore 6
;   T4 := T6
iload 6
istore 4
;   T7 := 7
ldc 7
istore 7
;   T0 := T7
iload 7
istore 0
;   T8 := "Hi there"
ldc "Hi there"
astore 8
;   T3 := T8
aload 8
astore 3
;   T9 := 3.732
ldc 3.732
fstore 9
;   T2 := T9
fload 9
fstore 2
;   T1 := T0
iload 0
istore 1
;   T10 := 8
ldc 8
istore 10
;   RETURN T10
iload 10
ireturn
;   T11 := 0
ldc 0
istore 11
;   RETURN T11
iload 11
ireturn
L_1:
.end method

.method public static __main()V
.limit locals 5
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 I from L_2 to L_3
.var 2 is T2 F from L_2 to L_3
.var 3 is T3 F from L_2 to L_3
.var 4 is T4 I from L_2 to L_3
.limit stack 16
L_2:
;   T0 := 2
ldc 2
istore 0
;   T1 := 2
ldc 2
istore 1
;   T4 := CALL foo(T0 T1 )
iload 0
iload 1
invokestatic foo/foo(II)I
istore 4
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic foo/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

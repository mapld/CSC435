.class public function_call
.super java/lang/Object

.method public static foo()I
.limit locals 6
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 F from L_0 to L_1
.var 2 is T2 [Ljava/lang/String; from L_0 to L_1
.var 3 is T3 I from L_0 to L_1
.var 4 is T4 Ljava/lang/String; from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.limit stack 16
L_0:
;   T2 := NEWARRAY U 5
ldc 5
anewarray java/lang/String
astore 2
;   T3 := 5
ldc 5
istore 3
;   T0 := T3
iload 3
istore 0
;   T4 := "foo"
ldc "foo"
astore 4
;   PRINTLNU T4
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 4
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   RETURN T0
iload 0
ireturn
;   T5 := 0
ldc 0
istore 5
;   RETURN T5
iload 5
ireturn
L_1:
.end method

.method public static doThing(IF)V
.limit locals 3
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 F from L_2 to L_3
.var 2 is T2 Ljava/lang/String; from L_2 to L_3
.limit stack 16
L_2:
;   PRINTI T0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/print(I)V
;   T2 := " "
ldc " "
astore 2
;   PRINTU T2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;   PRINTF T1
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual java/io/PrintStream/print(F)V
;   RETURN
return
;   RETURN
return
L_3:
.end method

.method public static __main()V
.limit locals 10
.var 0 is T0 I from L_4 to L_5
.var 1 is T1 I from L_4 to L_5
.var 2 is T2 I from L_4 to L_5
.var 3 is T3 I from L_4 to L_5
.var 4 is T4 F from L_4 to L_5
.var 5 is T5 F from L_4 to L_5
.var 6 is T6 I from L_4 to L_5
.var 7 is T7 I from L_4 to L_5
.var 8 is T8 F from L_4 to L_5
.var 9 is T9 F from L_4 to L_5
.limit stack 16
L_4:
;   T1 := CALL foo()
invokestatic function_call/foo()I
istore 1
;   T2 := 1
ldc 1
istore 2
;   T3 := 2
ldc 2
istore 3
;   T5 := I2F T3
iload 3
i2f
fstore 5
;   CALL doThing(T2 T5 )
iload 2
fload 5
invokestatic function_call/doThing(IF)V
;   T6 := 20
ldc 20
istore 6
;   T0 := T6
iload 6
istore 0
;   T7 := 2
ldc 2
istore 7
;   T9 := I2F T0
iload 0
i2f
fstore 9
;   CALL doThing(T7 T9 )
iload 7
fload 9
invokestatic function_call/doThing(IF)V
;   RETURN
return
;   RETURN
return
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic function_call/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

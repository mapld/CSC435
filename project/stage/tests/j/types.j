.class public types
.super java/lang/Object

.method public static func(Ljava/lang/String;F)Z
.limit locals 5
.var 0 is T0 Ljava/lang/String; from L_0 to L_1
.var 1 is T1 F from L_0 to L_1
.var 2 is T2 Z from L_0 to L_1
.var 3 is T3 Ljava/lang/String; from L_0 to L_1
.var 4 is T4 Z from L_0 to L_1
.limit stack 16
L_0:
;   PRINTF T1
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual java/io/PrintStream/print(F)V
;   T3 := "bob"
ldc "bob"
astore 3
;   T4 := T0 U== T3
aload 0
aload 3
invokevirtual java/lang/String/compareTo(Ljava/lang/String;)I
ifeq L_2
ldc 0
goto L_3
L_2:
ldc 1
L_3:
istore 4
;   T2 := T4
iload 4
istore 2
;   RETURN T2
iload 2
ireturn
L_1:
.end method

.method public static __main()V
.limit locals 10
.var 0 is T0 C from L_4 to L_5
.var 1 is T1 F from L_4 to L_5
.var 2 is T2 Ljava/lang/String; from L_4 to L_5
.var 3 is T3 Z from L_4 to L_5
.var 4 is T4 I from L_4 to L_5
.var 5 is T5 Ljava/lang/String; from L_4 to L_5
.var 6 is T6 F from L_4 to L_5
.var 7 is T7 F from L_4 to L_5
.var 8 is T8 F from L_4 to L_5
.var 9 is T9 Z from L_4 to L_5
.limit stack 16
L_4:
;   T5 := "bob"
ldc "bob"
astore 5
;   T2 := T5
aload 5
astore 2
;   T6 := 50.0
ldc 50.0
fstore 6
;   T9 := CALL func(T2 T6 )
aload 2
fload 6
invokestatic types/func(Ljava/lang/String;F)Z
istore 9
;   PRINTZ T9
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 9
invokevirtual java/io/PrintStream/print(Z)V
;   RETURN
return
;   RETURN
return
L_5:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic types/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

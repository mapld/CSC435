.class public function_params
.super java/lang/Object

.method public static func(IFCLjava/lang/String;)I
.limit locals 7
.var 0 is T0 I from L_0 to L_1
.var 1 is T1 F from L_0 to L_1
.var 2 is T2 C from L_0 to L_1
.var 3 is T3 Ljava/lang/String; from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.var 5 is T5 I from L_0 to L_1
.var 6 is T6 I from L_0 to L_1
.limit stack 16
L_0:
;   PRINTLNI T0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V
;   PRINTLNF T1
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual java/io/PrintStream/println(F)V
;   PRINTLNC T2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual java/io/PrintStream/println(C)V
;   PRINTLNU T3
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;   T4 := T0 I* T0
iload 0
iload 0
imul
istore 4
;   T5 := T4 I+ T0
iload 4
iload 0
iadd
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
L_1:
.end method

.method public static __main()V
.limit locals 9
.var 0 is T0 I from L_2 to L_3
.var 1 is T1 F from L_2 to L_3
.var 2 is T2 C from L_2 to L_3
.var 3 is T3 Ljava/lang/String; from L_2 to L_3
.var 4 is T4 F from L_2 to L_3
.var 5 is T5 F from L_2 to L_3
.var 6 is T6 F from L_2 to L_3
.var 7 is T7 F from L_2 to L_3
.var 8 is T8 I from L_2 to L_3
.limit stack 16
L_2:
;   T0 := 1
ldc 1
istore 0
;   T1 := 0.1
ldc 0.1
fstore 1
;   T2 := 'd'
ldc 100
istore 2
;   T3 := "Running a function with parameters"
ldc "Running a function with parameters"
astore 3
;   T8 := CALL func(T0 T1 T2 T3 )
iload 0
fload 1
iload 2
aload 3
invokestatic function_params/func(IFCLjava/lang/String;)I
istore 8
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic function_params/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

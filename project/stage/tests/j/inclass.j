.class public inclass
.super java/lang/Object

.method public static foo(Z)V
.limit locals 5
.var 0 is T0 Z from L_0 to L_1
.var 1 is T1 I from L_0 to L_1
.var 2 is T2 I from L_0 to L_1
.var 3 is T3 Z from L_0 to L_1
.var 4 is T4 I from L_0 to L_1
.limit stack 16
L_0:
;   T2 := 5
ldc 5
istore 2
;   T1 := T2
iload 2
istore 1
;   T3 := Z! T0
iload 0
ldc 1
ixor
istore 3
;   IF T3 GOTO L0
iload 3
ifne L0
;   T4 := 9
ldc 9
istore 4
;   T1 := T4
iload 4
istore 1
; L0:
L0:
;   PRINTLNI T1
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 1
invokevirtual java/io/PrintStream/println(I)V
;   RETURN
return
L_1:
.end method

.method public static __main()V
.limit locals 0
.limit stack 16
L_2:
;   RETURN
return
L_3:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic inclass/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.class public function_body
.super java/lang/Object

.method public static __main()V
.limit locals 2
.var 0 is T0 Ljava/lang/String; from L_0 to L_1
.var 1 is T1 Ljava/lang/String; from L_0 to L_1
.limit stack 16
L_0:
;   T1 := "hi"
ldc "hi"
astore 1
;   T0 := T1
aload 1
astore 0
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic function_body/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

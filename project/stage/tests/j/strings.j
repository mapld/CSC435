.class public strings
.super java/lang/Object

.method public static __main()V
.limit locals 6
.var 0 is T0 Ljava/lang/String; from L_0 to L_1
.var 1 is T1 Ljava/lang/String; from L_0 to L_1
.var 2 is T2 Ljava/lang/String; from L_0 to L_1
.var 3 is T3 Ljava/lang/String; from L_0 to L_1
.var 4 is T4 Ljava/lang/String; from L_0 to L_1
.var 5 is T5 Ljava/lang/String; from L_0 to L_1
.limit stack 16
L_0:
;   T3 := "abc"
ldc "abc"
astore 3
;   T0 := T3
aload 3
astore 0
;   T4 := ""
ldc ""
astore 4
;   T1 := T4
aload 4
astore 1
;   T5 := "__ __ aa __ AA __ BB      ccsdfdfSDsfdsfdsf____dfds"
ldc "__ __ aa __ AA __ BB      ccsdfdfSDsfdsfdsf____dfds"
astore 5
;   T2 := T5
aload 5
astore 2
;   RETURN
return
L_1:
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 4
invokestatic strings/__main()V
return
.end method

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

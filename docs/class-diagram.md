classDiagram
%% Diagrama gerado automaticamente pelo agente de conversão COBOL → Java
    class Helloworld {
        <<Service>>
    }
    class IfExample {
        <<Service>>
        +String userinput
    }
    class Increment {
        <<Service>>
        +long a
        +long i
        +String x
        +void endPerform()
        +void main(String args)
    }
    class Multip {
        <<Service>>
        +int number1
        +int number2
        +int number3
        +int number4
        +int result1
        +String result1f
        +int result2
        +String result2f
        +void calc1()
        +void calc2()
        +void main(String args)
    }
    class NestedIfs {
        <<Service>>
        +int a
        +int b
        +int result
        +String formatted
    }
    class Performexample {
        <<Service>>
        +String userinitials
        +int a
        +int b
        +int result
        +String formatted
        +void firststage()
        +void secondstage()
        +void thirdstage()
        +void main(String args)
    }
    class Performthroughexample {
        <<Service>>
        +int repeattimes
        +void secondversion()
        +void main(String args)
    }
    class Predefmsg {
        <<Service>>
        +String predefmsg
    }
    class Seqfileexample {
        <<Service>>
        +void main(String args)
    }
    class Userinput {
        <<Service>>
        +Object username
        +String name
    }

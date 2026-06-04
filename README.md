# poc-flexible-constructor-bodies

## (JEP 513: Flexible Constructor Bodies)

In Java 25, you can execute code before another constructor call,
as long as you don't access the state of the uninitialized instance.

This opens up space for validations, normalizations, and parameter transformations before delegation to another constructor.

Architecture

```
└───src
    ├───main
        ├───java
            └───com
                └───mypoc
                    └───poc_flexible_constructor_bodies
                        │   PocFlexibleConstructorBodiesApplication.java
                        │   
                        ├───domain
                        │       FaceMatchAnalysis.java
                        │       FraudAnalysis.java
                        │       LivenessAnalysis.java
                        │       
                        ├───dto
                        │       FraudAnalysisRequest.java
                        │       
                        └───service
                                FraudAnalysisService.java
````

With Flexible Constructor Bodies

Now we can prepare the parameters before delegation.

## Go deeper:

Flexible Constructor Bodies was not created to allow code before super(). It was created to eliminate artificial 
workarounds (static helper methods, extra constructors, and scattered logic) without compromising the safety of 
the object construction process.

### The real problem

Imagine:

````java
public Customer(String cpf) {
    String normalizedCpf = cpf.replaceAll("\\D", "");

    if (normalizedCpf.length() != 11) {
        throw new IllegalArgumentException();
    }

    super(normalizedCpf);
}
````

This wouldn't compile.

You were forced to do something artificial:

````java
public Customer(String cpf) {
    super(validateAndNormalize(cpf));
}
````

where:

````java
private static String validateAndNormalize(String cpf) {
    String normalizedCpf = cpf.replaceAll("\\D", "");

    if (normalizedCpf.length() != 11) {
        throw new IllegalArgumentException();
    }

    return normalizedCpf;
}
````

In other words:

- scattered logic;
- auxiliary methods with no business value;
- reduced readability;
- difficulty in debugging.

It is no longer necessary to use a static helper method to construct an object.

Output:

```
Face Match Score: 98.7
Liveness Score: 96.5
````

## References:

- https://openjdk.org/jeps/513
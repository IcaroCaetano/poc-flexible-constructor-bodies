# poc-flexible-constructor-bodies

In Java 25, you can execute code before another constructor call, as long as you don't access the state of the uninitialized instance.

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


Output:

```
Face Match Score: 98.7
Liveness Score: 96.5
````

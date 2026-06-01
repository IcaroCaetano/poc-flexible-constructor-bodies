# poc-flexible-constructor-bodies

In Java 25, you can execute code before another constructor call, as long as you don't access the state of the uninitialized instance.

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

Output:

```
Face Match Score: 98.7
Liveness Score: 96.5
````

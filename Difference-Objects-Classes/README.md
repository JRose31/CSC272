# Discussion 1
## Analyze the Difference Between Objects and Classes with Examples

### Overview
In the shortest terms, a Class is a defined structure or blueprint for code
containing specific functionality, whereas an Object is the instance of the
class once initiated/called.

### Classes
Classes contain the blueprint for specific code, typically having attributes
or fields and methods. Fields are attributes inherent to the class (they are
expected to be defined when used), and methods are essentially an inner block
of code that contains specific functionality (function) that is associated to
the class in some way. Methods often make use of the fields defined in the class
but not always.

Additionally, fields and methods contain an identifier of public or private, identifying
"who" can access the field or method respectively. When public, code from outside the
class can access the field or call the method, whereas private only enables code within
the class itself, access.

```java
public Phone(){
    // Field accessible from outside the class
    public String number;
    
    // Method accessible from outside the class
    public void call() {
        System.out.println("Calling " + number + "...");
    }
}

```

### Objects
Objects are the instantiation of the class, not a representation of the blueprint
but the actual blueprint constructed and ready to use. Once a class has been initiated
into an object, the object can then be manipulated by assigning things to fields
and making calls to methods. To perform this, the class instance must be assigned to a
variable declaring the class as the variable type and including open/closed parenthesis
for the assignment.

`Phone iPhone = new Phone();`
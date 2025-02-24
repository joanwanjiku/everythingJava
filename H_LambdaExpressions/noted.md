# Lambda
- Consists of a formal parameter list, usually but not always declared in a parenthesis, the arrow and either an expression or a code block
- e.g `(o1, o2) -> o1.lname().compareTo(o2.lastname()`
- the expression should return a value.

| anonymous class                                                                                              | lambda expression                              |
|--------------------------------------------------------------------------------------------------------------|------------------------------------------------|
| ```new Comparator<T>(){ @Override public int compareTo(T o1, T o2){ return o1.name().compareTo(o2.name())``` | ```(o1, o2) -> o1.name().compareTo(o2.name)``` |
- The lambda expression has no reference to the enclosing method.
- for Lambda The method is inferred by java.
- Java takes it's clue from the reference type, 
- Functional interfaces contains only 1 abstract methods.
- When using curly braces with a funtional method, a return is required

## Consumer
- An interface in the java.util.function pkg
- Has one abstract method that takes a single argument and return nothing(void).

### Lambda cont..
- lambda body can be a single expression or can contain a lambda body in opening and closing curly brackets.
- variable used in a lambda exp, should be final or effectively final i.e cannot be changed after.

### Functional Interfaces
1. **Consumer**:- execute code without returning data
2. **Function**:- return a result of an operation or function
3. **Predicate**:- test if condition is true or false
4. **Supplier**:- return instance of something, has no arguements

## Method References
- Provides a more compact, easier to read lambda expressions, for methods that are already defined in a class.
- Abstracts the lambda expression even further, 
- When you create variables that are lambda expr. or method references, it's important to remember that the code isn't revoked at that point.
#### Type reference
- Refers to a class name, an interface name, enum name, or record name.
- static methods are usually type references but can also be called by an instances in code.
- 
# 
## String vs StringBuilder
- String is immutable, StringBuilder is mutable. 
## Final
- final keyword can be used to make a class immutable
- final method means method cannot be overridden
- final class means class cannot be inherited
- final variable means variable cannot be changed after initialization, but can be mutated inside a method, if used in the method parameters.

## Immutable Object
- Object doesn't change state after creation.
### Creating Immutable Objects
- Make instance variables final
- Do  not use setter methods
- Use a constructor or factory method to set data.
- Mark the class as final or make all constructors private.
- Create defensive copies in getter methods.

#### Defensive copies as input
- When you pass mutable types to immutable types, you create a defensive copy of the object.
1. **Shallow copy**
- when you copy methods on interfaces and helper classes, you create a shallow copy.
- A shallow copy of an array is a copy of the reference to the array, not a copy of the array itself.
2. **Deep copy**
- when you copy methods on classes, you create a deep copy.
- A deep copy of an array is a copy of the array itself, not a copy of the reference to the array.

#### Instance initialization
- an instance inializer is a block of code declared directly in a class.
- Code gets executed when an instance of the class is created.
#### Static initialization
- A static initializer is called the first time the class is referenced.
- They are declared anywhere in the body, and executed in the order of declaration.
- Can be used to set up some environment data or log information, that is related to the class before it can be used.
#### Record Compact, Cannonical Constructor
- A record is a class that is immutable and final.
- It has a canonical constructor that is a constructor with no parameters.

### Sealed classes
- This modifier can be used for both outer types and nested types.
- When used, a permits clause is required, which is a list of types that are allowed to inherit from the sealed type.
- Should exist in the same package as the sealed type.
- 
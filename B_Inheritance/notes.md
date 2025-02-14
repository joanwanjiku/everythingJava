# Classes
- classes are organized in packages.
- You declare the package name in  the class using the package statement
- if you don't declare a package, the class implicitly belongs to the default package
## Access modifiers for the class
- A class is said to be a top-level class, if it is defined in the source code file, and not enclosed
in the code block of another class, type or method.
  - A top level class has only two valid access modifier options: public, or none
    1. public:- means any other class in any package can access this class
    2.    :- when the modifier is omitted, this means package access, only classes in the same package can access the class.

### Access modofiers for class members
  1. public:- means any other class in any package can access this class.
  2. protected:- allows access to classes in the same package and any subclasses in other packages
3.   :- When omitted, member is accessible only to classes in same package.
4. private:- No class can access this member.

**Encapsulation**
**Getters and Setters**
- Getter:- retrive value of a private field
- Setter:- set value of a private files.
- purpose of this methods is to control, protect, access to private fields.
**Constructor Chaining**
- Calling a constuctor from another constructor

**Static variable vs Instance Variables**
- static member variables of a class.
- Use class to access the static variable. instance isn't required to access the variable.
- Can be used, to declare constants, counters
- All instances share the static variable.

**Static methods vs Instance methods**
- Static methods can't access instance methods and instant variable directly.
- They're usually used for operations that don't require any data from an instance of the class(from this).

#### POJO
- A plain old java object, class that only has instance fields.
- Used to house data, pass data, between functional classes.
- might be called a bean, or a java bean.

##### Overiding a Method
- Overriding a method is when you create a method on a subclass, which has the same 
signature as a method on a super class.
- You override a parent class, when you want the child class to show different 
behaviour for that method.
##### Overidden method
- Can implement completely different behaviour, overriding behaviour of the parent.
- Can call the parent class method, include other code to run, so it can extend the functionality.
##### The Record vs POJO
- The record:- special class that contains data, that's not meant to be altered.

#### this vs Super
- 




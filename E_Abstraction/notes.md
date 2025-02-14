# Abstraction
- can generalize a set of characteristics and behaviour
## Abstract methods
- Has a method signature and return type but no method body. because of this we say its unimplemented.
- Purpose is to describe behaviour which any object of that type will always have.
- declared with abstract modifier.
- It's incomplete, you can't create an instance of an abstract class.
- It always participates in inheritance.can extend an abstract and concrete class.
## Concrete method
- has a method body, usually with atleast one statement

## Interfaces
- Interface is a special type, is like a contract between the class and the client code, by declaring using an interface, your class must implement all abstract methods on the interface
- Interface lets classes that might have little else in common be recognized as a special reference type.
- Many interfaces end with able,
- Omitting an access modifier on an interface member, it's implicitly public.
- Interfaces can be extended, using the extend keyword., interface does not implement another interface
- Records and enums can implement interfaces

### Extenstion method
- an extension method is defined by the modifier default.
- The method is concrete.
- It's like a method on a superclass because we can override it.
- 

## Interfaces vs Abstract methods
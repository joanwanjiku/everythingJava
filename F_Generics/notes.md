# Comparator vs Comparable
- **Comparator**:- has a compare method take 2 arguements, doesn't require the class itself to implement comparator
- **Comaparable**:- has a compareTo method takes 1 arguement, class has to implement Comparable, Best practise is to have this.compareTo(o)==0 result in ths.equals(o) being true.

## Generic Methods
- For a method, type parameters are placed after any modifiers and before the methods return type. i.e 
```
public <T> String myMethod(T input){ 
      return input.toString) 
} 
  ```

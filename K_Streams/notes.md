# Stream
- A sequence of elements supporting sequential and parallel operations.
- They make the code to process data uniform, consistent, and predictable.
- Stream pipelines are composed of a sequence of intermediate operations.
- Stream pipelines are executed using a terminal operation. It is the last operation in the pipeline and is required.
- After invoke the terminal operation, the stream is closed.

## Stream Sources
1. Collections
2. Arrays
- An intermiate operation can be recognized by it's signature because it returns a stream. this doesn't mean that the element type of the stream can't change.

## Stream Operations
1. Filter :- Filter elements based on a predicate
2. Distinct:- Remove duplicate elements, no arguments
3. Sorted:- Sort elements
4. Limit:- Limit the number of elements
5. Skip:- Skip the first n elements.
6. Map:- Transform elements.
7. FlatMap:- Transform elements.
8. Peek:- Perform an action. for debugging.(see elements)

## Stream terminal operations
1. Count:- Count the number of elements.
2. FindFirst:- Find the first element.
3. FindAny:- Find any element.
4. Min:- Find the minimum element.
5. 

- Stream is designed to let you process data in a declarative way, but it's not a declarative language.
## Primitive Streams
- IntStream:- 
- DoubleStream
- LongStream
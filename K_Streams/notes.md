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
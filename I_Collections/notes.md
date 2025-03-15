# Collections
## Methods
## HashCodes
- Hashing, we distribute elements into different bkts, and if the elements can reliably determine it bucket,the lookup time is reduced.

# Sets
- Not implicitly ordered.
- Contains no duplicates.
- May contain a single null element
- Methods:- add, remove, clear, contains(if exists), no retrieval.
- **Union**:- elements that are in all sets.
- **Intersection**:-
- **Difference**:-
## HashSet
- This class uses hashing mechanisms to store items.
- The hash code is used to support even distributions of objects in the set.

## LinkedHashSet
- ordered set, maintains insertion order of the elements.
- extends the HashSet, maintains relationships between elements with use of doubly linked list between entries
## TreeSet
- Uses a derivative of a binary search tree.
- Can be declared or passed to arguements typed with any of the following interfaces:- NavigableSet -> SortedSet -> Set -> Collection
- This class is sorted and implements the sortedSet interface, this set also implements NavigableSet
- Elements which implement Comparable(Said to have a natural order sort, like Strings) can be elements of a treeSet.
- If your elements don't implement Comparable, you must pass a comparator to the constructor.
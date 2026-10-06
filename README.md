Data Structure and Graph Performance Analyzer
CIT300 - Data Structures and Algorithms, Graded Practical Assignment 2


About this project

This is our submission for the Week 12 practical assignment. The task was to build a Java console app that puts arrays, stacks, queues, linked lists, searching and graphs together in one menu program, and then compare how fast the algorithms are using the number of steps and the execution time.

We called it the Data Structure and Graph Performance Analyzer. Basically you can use each data structure from the menu, and at the end there is a performance comparison option that shows linear search, binary search, BFS and DFS side by side.


What each part does

The array has a fixed size of 20. You can insert at the end, insert at a position, delete a value, search and display. Insert and delete shift the elements, so we wrote the shifting loops ourselves.

The stack is array based and holds up to 10 numbers. It has push, pop, peek and display, and it shows a message for overflow and underflow instead of crashing.

The queue is a circular queue (also array based, size 10) with enqueue, dequeue, peek and display. We used the modulus operator so the space at the front gets reused. Full and empty cases are handled.

The linked list is made of our own Node class. You can insert at the beginning, insert at the end, delete, search and display.

For searching we made linear search and binary search. The array must be sorted for binary search so it is sorted automatically when you enter numbers. You can enter your own numbers or generate 1000 random ones, and the program shows the steps and time for both searches.

The graph is undirected and stored as an adjacency list. You can add vertices, add edges, display the graph, and run BFS and DFS from any vertex. There is also a sample graph (A to F) so it can be tested quickly.

The performance comparison runs linear search, binary search, BFS and DFS and prints a table with the steps and time, with a short explanation.

Display All Results shows everything that was saved during the session.

There is input validation everywhere. If we type a letter instead of a number, or a vertex that does not exist, or search for a value that is not there, it shows a message instead of crashing.


Compiling and running

javac *.java
java Main

then just use the menu (1-9)


Files

Main.java - the menu + connects everything together
ArrayOperations.java - array part
StackOperations.java - stack part
QueueOperations.java - queue part
LinkedListOperations.java - linked list part
SearchOperations.java - linear search and binary search
GraphOperations.java - graph + BFS/DFS
PerformanceComparison.java - the performance comparison table
InputHelper.java - reads the input and checks it
ResultLog.java - saves results for Display All Results


Group members

Member 1 (Team Leader)
Name: Askhan Musammil
Student ID: 23DA2-1106
Responsibility: Array and searching implementation, main menu, performance comparison and integration
Roles:
- wrote ArrayOperations.java (insert at end, insert at position, delete, search, display)
wrote SearchOperations.java (linear search, binary search and the comparison of both)
- handled the array shifting and the automatic sorting for binary search
- wrote Main.java (the menu)
- wrote PerformanceComparison.java (steps and time table with explanation)
- wrote InputHelper.java (input validation) and ResultLog.java (Display All Results)
- joined all the parts after the branches were merged
- tested the array, searching and the full program and wrote this README

Member 2
Name: M.H.Muhammed
Student ID: 23DA2-0533
Responsibility: Stack and queue implementation
Roles:
- wrote StackOperations.java (push, pop, peek, display, overflow and underflow messages)
- wrote QueueOperations.java (enqueue, dequeue, peek, display, circular queue)
- handled the full and empty cases for both
- tested the stack and queue parts

Member 3
Name: M.A.M.Afras
Student ID: 23DA2-0705
Responsibility: Linked list implementation
Roles:
- wrote LinkedListOperations.java (insert at beginning, insert at end, delete, search, display)
- made the Node class and handled the empty list case
- tested the linked list part

Member 4
Name: H.A.M.Maash
Student ID: 23DA2-0472
Responsibility: Graph implementation and BFS/DFS traversal
Roles:
- wrote GraphOperations.java (add vertex, add edge, display)
- implemented BFS and DFS traversal with step count
- added the sample graph (A to F) for quick testing
- tested the graph and both traversals

All members
- overall testing and debugging
- this README
- the video demonstration
- GitHub collaboration (commits, branches, pull requests)


Performance result

We tested with 1000 sorted numbers, searching for the last number, and the sample graph with 6 vertices.

Linear search - 1000 steps
Binary search - 10 steps
BFS - 18 steps
DFS - 18 steps

Linear search checked every number but binary search only needed 10 steps because it cuts the data in half each time. BFS and DFS took the same steps because both visit every vertex and check every edge once, only the order is different. The time in nanoseconds changes every time we run it, so we compared using the steps.


Time complexity

Array insert / delete - O(n)
Stack push / pop / peek - O(1)
Queue enqueue / dequeue / peek - O(1)
Linked list insert at beginning - O(1)
Linked list insert at end / delete / search - O(n)
Linear search - O(n)
Binary search - O(log n)
BFS and DFS - O(V + E)


GitHub work

Everyone worked in their own branch and did small commits, then made a pull request into main. The integration branch was merged last.

feature/array-searching - Member 1
feature/stack-queue - Member 2
feature/linked-list - Member 3
feature/graph - Member 4
feature/integration-performance - Member 1

We also used the Issues tab to write down our tasks.


A note on how we built this

We kept things basic on purpose. The array, stack and queue use plain arrays and the linked list uses our own Node class, so we did not call Java's Stack, Queue or LinkedList classes. The graph and the result log do use ArrayList to store their data. We also used java.util.Arrays for sorting and Random for the 1000 random numbers.

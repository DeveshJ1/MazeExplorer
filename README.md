**Maze Explorer**<br>
I created a program that uses a stack and queue, to explore a maze and, hopefully, find a way out of it. Generally, I start from some initial position within 
the maze and evaluate the neighboring spaces until either you find a way out, or you discover that there is no way out. We will try two methods of using
a stack and a queue.<br>
The other goal of this programming project is for you to master:<br>
-working with multi-file programs<br>
-writing classes<br>
-implementing existing interfaces<br>
-working with existing code<br>
-implementing your own doubly linked list<br>
-implementing your own stack and queue<br>
Labyrinth Class: represents a 2D rectangular maze<br>
LabyrinthSearchException Class: defines the exception thrown by the Labyrinth class during the search process<br>
Simulation Class: the actual program that simulates an exploration of a maze. The program runs expecting two command line arguemnts where the first is the name
of an input text file which contains the maze. The second argument should be stack or queue(or at least a word that starts with s or q) which indicates which
structure we will be using the get out of the maze.<br>
PossibleLocations Interface: provides requirements for the stack and queue classes<br>
Location Class: represents a position/location of a single square in the maze<br>
SquareType Enum: describes different types of squares in the maze<br>
DoublyLinkedList Class: implementation of a linked list which contains pointer to the next node and previous node<br>
StackOfSpaces Class: uses the doubly linked list to implement a stack according to the Possible Locations Interface<br>
QueueOfSpaces Class: uses the doubly linked list to implement a queue according to the Possible Locations Interface<br>



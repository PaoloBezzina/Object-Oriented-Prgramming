# CPS2004-SEM1-A-2021: Object Oriented Programming - Assignment

Task 1:
A generic region quadtree data structure was built, which was used to represent a 1-bit colour image (black and white only). 
The quadtree holds boolean values in its leaves where true will indicate ‘on’ (or ‘white’) and false will indicate ‘off’ (or ‘black’).
A region quadtree represents a rectangular 2D space. This space is recursively subdivided into four quadrants in somespecific order (e.g. NW, NE, SE, SW).
The root node represents the whole 2D image. Each node is either a leaf node or has four children (representing each quadrant).
Each leaf node is either black or white and represents a block of pixels of that colour. 
Any quadtree node may be in three states: black, white, and intermediate.
Intermediate nodes will have four children which represent the next (recursive) subpartitioning of the nodes 2D space.
The images represented as regional quadtrees are stored in text files. There are two different formats supported, a textual
format including a grid of T or F values, as well a CSV format, including the coordinates for 'white' values.

Task 2:
An internet banking platform is a facility where bank account holders can view, move money, i.e. transact and add/remove instructions to their accounts.
There are two kinds of accounts: savings and current accounts.
Each account is either individual or joint with one or more bank account holder.
An account stores various pieces of information, such as balance, transactions, and currency.
Zero, one or more bank cards can be associated with an account.
The banking platform also has two kinds of users, 1) regular users and 2) adminstrators.
Administrators are allowed to approve new accounts or close accounts, or new cards. 
Regular users can apply to open or close accounts or bank cards.
The system was also built in such a way for it to facilitate future changes such as:
* Audit trails - every action by a user needs to produce a lognso that any fraudulent activity can be investigated by competent authorities and scenarios recreated.
* Bank holidays: Disable functionality such as moving money whenever there is a bank holiday.

Task 3:
MyUint is a templated integer library that supports integers, from 1-bit to 2048-bits.
This library only supports unsigned integers with 2^n bits. A compilation error is emitted if the user tries to use an arbitrary length integer.
All generic integer operations were overwitten to be supported by the myuint library. These include:
* Addition and Subtraction
* Addition and Subtraction to the number itself
* Increment and Decrement (default is set to increment by 1 but can be by and set value)
* Multiplication and division.
* Modulus
* Left and Right Binary Shifts
* Greater Than, Less Than and Equal To

### Dependencies (not limited to)

* Java 1.8.0_301
* Ubuntu 9.3.0-17ubuntu1~20.04
* C++ 9.3.0

### Executing program
Each Task has its own seperate 'run.sh' file. This can be run to execute each of the task using an integrated terminal.
```
bash run.sh
```

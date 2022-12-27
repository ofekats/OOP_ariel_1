# OOP_ariel_1
## The purpose of the assignment
In this assignment we will add some more functionality to the UndoableStringBuilder
which we built in a previous assignment:  
o We will add an option to organize a group of receivers of updates on the status of UndoableStringBuilder and senting all updates in real time.  
o We will add tracking of the size of the object in the Heap.  
## How to use our code
Download from github of the folder ""  
The code files: 
    o GroupAdmin.java
    o ConcreteMember.java    
    o UndoableStringBuilder.java  
    o Member.java  
  o Sender.java  
  o JvmUtilities.java  
  
The test files:  
  o Tests.java  
  o JvmUtilities.java  
## GroupAdmin
### features
constructs admin that have a list of members, can registe or unregiste to/from that list.  
in addition, admin have UndoableStringBuilder, can insert/append/delete/undo to that var, in every change the admin update each member that in the list.  
## ConcreteMember.
### features
constructs members (name, admin , pointer to admin's UndoableStringBuilder(shallow copy)) to get update from the admin.  
## observer java design pattern
The Observer design pattern is a way to establish a relationship between objects such that when one object (called the subject) changes state, all of its dependents (called observers) are notified and updated automatically.  
we defined two interfaces: one for the subject and one for the observers. The subject interface contains methods for attaching and detaching observers, as well as a method for notifying them when the subject's state changes.  
## UndoableStringBuilder
The UndoableStringBuilder is a custom class that extends the functionality of the StringBuilder class in the Java Standard Library. It allows you to build a string by appending characters or substrings to it, just like a StringBuilder, but also provides methods for undoing the last operation you performed on the string.  

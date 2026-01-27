What is a POJO?
==============

### The question should be asked what behavior a POJO should not have instade?

- Can't Extend anyThing
- Can't Implement anyThing
- Can't have any Annotation

### A Simple Class that does not need any extra stuff.

And Tobe a JAVA Bean?
====================

- Must be a POJO
- All properties must be private
- Must have Public Getter and Setter for each property
- Must be Serializable(Serializable is a Marker Interface that TELL JVM that this class can be written in other
  Databases and files)
- Must have a No-Arg Constructor NOTE: we need No-Arg Constructor for Serialization

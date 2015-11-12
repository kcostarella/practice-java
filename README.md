# practice-java


A set of practice Java problems


Problems and their related test files are compiled as such:


javac [type]Stuff.java [type]Tests.java\n


where [type] can currently be: Array, IntList, and String.

To test a method defined in [type], the main defined in [type]Tests.java must be
called with the appropiate test name and parameters. Current test name and
parameters given as follows:


[type]Tests.java

$ [method name] [args 0]...[args n]\n

# [a Description of the method and its arguments] #


StringTests.java

$ replace string target source

# replaces all occurences of target with source in string #


$ permutation s1 s2
# returns wether or not s1 is a permutation of s2 #



ArrayTets.java
$ merge a b
#Merges a, a is a sequence of numbers/letters with no spaces (ie. 123A) with b. assumes that both a and b are sorted. #


$ mergesort a
#Sorts a, a is a sequence of numbers/letters with no spaces (ie. 138FHA)#


IntListTests.java (compile with IntList.java NOT IntListStuff.java)

#Currently only tests the reversal of an IntList.\n

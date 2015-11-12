# practice-java
A set of practice Java problems\n
Problems and their related test files are compiled as such:\n
javac [type]Stuff.java [type]Tests.java\n
where [type] can currently be: Array, IntList, and String.\n
To test a method defined in [type], the main defined in [type]Tests.java must be
called with the appropiate test name and parameters. Current test name and
parameters given as follows:\n\n
[type]Tests.java\n
\t [method name] [args 0]...[args n]\n
\t\t - [a Description of the method and its arguments]\n\n
StringTests.java\n
\t replace string target source\n
\t\t -  replaces all occurences of target with source in string\n
\t permutation s1 s2\n
\t\treturns wether or not s1 is a permutation of s2\n\n
ArrayTets.java\n
\t merge a b\n
\t\t - Merges a, a is a sequence of numbers/letters with no spaces (ie. 123A) with b. assumes that both a and b are sorted.\n
\t mergesort a\n
\t\t - Sorts a, a is a sequence of numbers/letters with no spaces (ie. 138FHA)\n\n
IntListTests.java (compile with IntList.java NOT IntListStuff.java)\n
\t #Currently only tests the reversal of an IntList.\n

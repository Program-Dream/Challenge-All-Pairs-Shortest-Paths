# Program Dream Challenge: All Pairs Shortest Paths
Program Dream Coding Challenge: All Pairs Shortest Paths

## Main Idea of the Software Project
 1. Read the file and parse the text input
 2. Build a graph struture based on the values
 3. Execute your algorithm implementation on the graph
 4. Print the output in the required format to a file

## Input format
```
3
A ----> B
B --> A
c --------> B
B ----> C
...
```
where the amount of minus symbols `-` is the weight of the edge between the two vertices. 
The direction of the arrow gives the direction of the edge.
And the number in the first line is the amount of nodes the graph has.

## Output format
```
(A, C): A -> B -> C, total = 8
...
```
This line contains the shortest path between A and C. This path starts at A, continues to B and ends at C. The total weight of all visited edges is 8.  

To make the output more useful (e.g. if you want to base another application on it that uses this data for naviagtion or similar) and to make it deterministic, it should be sorted.
The required sorting should be ascending based on these criterias:
1. total weight (start with lowest total weight)
2. amount of vertices/ edges visited (start with shortest path string. this rule is only applied if 2 tuples have equal weight)
3. alphabetical (if tuples have the same weight & the same length, the string should be sorted alphabetically starting with 'A')

*Alternative: if the output format described above appears to be too complex/ too long or difficult to verify, we could just use the total of all total weights to have one number as output for this challenge.*

## Reference Implementation
The demo/ reference implementation was done in Java and can be found in the src folder. It uses Java 18 and can be executed using maven.

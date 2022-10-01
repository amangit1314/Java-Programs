
/*
Problem -> Solve History Ranking

DUMB JERRY
DUMB JERRY

Problem Statement

As usual, Jerry and Tom are fighting. Tom wants to prove that Jerry is Dumb, So he made a problem and asked jerry.

Given a sequence A of size N, and an operation.

In one operation you can pick an element either from the front or back of the Sequence and write it down and delete it from the array.
Jerry has to perform the given operation until sequence A becomes empty.

Tom wants the written sequence to be lexicographically maximum possible by performing the given operation on sequence A.

Jerry can’t solve the problem on his own. So you have to help him.

Note:-

Sequence X of length N is lexicographically greater than Sequence Y of length N, if there exist such i (1<=i<=N), that Xi >Yi and for any j (1<=j<i) Xi=Yi.

Constraint

• 1 <= N <= 105
• 0 <= Ai <= 109

• All input values are integer.

Input Format

• First-line contains N, length of the sequence A

• Second line contains N space-separated integers denoting the sequence A.

Output Format

• In first print the lexicographically maximum sequence made by performing operations on sequence A

Sample Input 1

3

3 1 2

Sample Output 1

3 2 1

Explanation of Sample 1

For test case1

We get sequence {3,1,2} if we
Pick the element from the front of the sequence (3) and delete it from the original sequence {1,2}
Pick the element from the front of the sequence (3,1) and delete it from the original sequence {2}
Pick the element from the front of the sequence (3,1,2) and delete it from the original sequence {}
We get sequence {3,2,1} if we
Pick the element from the front of the sequence (3) and delete it from the original sequence {1,2}
Pick the element from the back of the sequence (3,2) and delete it from the original sequence {1}
Pick the element from the front of the sequence (3,2,1) and delete it from the original sequence {}
We get sequence {2,3,1} if we
Pick the element from the back of the sequence (2) and delete it from the original sequence {3,1}
Pick the element from the front of the sequence (2,3) and delete it from the original sequence {1}
Pick the element from the front of the sequence (2,3,1) and delete it from the original sequence {}
We get sequence {2,1,3} if we
Pick the element from the back of the sequence (2) and delete it from the original sequence {3,1}
Pick the element from the back of the sequence (2,1) and delete it from the original sequence {3}
Pick the element from the front of the sequence (2,1,3) and delete it from the original sequence {}
Compare to other {3,2,1} is lexicographically largest.

Things to Note for the Candidate

You can use your own IDE like Visual Studio Code, Eclipse, or any other IDE that you are comfortable with to build your solution code.
The IDE provided on the platform is purely for submission. Avoid using the IDE for coding out the solution.
Test against any custom input in your own IDE. In the IDE provided on the platform, you cannot pass custom test cases and see the output.
Use standard input and standard output in your program for the IDE to run the test cases smoothly against your code. We are giving a sample problem statement along with a solution that will pass the test cases in the IDE. - Sample Problem Statement  (Right Click and Open in New Tab to view.)



 */


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Relevel_Test
{

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] x = new int[m];
        int[] y = new int[n];

        for (int a : x) {
            x[a] = sc.nextInt();
        }

        for (int b : y) {
            y[b] = sc.nextInt();
        }
    }

    public static int solve() {

    }
}

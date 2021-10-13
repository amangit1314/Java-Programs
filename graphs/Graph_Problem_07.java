package graphs;

import java.util.Vector;

/*
* Minimum steps to reach target by a Knight | Set 1
Difficulty Level : Hard
Last Updated : 16 Jul, 2021
Given a square chessboard of N x N size, the position of Knight and position of a target is given. We need to find out the minimum steps a Knight will take to reach the target position.
Examples:


In above diagram Knight takes 3 step to reach
from (4, 5) to (1, 1) (4, 5) -> (5, 3) -> (3, 2)
-> (1, 1)  as shown in diagram


Attention reader! Don’t stop learning now. Get hold of all the important DSA concepts with the DSA Self Paced Course at a student-friendly price and become industry ready.  To complete your preparation from learning a language to DS Algo and many more,  please refer Complete Interview Preparation Course.

In case you wish to attend live classes with experts, please refer DSA Live Classes for Working Professionals and Competitive Programming Live for Students.

Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.

Approach:
This problem can be seen as shortest path in unweighted graph. Therefore we use BFS to solve this problem. We try all 8 possible positions where a Knight can reach from its position. If reachable position is not already visited and is inside the board, we push this state into queue with distance 1 more than its parent state. Finally we return distance of target position, when it gets pop out from queue.
Below code implements BFS for searching through cells, where each cell contains its coordinate and distance from starting node. In worst case, below code visits all cells of board, making worst-case time complexity as O(N^2)

* */
public class Graph_Problem_07 {
    static class cell{
        int x,y;
        int dis;
        public cell(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isInside(int x, int y, int N){
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    static int minStepToReachTarget(int[] knightPos, int[] targetPos, int N){
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Vector<cell> q = new Vector<>();

        cell t;
        int x, y;
        boolean[][] visit = new boolean[N + 1][N + 1];

        for(int i=1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                visit[i][j] = false;

        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()){
            t = q.firstElement();
            q.remove(0);

            if(t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            for(int i = 0; i < 8; i++){
                x = t.x + dx[i];
                y = t.y + dy[i];

                if(isInside(x,y, N) && !visit[x][y]){
                    visit[x][y] = true;
                    q.add(new cell(x,y, t.dis+1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 30;
        int[] knightPos = { 1, 1 };
        int[] targetPos = { 30, 30 };
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
}
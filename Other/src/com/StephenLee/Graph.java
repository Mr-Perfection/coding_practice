package com.StephenLee;
import java.util.Collection;
/**
 * Created by StephenLee on 5/31/16.
 */
public class Graph {

    private final int V;    //Number of vertices (nodes)
//    private final int E;
    private int[][] adj;    //adjacent matrix
    private boolean marked[];  //mark all the visited nodes
    /* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
    public Graph(int v) {
        V = v;
        adj = new int[v][v];    //initialize an array of neighbors for each vertex
        marked = new boolean[v];

    }
    public Graph(int[][] matrix)
    {
        int i,j;
        V = matrix.length;
        adj = new int[V][V];
        marked = new boolean[V];
        for(i=0;i<V;++i)
        {
            for (j=0;j<V;++j)
            {
                adj[i][j] = matrix[i][j];
            }   //EOF for j
        }   //EOF for i

    }

    public void dfs(int i)
    {
        marked[i] = true;   //mark true for ith vertex
        for(int j=0;j<adj.length;++j)
        {
            if(!marked[j] && adj[i][j] > 0)
                dfs(j);
        }

    }

    public void clearVisited()
    {
        for(int i=0;i<V;++i)
        {
            marked[i] = false;
        }
    }
    /****
     *
     * this one goes to main(args[]){}
     *
     *         //                        0  1  2  3  4  5  6  7  8
     // ===================================================
     int[][] conn = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
     { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
     { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
     { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
     { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
     { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
     { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
     { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
     { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

     com.StephenLee.Graph G = new com.StephenLee.Graph(conn);

     G.clearVisited();
     G.dfs(0);

     *
     * *****/



}

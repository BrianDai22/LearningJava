package SatAndWedClass20182020;

public class bipartite {
}
/*
Given an undirected graph, return true if and only if it is WednesdayClass.bipartite.
a graph is WednesdayClass.bipartite if we can split its set of nodes into two independent subsets A and B,
such that every edge in the graph has one node in A and another node in B.
graph[i] is a list of indexes j for which the edge between nodes i and j exists.
Each node is an integer between 0 and graph.length - 1.
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
 */
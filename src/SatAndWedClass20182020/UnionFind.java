package SatAndWedClass20182020;

public class UnionFind {
    public int[] father;
    public int m;
    public int n;
    public int count=0;

    // purpose : convert 2D grid into 1D flat array
    public UnionFind(char[][]grid){
        m = grid.length; // row length
        n = grid[0].length; // column length
        father = new int[m*n]; // WednesdayClass.flatten Grid
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == '1'){
                    int id = i*n+j;
                    father[id]=id;
                    count++;
                }
            }
        }
    }

    // union 2 nodes
    public void union(int id1, int id2){
        int find1 = find(id1); // find root for id1
        int find2 = find(id2); // find root for id2
        if(find1 != find2){ // they are not connected yet
            father[find1] = find2; // connect, set find2 is the father of find1
            count--;
        }
    }

    public int find(int node){
        if(father[node]==node) // the node is root
            return node;
        return find(father[node]); // value of father[node] is index of your father

    }
}


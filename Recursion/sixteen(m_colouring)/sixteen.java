import java.util.ArrayList;
public class sixteen{
    //? M colouring
    //? Given a graph and m colours, we need to colour the graph such that no two 
    //? adjacent vertices have the same colour.
    public static void main(String[] args){
        int v = 4;
        int m = 3;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3},
            {2, 3}
        };
        int color[] = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createAdjList(edges,adj);
        System.out.print(mColouring(0,v,adj,color,m));
    }
    static boolean mColouring(int node,int n,ArrayList<ArrayList<Integer>> adj,int[] color,int m){
        if(node == n) return true;
        for(int i=1;i<=m;i++){
            if(isSafe(node,adj,color,i)){
                color[node] = i;
                if(mColouring(node+1,n,adj,color,m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    static void createAdjList(int[][] edges,ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<edges.length;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }
    static boolean isSafe(int node,ArrayList<ArrayList<Integer>> adj,int[] color,int col){
        for(int el : adj.get(node)){
            if(color[el]==col) return false;
        }
        return true;
    }
}
import java.util.*;
class Node{
    int f;
    int s;
    Node(int f, int s){
        this.f = f;
        this.s=s;
    }
}
class myClass{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
     ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
    for(int i =0;i<=v;i++){
     adj.add(new ArrayList());
    }
    for(int i =0;i<e;i++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        adj.get(x).add(y);
    }
        ArrayList<Integer> bfs = new ArrayList<>();
         ArrayList<Integer> dfs = new ArrayList<>();
        bfs(v,bfs,adj);
        System.out.println("BFS traversal of graph -> " +bfs);
        dfs(v,dfs,adj);
        System.out.println("DFS traversal of graph -> " +dfs);
         boolean g= detectCycle(v,adj);
        if(g) System.out.println("Yes forming a cycle");
        else System.out.println("No,there is no cycle");

    }
   public static  boolean detectCycle(int v,ArrayList<ArrayList<Integer>>adj){
        boolean[]visited = new boolean[v+1];
        for (int i = 1; i <=v; i++) {
            if(!visited[i])
                if(cycle(v,visited,adj)) return true;
        }
        return false;
    }

    public static void Dfs(int v, int node,ArrayList<Integer>dfs , ArrayList<ArrayList<Integer>>adj,boolean[]visited ){
        visited[node] = true;
        dfs.add(node);
        for(int j :adj.get(node)){
            if(!visited[j])
                Dfs(v,j,dfs,adj,visited);
        }
    }
    public static void dfs(int v, ArrayList<Integer>dfs , ArrayList<ArrayList<Integer>>adj){
        boolean[]visited = new boolean[v+1];
        for (int i = 1; i <=v ; i++) {
            if(!visited[i]){
                Dfs(v,i,dfs,adj,visited);
            }
        }
    }
    public static void  bfs(int v, ArrayList<Integer>bfs , ArrayList<ArrayList<Integer>>adj ){
        boolean[]visited = new boolean[v+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int j:adj.get(node)){
                if(!visited[j]){
                    q.add(j);
                    visited[j]=true;
                }
            }
        }

    }
}

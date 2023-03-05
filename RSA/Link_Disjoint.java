import java.util.*;
 
class Link_Disjoint
{
    int source;
    int Destination;
    int arr[][];
    int value=0;
    public Link_Disjoint(int a,int b, int[][] arr){
        this.source=a;
        this.Destination=b;
        this.arr=arr;
    }
    HashMap<ArrayList<Integer>,Integer> maping=new HashMap<>();
    
    ArrayList<Integer> bfs(int graph[][], int s,int t)
    {
        Queue<Integer> pendingVertices=new LinkedList<>();
        HashMap<Integer,Integer> maps=new HashMap<>();
        boolean visited[]=new boolean[graph.length];
        visited[s]=true;
        pendingVertices.add(s);
        maps.put(s, -1);
        boolean pathfound=false;
        while(!pendingVertices.isEmpty()){
            
            int current=pendingVertices.remove();
            for(int i=0;i<graph.length;i++){
                
                if(graph[current][i] > 0 && !visited[i]){
                    
                    
                    pendingVertices.add(i);
                    visited[i]=true;
                    maps.put(i, current);
                    if(i==t){
                        value=value+graph[current][i];
                        System.out.println(value);
                        pathfound=true;
                        break;
                    }
                }
            }
        }
        if(pathfound){
            ArrayList<Integer> array2=new ArrayList<>();
            int currentv=t;
            while(currentv!=-1){
                array2.add(currentv);
                int parent=maps.get(currentv);
                currentv=parent;
            }
            
            return array2;

        }
        else{
            return null;
        }
    }

void findDisjointPaths(int graph[][], int s, int t)
{

    ArrayList<ArrayList<Integer>> array2=new ArrayList<>();
    while(true)
    {
        // array2.add(new ArrayList<Integer>());
        value=0;
        array2.add(array2.size(), bfs(graph, s, t));
        // array=bfs(graph, s, t);
        if(array2.get(array2.size()-1)==null){
            break;
        }
        ArrayList<Integer> arr=array2.get(array2.size()-1);
        for(int j=0;j<arr.size()-1;j++){
            int a=arr.get(j);
            int b=arr.get(j+1);
            graph[a][b]=0;
            graph[b][a]=0;

        }
        
        maping.put(array2.get(array2.size()-1),value);
        
        
    }
    
}
    HashMap<ArrayList<Integer>, Integer> call() {
        findDisjointPaths(arr, source, Destination);
        System.out.println(maping);
        return maping;
    }

    public static void main(String args[]){
        int arr[][] = 
            {{0, 21, 15, 0, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0},
            {21, 0, 12, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {15, 12, 0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 30, 0, 0, 12, 0, 0, 0, 0, 0, 39, 0, 0, 0},
            {0, 0, 0, 12, 0, 11, 12, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 36, 0, 11, 0, 0, 0, 0, 21, 0, 0, 0, 36},
            {0, 0, 0, 0, 12, 0, 0, 15, 0, 27, 0, 0, 0, 0},
            {48, 0 ,0 ,0, 0, 0, 15, 0, 15, 0, 0, 0, 0, 0},
            {0, 0, 0 ,0, 0, 0 ,0 ,15, 0, 15 ,0, 6, 6, 0},            
            {0 ,0 ,0 ,0 ,0 ,21, 27, 0 ,15, 0, 0 ,0, 0, 0},
            {0 ,0 ,0 ,39, 0, 0, 0, 0, 0 ,0 ,0, 12, 15, 0},
            {0 ,0 ,0 ,0, 0 ,0 ,0 ,0, 6, 0 ,12, 0, 0, 6},   
            {0 ,0, 0, 0 ,0 ,0 ,0, 0 ,0 ,6 ,0 ,15 ,0, 0 ,3},
            {0 ,0 ,0 ,0 ,0, 36, 0 ,0,0 ,0 ,0 ,6, 3 ,0}};
            
        Link_Disjoint ob = new Link_Disjoint(0, 7, arr);
        ob.call();
    }
}

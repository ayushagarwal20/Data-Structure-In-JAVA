import java.util.ArrayList;
import java.util.List;
public class Paths {
    int v;
    private ArrayList<Integer>[] adjList;
    ArrayList<Integer> source=new ArrayList<>();
    ArrayList<Integer> dest=new ArrayList<>();
    ArrayList<Integer> weight=new ArrayList<>();
    

    public Paths(int vertices)
    {
        this.v = vertices;
        initAdjList();
    }
    @SuppressWarnings("unchecked")
    private void initAdjList()
    {
        adjList = new ArrayList[v];
 
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    public void addEdge(int u, int v, int w)
    {
        adjList[u].add(v);
        source.add(u);
        dest.add(v);
        weight.add(w);
    }
    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
 
        // add source to path[]
        pathList.add(s);
        int count=0;
 
        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList,count);
    }
    private void printAllPathsUtil(Integer u, Integer d,boolean[] isVisited, List<Integer> localPathList,int count)
    {
 
        if (u.equals(d)) {
            for(int i=0;i<localPathList.size()-1;i++){
                for(int j=0;j<dest.size();j++){
                    if(localPathList.get(i)==source.get(j))
                    {
                        if(localPathList.get(i+1)==dest.get(j)){
                            count=count+weight.get(j);
                        }
                    }
                }
            }
            System.out.println(localPathList+" "+count);
            return;
        }
 
        // Mark the current node
        isVisited[u] = true;
 
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList,count);
 
                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }
 
        // Mark the current node
        isVisited[u] = false;
    }
 
    // Driver program
    public static void main(String[] args)
    {
        // Create a sample graph
        Paths g = new Paths(14);
        g.addEdge(0, 7,48);
        g.addEdge(7, 0,48);
        g.addEdge(0, 1,21);
        g.addEdge(1, 0,21);
        g.addEdge(2, 0,15);
        g.addEdge(0, 2,15);
        g.addEdge(1, 2,12);
        g.addEdge(2, 1,12);
        g.addEdge(1, 3,30);
        g.addEdge(3, 1,30);
        g.addEdge(2, 5,36);
        g.addEdge(5, 2,36);
        g.addEdge(3, 4,12);
        g.addEdge(4, 3,12);
        g.addEdge(3, 10,39);
        g.addEdge(10, 3,39);
        g.addEdge(4, 5,13);
        g.addEdge(5, 4,13);
        g.addEdge(4, 6,12);
        g.addEdge(6, 4,12);
        g.addEdge(5, 9,21);
        g.addEdge(9, 5,21);
        g.addEdge(5, 13,36);
        g.addEdge(13, 5,36);
        g.addEdge(6, 7,15);
        g.addEdge(7, 6,15);
        g.addEdge(6, 9,27);
        g.addEdge(9, 6,27);
        g.addEdge(7, 8,15);
        g.addEdge(8, 7,15);
        g.addEdge(11, 8,6);
        g.addEdge(8, 11,6);
        g.addEdge(8,12,6);
        g.addEdge(12,8,6);
        g.addEdge(10,11,12);
        g.addEdge(11,10,12);
        g.addEdge(10,12,15);
        g.addEdge(12,10,15);
        g.addEdge(11,13,6);
        g.addEdge(13,11,6);
        g.addEdge(12,13,3);
        g.addEdge(13,12,3);
        int s = 2;
        int d = 3;
        
        // System.out.println("Following are all different paths from "+ s + " to " + d);
        // g.printAllPaths(s, d);
        for(int i=0; i < 4; i++)
        {
            for(int j=0; j < 4 ;j++){
                if(i==j)
                    continue;
                else
                g.printAllPaths(i, j);
            }
        }
    }
}
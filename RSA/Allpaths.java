import java.util.*;
public class Allpaths {
    int v;
    ArrayList<Integer>[] adjList;
    ArrayList<Integer> source=new ArrayList<>();
    ArrayList<Integer> dest=new ArrayList<>();
    ArrayList<Integer> weight=new ArrayList<>();
    ArrayList<ArrayList<Integer>> allpaths = new ArrayList<>();    
    

    public Allpaths(int vertices)
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
        int count = 0;
 
        // add source to path[]
        pathList.add(s);
 
        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList, count);
         
        
    }
    private void printAllPathsUtil(Integer u, Integer d,boolean[] isVisited, List<Integer> localPathList,int count)
    {
 
        if (u.equals(d)) {
            for(int i=0;i<localPathList.size()-1;i++){
                for(int j=0;j<dest.size();j++){
                    if(localPathList.get(i)==source.get(j))
                    {
                        if(localPathList.get(i+1)==dest.get(j)){
                            count += weight.get(j);
                        }
                    }
                }
            }
            
                allpaths.add(new ArrayList<>());
                for(int c=0;c<localPathList.size();c++){
                    allpaths.get(allpaths.size()-1).add(localPathList.get(c));
                }
                
                allpaths.get(allpaths.size()-1).add(0, count);
            
            
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
        Allpaths g = new Allpaths(14);
        int data[][] = 
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

            for(int k=0;k<data.length;k++){
                for(int c=0;c<data.length;c++){
                    if(data[k][c]>0){
                        g.addEdge(k,c,data[k][c]);
                    }
                }
            }
        
        int s = 2;
        int d = 3;
        g.printAllPaths(s, d);    
        System.out.println(g.adjList.length);
        
        Collections.sort(g.allpaths, new Comparator<ArrayList<Integer>>() {    
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o1.get(0) - o2.get(0);
        }               
        });

        // System.out.println(g.allpaths);
    }
}
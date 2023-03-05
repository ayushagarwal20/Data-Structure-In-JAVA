import java.util.*;
public class path{
    ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    void call(int data[][]){
        for(int i=0;i<data.length;i++){
            arr.add(new ArrayList<>());
            for(int j=0;j<data.length;j++){
                if(data[i][j]>0){
                    arr.get(i).add(j);
                }
            }
        }
        System.out.println(arr);
    }
    void shortestPath(int src, int dest, ArrayList<ArrayList<Integer>> arr){
        
    }
    public static void main(String args[]){
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

            path p=new path();
            p.call(data);
    }
    
}
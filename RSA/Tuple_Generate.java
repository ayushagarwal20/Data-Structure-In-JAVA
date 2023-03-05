import java.util.*;
import java.io.*;
import java.security.*;

public class Tuple_Generate {

    private static int size;
    private static int G[][];
    private static int no_of_tuples;
    List<List<Integer>> tuple = new ArrayList<>();

    public Tuple_Generate() {
        size = 0;
    }

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        Scanner fileContent = null;
        Tuple_Generate ob = new Tuple_Generate();
        System.out.println("1. 14 Node NSF Network");
        System.out.println("2. 24 Node INDIAN Network");
        System.out.println("3. 28 Node EUROPEAN Network");
        System.out.println("4. 12 Node JAPANESE Network");
        System.out.print("Enter your choice : ");
        int ch = sc.nextInt();
        System.out.print("Enter no of source, destination pairs to generate : ");
        no_of_tuples = sc.nextInt();
        switch (ch) {
            case 1:
                size = 14;
                try {
                    fileContent = new Scanner(new File("Node Networks\\NSF.txt"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                size = 24;
                try {
                    fileContent = new Scanner(new File("Node Networks\\INDIAN.txt"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                size = 28;
                try {
                    fileContent = new Scanner(new File("Node Networks\\EUROPEAN.txt"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                size = 12;
                try {
                    fileContent = new Scanner(new File("Node Networks\\JAPANESE.txt"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid input!!");
                return;
        }
        G = new int[size][size];
        ob.extractGraph(fileContent);
        ob.formTuples();
        ob.storeOutput();
        // ob.display();
    }

    public void extractGraph(Scanner f) {
        int i = 0, j = 0;
        while (f.hasNextLine()) {
            String temp = f.nextLine();
            String num = "";
            temp = temp + " ";
            for (int c = 0; c < temp.length() - 1; c++) {
                char ch = temp.charAt(c);
                if (ch != ' ') {
                    num = num + String.valueOf(ch);
                } else {
                    G[i][j++] = Integer.parseInt(num);
                    num = "";
                }
            }
            j = 0;
            i++;
        }
    }

    public void formTuples() {
        SecureRandom rand = new SecureRandom();
        while (tuple.size() != no_of_tuples) {
            int t1 = rand.nextInt(size);
            int t2 = rand.nextInt(size);
            int t3 = rand.nextInt(10) + 1;
            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(t1, t2, t3));
            if (t1 != t2 && !tuple.contains(temp)) {
                tuple.add(Arrays.asList(t1, t2, t3 * 40));
            }
        }
    }

    public void storeOutput() {
        try {
            new FileWriter("Output.txt", false).close();
            FileWriter writer = new FileWriter("Output.txt", true);
            for(int i = 0; i < tuple.size(); i++){
                Link_Disjoint out = new Link_Disjoint(tuple.get(i).get(0),tuple.get(i).get(1),G);
                // ArrayList<ArrayList<Integer>> temp = out.call();
                HashMap<ArrayList<Integer>,Integer> temp = out.call();
                // temp.add(new ArrayList<Integer>());
                // temp.get(0).add(1);
                // temp.get(0).add(4);
                // temp.get(0).add(2);
                // temp.add(new ArrayList<Integer>());
                // temp.get(1).add(1);
                // temp.get(1).add(5);
                // temp.get(1).add(6);
                // temp.get(1).add(2);

                // temp.add(new ArrayList<Integer>());
                // temp.get(2).add(1);
                // temp.get(2).add(9);
                // temp.get(2).add(11);
                // temp.get(2).add(2);

                // ArrayList<Integer> weight = new ArrayList<>();
                // weight.add(4000);
                // weight.add(2500);
                // weight.add(10000);

                // System.out.println(tuple.get(i).get(0) + " " + tuple.get(i).get(1) + " ");
                // int e = 0;
                // if(weight.get(i) <= 1200)
                //     e = 4;
                // else if(weight.get(i) <= 2400)
                //     e = 3;
                // else if(weight.get(i) <= 4800)
                //     e = 2;
                // else if(weight.get(i) <= 9600)
                //     e = 1;

                // int spectrum_slots = (int)(tuple.get(i).get(2) / (12.5 * e));

                writer.write(tuple.get(i) + " : ");
                writer.write(" " + temp);
                // System.out.println(temp);
                // for(int j = 0; j < temp.size(); j++){
                //     for(int itr : temp.get(i)){
                //         writer.write(itr + " ");
                //     }
                // }
                
                // writer.write(temp.getValue() + " - " + temp.getKey());  
                // writer.write(" = " + spectrum_slots);
                writer.write("\r\n"); // write new line              
            }
            writer.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void display() {
        try {
            Scanner fileContent = new Scanner(new File("Output.txt"));
            while (fileContent.hasNextLine()) {
                System.out.println(fileContent.nextLine());
            }
            fileContent.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
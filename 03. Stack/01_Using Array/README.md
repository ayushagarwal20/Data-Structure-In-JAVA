```java
import java.util.*;
public class Stack {
    public static class Stack_Using_Array{
        Scanner s=new Scanner(System.in);
        private int data[];
        private int top;
        public Stack_Using_Array() {
            data=new int[10];
            top=-1;
        }
        public void push(){
            System.out.println("enter your data--");
            int d=s.nextInt();
            top++;
            data[top]=d;
        }
        public void pop() {
            if(top==-1)
            {
                System.out.println("Stack is empty");
                return;
            }
            top--;

        }
        public int count(){
            return top+1;
        }
        public int top(){
            return data[top];
        }
        public void display() {
            System.out.println("your stack is---");
            for(int i=0;i< data.length;i++)
            {

                System.out.println(data[i]+" ");
            }
        }


    public void Array_call() {
        int c;
        Scanner B = new Scanner(System.in);
        System.out.println("          STACK          ");
        System.out.println("=========================");
        System.out.println("01-Push");
        System.out.println("02-pop");
        System.out.println("03- count the elements ");
        System.out.println("04- top most element ");
        System.out.println("05- display all the elements");
        System.out.println("06- Exit");
        System.out.println("please select what you want to do");
        c = B.nextInt();
        switch(c) {
            case 1:
                push();
                Array_call();
                break;
            case 2:
                pop();
                Array_call();
                break;
            case 3:
                int L=count();
                System.out.println("Stack Size is--"+L);
                Array_call();
                break;
            case 4:
               int k=top();
               System.out.println("Topmost Element in Stack is--"+k);
               Array_call();
                break;
            case 5:
                display();
                Array_call();
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid Input");
                Array_call();
                break;
        }
    }
    }
public static void main(String[] args) {


                    Stack_Using_Array S=new Stack_Using_Array();
                    S.Array_call();
                   
    }

}

```

```java
import java.util.*;
public class Stack {
public static class Stack_Using_LinkedList<T>{
        Scanner ll=new Scanner(System.in);
        Node head=null;
        int size=0;
        class Node<T> {
            T data;
            Node next;
            Node(T data)
            {
                this.data=data;
                next=null;
            }
        }

        void push(){
            System.out.println("please Enter your data");
            int bk= ll.nextInt();
            Node<Integer> NewNode=new Node(bk);
            size++;
            if(head==null){
                head=NewNode;
                size++;
                return;
            }
            NewNode.next=head;
            head=NewNode;
        }
        void pop()
        {
            if(head==null)
            {
                System.out.println("stack is Already Empty");
                return;
            }
            head=head.next;
            size--;
        }
        int count() {
            return size;
        }
        void top(){
            Node Q=head;
            System.out.println("Topmost element is--"+Q.data);
        }
        void display(){
            Node temp=head;
            while (temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }




        public void LinkedList_call() {
            int c;
            Scanner B = new Scanner(System.in);
            System.out.println("          STACK          ");
            System.out.println("=========================");
            System.out.println("01- Push");
            System.out.println("02- pop");
            System.out.println("03- count the elements ");
            System.out.println("04- top most element ");
            System.out.println("05- display all the elements");
            System.out.println("06- Exit");
            System.out.println("please select what you want to do");
            c = B.nextInt();
            switch(c) {
                case 1:
                    push();
                    LinkedList_call();
                    break;
                case 2:
                    pop();
                    LinkedList_call();
                    break;
                case 3:
                    int k=count();
                    System.out.println("Stack size is--"+k);
                    LinkedList_call();
                    break;
                case 4:
                    top();
                    LinkedList_call();
                    break;
                case 5:
                    display();
                    LinkedList_call();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid Input");
                    LinkedList_call();
                    break;
            }
        }
    }
        public static void main(String[] args) {


            
                    Stack_Using_LinkedList SL=new Stack_Using_LinkedList();
                    SL.LinkedList_call();
                   
    }

}

```

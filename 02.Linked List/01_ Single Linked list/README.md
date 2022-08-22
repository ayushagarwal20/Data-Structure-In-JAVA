```Java
import java.util.*;
public class SingleLinkedList {
    Node head=null,tail=null;
     class Node<T>{
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data=data;
            next=null;
        }
    }
    void Create_List(int data){

        Node<Integer> NewNode=new Node(data);
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
        }
        else{
            tail.next=NewNode;
            tail=tail.next;
        }
    }
    void display(){
        System.out.println("Your Current list is ---");
        Node temp=head;
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        head=temp;
    }
    void count() {
        int count=0;
        Node call=head;
        while(call.next!=null){
            count++;
            call=call.next;
        }
        System.out.println("Total Number of nodes are--"+count);

    }
    void Insert_At_Beginning(int data){
        Node<Integer> NewNode=new Node(data);
        if(head==null)
            head=NewNode;
        NewNode.next=head;
        head=NewNode;

    }
    void Insert_At_End(int data){
        Node<Integer> NewNode=new Node(data);
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
        }
        else{
            tail.next=NewNode;
            tail=tail.next;
        }

    }
    void Insert_At_Position(int data,int pos){
        Node<Integer> NewNode=new Node(data);
        Node temp=head;
        Node call=head;
        int count=0;
        if(head==null)
        {
            head=NewNode;
        }
        call=call.next;
        while(count!=pos-2)
        {
            head=head.next;
            call=call.next;
            count++;
        }
        NewNode.next=call;
        head.next=NewNode;
        head=temp;
    }
    void Delete_At_Beginning() {
        if(head==null) {
            System.out.println("list is already Empty");
            return;
        }
        Node temp=head;
        head=head.next;
        temp=null;
    }
    void Delete_At_End() {
        if(head==null) {
            System.out.println("list is already Empty");
            return;
        }
        Node temp=head;
        Node current=head;
        current=current.next;
        while (current.next!=null)
        {
            head=head.next;
            current=current.next;
        }
        head.next=null;
        current=null;
        head=temp;
    }
    void Delete_At_Position(int m){
        Node temp=head;
        Node call=head;

        int count=0;
        if(head==null)
        {
            System.out.println("list is already Empty");
            return;
        }
        call=call.next;
        while(count!=m-2)
        {
            head=head.next;
            call=call.next;
            count++;
        }
        head.next=head.next.next;
        call=null;
        head=temp;
    }
    void Search(int q){
        Node<Integer> New=new Node(q);
        int count=0;
        if(head==null)
        {
            System.out.println("element not found");
            return;
        }
        Node call=head;
        while(call!=null)
        {
            count++;
            if(call.data==New.data)
            {
                System.out.println("element Found At Postion No--"+count);
                return;
            }
            call=call.next;


        }
        System.out.println("element not found");

    }
    void call() {
        int p,q,r,m;
        int c;
        System.out.println("                Single Linked list                ");
        System.out.println("==================================================");
        System.out.println("1- Create a list");
        System.out.println("2- display the list");
        System.out.println("3- Count the elements");
        System.out.println("4- insert a node");
        System.out.println("5- delete a node");
        System.out.println("6- search an elements");
        System.out.println("7- exit");
        Scanner s=new Scanner(System.in);
        p=s.nextInt();
        switch(p)
        {
            case 1:
                do
                {
                    System.out.println("please enter the Value");
                    q=s.nextInt();
                    Create_List(q);
                    System.out.println("do you want to add more nodes 1/0");
                    c=s.nextInt();
                }while(c!=0);
                call();
                break;
            case 2:
                display();
                call();
                break;
            case 3:
                count();
                call();
                break;
            case 4:

                System.out.println("1- Insert at beginning");
                System.out.println("2- Insert at the end ");
                System.out.println("3- Insert at the position");
                int x;
                x=s.nextInt();
                switch(x)
                {
                    case 1:
                        System.out.println("please enter the value--");
                        r=s.nextInt();
                        Insert_At_Beginning(r);
                        call();
                        break;
                    case 2:
                        System.out.println("please enter the value--");
                        r=s.nextInt();
                        Insert_At_End(r);
                        call();
                        break;
                    case 3:
                        System.out.println("please enter the position no where you want to insert");
                        m=s.nextInt();

                        System.out.println("please enter the value--");
                        r=s.nextInt();
                        Insert_At_Position(r,m);
                        call();
                        break;
                }
                break;
            case 5:
                System.out.println("1- Delete at beginning");
                System.out.println("2- Delete at the end ");
                System.out.println("3- Delete at the position");
                int w;
                w=s.nextInt();
                switch(w)
                {
                    case 1:
                        Delete_At_Beginning();
                        break;
                    case 2:
                        Delete_At_End();
                        break;
                    case 3:
                        System.out.println("please enter the position no where you want to delete");
                        m=s.nextInt();
                        Delete_At_Position(m);

                        break;
                }
                call();
                break;
            case 6:
                System.out.println("Enter the element which you want to search");
                int z=s.nextInt();
                Search(z);
                call();
                break;
            case 7:
                System.out.println("Single Linked List is Ended");
                break;
            default:
                System.out.println("INVALID INPUT");
               call();
                break;
        }
    }
    public static void main(String[] args){
        SingleLinkedList SLL=new SingleLinkedList();
         SLL.call();

    }
}

```

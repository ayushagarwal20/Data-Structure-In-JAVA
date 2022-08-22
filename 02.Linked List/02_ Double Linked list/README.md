```Java
import java.util.Scanner;
public class DoublyLinkedList {
    Node head=null,tail=null;
    class Node<T>{
        T data;
        Node<T> next,prev;

        Node(T data)
        {
            this.data=data;
            next=null;
            prev=null;
        }
    }
    void Display(){
        Node temp=head;
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        head=temp;
    }
    void count(){
        Node temp=head;
        int count=0;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        System.out.println("Total No of nodes--"+count);
        head=temp;
    }
    void Create_List(int data){
        Node<Integer> NewNode=new Node<>(data);
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
            return;
        }
        tail.next=NewNode;
        NewNode.prev=tail;
        tail=NewNode;
    }
    void reverse(){
        Node temp=tail;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
    }
    void Insert_At_Beginning(int data) {

        Node<Integer> NewNode=new Node<>(data);
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
        }
        NewNode.next=head;
        head.prev=NewNode;
        head=NewNode;


    }
    void Insert_At_End(int data){
        Node<Integer> NewNode=new Node<>(data);
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
        }
        tail.next=NewNode;
        NewNode.prev=tail;
        tail=NewNode;
    }
    void Insert_At_Position(int data,int pos){
        Node<Integer> NewNode=new Node(data);
        Node temp=head;
        Node call=head;
        int count=0;
        if(head==null)
        {
            head=NewNode;
            tail=NewNode;
        }
        call=call.next;
        while(count!=pos-2)
        {
            head=head.next;
            call=call.next;
            count++;
        }
        NewNode.next=call;
        call.prev=NewNode;
        head.next=NewNode;
        NewNode.prev=head;
        head=temp;
    }
    void  Delete_At_Beginning(){
        head=head.next;
        head.prev=null;
    }
    void Delete_At_End(){
        tail=tail.prev;
        tail.next=null;
    }
    void Delete_At_Position(int pos){
        Node temp=head;
        int count=0;
        if(head==null)
        {
            System.out.println("list is already empty");
        }

        while(count!=pos-2)
        {
            head=head.next;
            count++;
        }
        head.next=head.next.next;
        head=temp;
    }
    void Search(int ele) {
        Node<Integer> New = new Node(ele);
        int count = 0;
        if (head == null) {
            System.out.println("element not found");
            return;
        }
        Node call = head;
        while (call != null) {
            count++;
            if (call.data == New.data) {
                System.out.println("element Found At Postion No--" + count);
                return;
            }
            call = call.next;
        }
    }
    void call() {
        int p,q,r,m;
        int c;
        System.out.println("                Doubly Linked list                ");
        System.out.println("==================================================");
        System.out.println("1- Create a list");
        System.out.println("2- display the list");
        System.out.println("3- Count the elements");
        System.out.println("4- insert a node");
        System.out.println("5- delete a node");
        System.out.println("6- search an elements");
        System.out.println("7- Reverse");
        System.out.println("8- exit");
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
                Display();
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
                reverse();
                call();
                break;
            case 8:
                System.out.println("Single Linked List is Ended");
                break;
            default:
                System.out.println("INVALID INPUT");
                call();
                break;
        }
    }
    public static void main(String[] args){
        DoublyLinkedList DLL=new DoublyLinkedList();
        DLL.call();

    }
}
```

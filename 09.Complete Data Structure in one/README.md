```java
import java.util.*;
import java.util.ArrayList;
import java.lang.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;
import java.io.*;
public class DataStructures {
    public class LinkedList {
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
            void call1() {
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
        }
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
            void call2() {
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
        }
        public class CircularLinkedList{
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
                    if(head == null) {
                        head = NewNode;
                        tail = NewNode;
                        NewNode.next = head;
                    }
                    else {
                        tail.next = NewNode;
                        tail = NewNode;
                        tail.next = head;
                    }
                }
                void display(){
                    System.out.println("Your Current list is ---");
                    Node temp=head;
                    if(head == null) {
                        System.out.println("List is empty");
                        return;
                    }

                    do{
                        System.out.print(temp.data+" ");
                        temp=temp.next;
                    }while(temp!=head);
                }
                void count() {
                    int count=0;
                    Node call=head;
                    do{
                        count++;
                        call=call.next;
                    }while(call!=head);
                    System.out.println("Total Number of nodes are--"+count);

                }
                void Insert_At_Beginning(int data){
                    Node<Integer> NewNode=new Node(data);
                    if(head==null) {
                        head = NewNode;
                        tail = NewNode;
                        tail.next=head;
                        return;
                    }
                    NewNode.next=head;
                    head=NewNode;
                    tail.next=head;

                }
                void Insert_At_End(int data){
                    Node<Integer> NewNode=new Node(data);
                    if(head==null)
                    {
                        head=NewNode;
                        tail=NewNode;
                        tail.next=head;
                        return;
                    }
                    else{
                        NewNode.next=head;
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
                    tail.next=head;
                    temp=null;
                }
                void Delete_At_End() {
                    if(head == null)
                    {
                        return;
                    }
                    else {

                        if(head != tail ) {
                            Node current = head;
                            while(current.next != tail) {
                                current = current.next;
                            }
                            tail = current;
                            tail.next = head;
                        }
                        else {
                            head = tail = null;
                        }
                    }
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

                    do{
                        count++;
                        if(call.data==New.data)
                        {
                            System.out.println("element Found At Position No--"+count);
                            return;
                        }
                        call=call.next;
                    }while(call!=head);
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
            }
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
                    System.out.println("Your Current list is ---");
                    Node temp=head;
                    if(head == null) {
                        System.out.println("List is empty");
                        return;
                    }
                    do{
                        System.out.print(temp.data+" ");
                        temp=temp.next;
                    }while(temp!=head);
                }
                void count() {
                    int count=0;
                    Node call=head;
                    do{
                        count++;
                        call=call.next;
                    }while(call!=head);
                    System.out.println("Total Number of nodes are--"+count);

                }
                void Create_List(int data){
                    Node<Integer> NewNode=new Node<>(data);
                    if(head==null)
                    {
                        NewNode.prev=NewNode;
                        NewNode.next=NewNode;
                        tail=NewNode;
                        head=NewNode;
                        return;
                    }
                    tail.next=NewNode;
                    NewNode.prev=tail;
                    tail=NewNode;
                    tail.next=head;
                    head.prev=tail;
                }
                void reverse(){
                    Node temp=tail;
                    while(temp!=head)
                    {
                        System.out.print(temp.data+" ");
                        temp=temp.prev;
                    }
                }
                void Insert_At_Beginning(int data) {
                    Node<Integer> NewNode=new Node<>(data);
                    if(head==null)
                    {
                        NewNode.prev=NewNode;
                        NewNode.next=NewNode;
                        tail=NewNode;
                        head=NewNode;
                        return;
                    }
                    NewNode.next=head;
                    head.prev=NewNode;
                    head=NewNode;
                    tail.next=head;
                    head.prev=tail;

                }
                void Insert_At_End(int data){
                    Node<Integer> NewNode=new Node<>(data);
                    if(head==null){
                        NewNode.prev=NewNode;
                        NewNode.next=NewNode;
                        tail=NewNode;
                        head=NewNode;
                        return;
                    }
                    tail.next=NewNode;
                    NewNode.prev=tail;
                    tail=NewNode;
                    tail.next=head;
                    head.prev=tail;
                }
                void Insert_At_Position(int data,int pos){
                    Node<Integer> NewNode=new Node(data);
                    Node temp=head;
                    Node call=head;
                    int count=0;
                    if(head==null)
                    {
                        NewNode.prev=NewNode;
                        NewNode.next=NewNode;
                        tail=NewNode;
                        head=NewNode;
                        return;
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
                void Delete_At_Beginning(){
                    head=head.next;
                    head.prev=tail;
                    tail.next=head;
                }
                void Delete_At_End(){
                    tail=tail.prev;
                    tail.next=head;
                    head.prev=tail;
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
                    do{
                        count++;
                        if (call.data == New.data) {
                            System.out.println("element Found At Position No--" + count);
                            return;
                        }
                        call = call.next;
                    }while(call != head);
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
            }
            void call3(){
                int a;
                System.out.println("1- Circular Linked List using Single Linked list");
                System.out.println("2- Circular Linked List using Double Linked list");
                Scanner sc=new Scanner(System.in);
                a= sc.nextInt();
                switch(a)
                {
                    case 1:
                        SingleLinkedList SL=new SingleLinkedList();
                        SL.call();
                        break;
                    case 2:
                        DoublyLinkedList DL=new DoublyLinkedList();
                        DL.call();
                        break;
                    default:
                        System.out.println("INVALID INPUT!");
                        call();
                        break;
                }

            }

        }

        void call(){
            int a;
            System.out.println("===============LinkedList===============");
            System.out.println("what type of LinkedList you want to create");
            System.out.println("press 1- Singly LinkedList");
            System.out.println("press 2- Doubly LinkedList");
            System.out.println("press 3- Circular LinkedList");
            Scanner s=new Scanner(System.in);
            a=s.nextInt();
            switch(a)
            {
                case 1:
                    SingleLinkedList SLL=new SingleLinkedList();
                    SLL.call1();
                    break;
                case 2:
                    DoublyLinkedList DLL=new DoublyLinkedList();
                    DLL.call2();
                    break;
                case 3:
                    CircularLinkedList CLL=new CircularLinkedList();
                    CLL.call3();
                    break;
                default:
                    System.out.println("Invalid Input");
                    call();
                    break;

            }
        }
    }
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
        void call4(){
            System.out.println("please Select----");
            System.out.println("1 - Stack Using Array");
            System.out.println("2 - Stack Using Linkedlist");
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            switch(a)
            {
                case 1:
                    Stack_Using_Array S=new Stack_Using_Array();
                    S.Array_call();
                    break;
                case 2:
                    Stack_Using_LinkedList SL=new Stack_Using_LinkedList();
                    SL.LinkedList_call();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

    }
    public class Queue {
        public static class Queue_Using_Array{
            private int[] data;
            private int front;
            private int rear;
            private int size;
            public Queue_Using_Array()
            {
                data=new int[10];
                front=-1;
                rear=-1;
                size=0;
            }
            void Enqueue(int r){
                if (front==-1) {
                    front++;
                }
                rear++;
                data[rear]=r;

            }
            void Dequeue(){
                int[] arr=new int[data.length-1];
                for(int i=0;i<rear;i++)
                {
                    arr[i]=data[i+1];
                }
                data=arr;
            }
            int peek()
            {
                return data[rear];
            }
            void Display(){
                int k=rear;
                for(int i=0;i<=k;i++){
                    System.out.print(data[i]+" ");
                }
            }

            void Array_call(){
                int c;
                Scanner B = new Scanner(System.in);
                System.out.println("          QUEUE          ");
                System.out.println("=========================");
                System.out.println("01- Enqueue");
                System.out.println("02- Dequeue");
                System.out.println("03- Peek");
                System.out.println("04- first element ");
                System.out.println("05- display all the elements");
                System.out.println("06- Exit");
                System.out.println("please select what you want to do");
                c=B.nextInt();
                switch(c)
                {
                    case 1:
                        System.out.println("please enter your data");
                        int b= B.nextInt();
                        Enqueue(b);
                        Array_call();
                        break;
                    case 2:
                        Dequeue();
                        Array_call();
                        break;
                    case 3:
                        int k=peek();
                        System.out.println("Topmost value is--"+k);
                        Array_call();
                        break;
                    case 4:
                        //First_element();
                        Array_call();
                        break;
                    case 5:
                        Display();
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
        public static class Queue_Using_LinkedList{
            Node head=null,tail=null;
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
            void Enqueue(int data){

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
            void Dequeue(){
                if(head==null) {
                    System.out.println("list is already Empty");
                    return;
                }
                Node temp=head;
                head=head.next;
                temp=null;
            }
            int peek() {
                int k=(int)tail.data;
                return k;
            }
            void First(){
                System.out.println("First Element is--"+head.data);
            }
            void Display(){
                System.out.println("Your Current Queue is ---");
                Node temp=head;
                while(head!=null)
                {
                    System.out.print(head.data+" ");
                    head=head.next;
                }
                head=temp;
            }
            void LinkedList_call() {
                int c;
                Scanner B = new Scanner(System.in);
                System.out.println("          QUEUE          ");
                System.out.println("=========================");
                System.out.println("01- Enqueue");
                System.out.println("02- Dequeue");
                System.out.println("03- Peek");
                System.out.println("04- first element ");
                System.out.println("05- display all the elements");
                System.out.println("06- Exit");
                System.out.println("please select what you want to do");
                c=B.nextInt();
                switch(c)
                {
                    case 1:
                        System.out.println("please enter your data");
                        int b= B.nextInt();
                        Enqueue(b);
                        LinkedList_call();
                        break;
                    case 2:
                        Dequeue();
                        LinkedList_call();
                        break;
                    case 3:
                        int k=peek();
                        System.out.println("Topmost value is--");
                        LinkedList_call();
                        break;
                    case 4:
                        First();
                        LinkedList_call();
                        break;
                    case 5:
                        Display();
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
        void call5(){
            System.out.println("please Select----");
            System.out.println("1 - Queue Using Array");
            System.out.println("2 - Queue Using LinkedList");
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            switch(a)
            {
                case 1:
                    Queue_Using_Array S=new Queue_Using_Array();
                    S.Array_call();
                    break;
                case 2:
                    Queue_Using_LinkedList SL=new Queue_Using_LinkedList();
                    SL.LinkedList_call();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    public class Tree {
        public class BinarySearchTree {

            static class Node {
                int data;
                Node left;
                Node right;

                Node(int data) {
                    this.data = data;
                }
            }

            private Node root;

            BinarySearchTree() {
                root = null;
            }

            Node insertRec(Node root, int key) {
                if (root == null) {
                    root = new Node(key);
                    return root;
                } else if (key < root.data)
                    root.left = insertRec(root.left, key);
                else if (key > root.data)
                    root.right = insertRec(root.right, key);
                return root;
            }

            public void Insert(int a) {
                root = insertRec(root, a);
            }

            public void Inorder(Node root) {
                if (root == null) {
                    return;
                }
                Inorder(root.left);
                System.out.print(root.data + " ");
                Inorder(root.right);
            }

            public void Preorder(Node root) {
                if (root == null) {
                    return;
                }
                System.out.print(root.data + " ");
                Preorder(root.left);

                Preorder(root.right);
            }

            public void Postorder(Node root) {
                if (root == null) {
                    return;
                }
                Postorder(root.left);

                Postorder(root.right);
                System.out.print(root.data + " ");
            }

            public void Search(Node temp, int a) {
                try {


                    if (temp == null) {
                        System.out.println("element not found");
                    }
                    if (temp.data == a) {
                        System.out.println("Element Found");
                    } else if (temp.data > a) {
                        Search(temp.left, a);
                    } else {
                        Search(temp.right, a);
                    }
                } catch (NullPointerException e) {
                    System.out.print("NullPointerException Caught");
                }

            }

            Node deleteNode(Node root, int a) {
                if (root == null)
                    return null;
                if (root.data < a) {
                    root.left = deleteNode(root.left, a);
                    return root;
                } else if (root.data > a) {
                    root.right = deleteNode(root.right, a);
                    return root;
                } else {
                    if (root.left == null && root.right == null) {
                        return null;
                    } else if (root.left == null) {
                        return root.right;
                    } else if (root.right == null) {
                        return root.left;
                    } else {
                        Node minNode = root.right;
                        while (minNode.left != null) {
                            minNode = minNode.left;
                        }
                        root.data = minNode.data;
                        root.right = deleteNode(root.right, minNode.data);
                    }
                }

                return root;
            }

            void Delete(int b) {
                root = deleteNode(root, b);
            }

            public void call() {
                Scanner s = new Scanner(System.in);
                System.out.println(" ");
                System.out.println("01- Insert");
                System.out.println("02- Display/Traversal");
                System.out.println("03- Search");
                System.out.println("04- Delete");
                System.out.println("Enter Your Choice");
                int a = s.nextInt();
                switch (a) {
                    case 1:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter value");
                        int c = sc.nextInt();
                        Insert(c);
                        call();
                        break;
                    case 2:
                        System.out.println("01- Preorder Traversal/print");
                        System.out.println("02- Inorder Traversal/print");
                        System.out.println("03- PostOrder Traversal/print");
                        System.out.println("04- LevelOrder Traversal/print");
                        System.out.println("Enter your Data---");
                        int b = s.nextInt();
                        switch (b) {
                            case 1:
                                Preorder(root);
                                call();
                                break;
                            case 2:
                                Inorder(root);
                                call();
                                break;
                            case 3:
                                Postorder(root);
                                call();
                                break;
                            case 4:
                                break;
                            default:
                                break;
                        }
                        //print(root);
                        break;
                    case 3:
                        System.out.println("Enter element");
                        int k = s.nextInt();
                        Search(root, k);
                        call();
                        break;
                    case 4:
                        System.out.println("Enter element");
                        int l = s.nextInt();
                        Delete(l);
                        call();
                        break;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }
        }
        public class GenericTree {
            Scanner s = new Scanner(System.in);

            private class Node {
                int data;
                ArrayList<Node> children = new ArrayList<>();
            }

            private Node root;

            public GenericTree() {
                root = Construct(null, -1);
            }

            private Node Construct(Node parent, int ith) {
                if (parent == null) {
                    System.out.println("Enter the data for Root Node");

                } else {
                    System.out.println("please Enter the data for " + ith + " child of " + parent.data + " ?");
                }
                int item = s.nextInt();
                Node NewNode = new Node();
                NewNode.data = item;
                System.out.println("Please Enter the number of Child for Parent - " + item);
                int NOC = s.nextInt();
                for (int j = 0; j < NOC; j++) {
                    Node child = Construct(NewNode, j);
                    NewNode.children.add(child);
                }
                return NewNode;
            }

            public void display() {
                display(root);
            }

            public void size() {
                int k = size(root);
                System.out.println(k);
            }

            private int size(Node node) {
                int ts = 0;
                for (Node child : node.children) {
                    int sz = size(child);
                    ts += sz;
                }
                return ts + 1;
            }

            private void display(Node node) {
                String str = node.data + " ->";
                for (Node child : node.children) {
                    str = str + child.data + " ";
                }
                str += " . ";
                System.out.println(str);
                for (Node child : node.children) {
                    display(child);
                }

            }

            void Case3() {
                int k;
                System.out.println("          Generic TREE          ");
                System.out.println("================================");
                System.out.println("what do you want to choose---");
                System.out.println("1- Creation");
                System.out.println("2- Display");
                System.out.println("3- Size");
                System.out.println("4- Count");
                System.out.println("5- Largest Data");
                System.out.println("6- height");
                System.out.println("7- Count leaf Nodes");
                System.out.println("8- Exit");
                Scanner T = new Scanner(System.in);
                k = T.nextInt();
                switch (k) {

                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid input, please Try Again");
                        Case3();
                        break;
                }


            }
        }
        public class BinaryTree {
            public class BinaryTreeRecursive {
                BinaryTreeNode<Integer> root = null;

                class BinaryTreeNode<T> {
                    T data;
                    BinaryTreeNode<T> left;
                    BinaryTreeNode<T> right;

                    BinaryTreeNode(T data) {
                        this.data = data;
                    }

                }

                BinaryTreeNode<Integer> Creation(Scanner s) {
                    System.out.println("Enter Root value");
                    int a = s.nextInt();
                    if (a == -1) {
                        return null;
                    }
                    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(a);
                    root.left = Creation(s);
                    root.right = Creation(s);
                    return root;
                }

                void print(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                }

                void Inorder(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                    Inorder(root.left);
                    System.out.print(root.data + " ");
                    Inorder(root.right);
                }

                void Preorder(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                    System.out.print(root.data + " ");
                    Preorder(root.left);

                    Preorder(root.right);
                }

                void printlevelwise(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                }

                void Postorder(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                    Postorder(root.left);

                    Postorder(root.right);
                    System.out.print(root.data + " ");
                }

                void call6() {
                    Scanner s = new Scanner(System.in);
                    System.out.println("");
                    System.out.println("01- Creation");
                    System.out.println("02- Display/Traversal");
                    System.out.println("Enter Your Choice");
                    int a = s.nextInt();

                    switch (a) {
                        case 1:
                            root = Creation(s);
                            call6();
                            break;
                        case 2:
                            System.out.println("01- Preorder Traversal/print");
                            System.out.println("02- Inorder Traversal/print");
                            System.out.println("03- PostOrder Traversal/print");
                            System.out.println("04- LevelOrder Traversal/print");
                            System.out.println("Enter your Data---");
                            int b = s.nextInt();
                            switch (b) {
                                case 1:
                                    Preorder(root);
                                    call6();
                                    break;
                                case 2:
                                    Inorder(root);
                                    call6();
                                    break;
                                case 3:
                                    Postorder(root);
                                    call6();
                                    break;
                                case 4:
                                    break;
                                default:
                                    break;
                            }
                            print(root);
                            break;
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }
                }

                BinaryTreeNode<Integer> RemoveLeafNodes(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return null;
                    }
                    if (root.left == null & root.right == null) {
                        return null;
                    }
                    root.left = RemoveLeafNodes(root.left);
                    root.right = RemoveLeafNodes(root.right);
                    return root;
                }

                void mirror(BinaryTreeNode<Integer> root) {
                    if (root == null) {
                        return;
                    }
                    mirror(root.left);
                    mirror(root.right);
                    BinaryTreeNode<Integer> TEMP = root.left;
                    root.left = root.right;
                    root.right = TEMP;
                }


            }


            void call7() {
                Scanner s = new Scanner(System.in);
                System.out.println("01-Binary Tree Using (Recursive Approach)");
                System.out.println("02-Binary Tree Using (Iterative Approach)");
                System.out.println("Enter Your Choice");
                int a = s.nextInt();
                switch (a) {
                    case 1:
                        BinaryTreeRecursive BTR = new BinaryTreeRecursive();
                        BTR.call6();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }
        }
        void call6() {
            System.out.println("==================Tree==================");
            System.out.println("01- Generic Tree");
            System.out.println("02- Binary Tree");
            System.out.println("03- Binary Search Tree");
            System.out.println("04- Exit");
            System.out.println("Please Select any one");
            Scanner s = new Scanner(System.in);
            int k = s.nextInt();
            switch (k) {
                case 1:
                    GenericTree GT = new GenericTree();
                    GT.Case3();
                    break;
                case 2:
                    BinaryTree BT = new BinaryTree();
                    BT.call7();
                    break;
                case 3:
                    BinarySearchTree BST = new BinarySearchTree();
                    BST.call();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input");
                    call6();
                    break;


            }
        }
    }
    public class Graph{
        class Graph_Using_HashMaps {
            private static class Vertex {
                HashMap<String, Integer> neighbours = new HashMap<>();
            }
            HashMap<String, Vertex> vertices;
            public Graph_Using_HashMaps() {
                vertices = new HashMap<>();
            }
            int NumberOfVertex() {
                return this.vertices.size();
            }
            public boolean containsVertex(String vname) {
                return this.vertices.containsKey(vname);
            }
            void AddVertex(String vname) {
                Vertex v = new Vertex();
                vertices.put(vname, v);
            }
            void RemoveVertex(String v) {
                Vertex vtr = vertices.get(v);
                ArrayList<String> keys = new ArrayList<>(vtr.neighbours.keySet());
                for (String key : keys) {
                    Vertex vtr1 = vertices.get(key);
                    vtr1.neighbours.remove(v);
                }
            }
            public int NoOfEdges() {
                int count = 0;
                ArrayList<String> keys = new ArrayList<>(vertices.keySet());
                for (String key : keys) {
                    Vertex vtx = vertices.get(key);
                    count = count + vtx.neighbours.size();
                }
                return count / 2;
            }
            public boolean containsEdge(String v1, String v2) {
                Vertex vtx1 = vertices.get(v1);
                Vertex vtx2 = vertices.get(v2);
                if (vtx1 == null || vtx2 == null || !vtx1.neighbours.containsKey(v2)) {
                    return false;
                }

                return true;

            }
            public void AddEdge(String v1, String v2, int Weight) {
                Vertex vtx1 = vertices.get(v1);
                Vertex vtx2 = vertices.get(v2);
                if (vtx1 == null || vtx2 == null || !vtx1.neighbours.containsKey(v2)) {
                    return;
                }
                vtx1.neighbours.put(v2, Weight);
                vtx2.neighbours.put(v1, Weight);
            }
            public void RemoveEdge(String v1, String v2) {
                Vertex vtx1 = vertices.get(v1);
                Vertex vtx2 = vertices.get(v2);
                if (vtx1 == null || vtx2 == null || !vtx1.neighbours.containsKey(v2)) {
                    return;
                }
                vtx1.neighbours.remove(v2);
                vtx2.neighbours.remove(v1);
            }
            public boolean haspath(String v1, String v2, HashMap<String, Boolean> process) {
                process.put(v1, true);
                if (containsEdge(v1, v2)) {
                    return true;
                }
                Vertex vtx = vertices.get(v1);
                ArrayList<String> arr = new ArrayList<>(vtx.neighbours.keySet());
                for (String arrs : arr) {
                    if (process.containsKey(arrs) && haspath(arrs, v1, process)) {
                        return true;
                    }
                }
                return false;
            }
            private class pairs{
                String Vertex_Name;
                String psf;
            }
            public boolean bfs(String Src,String dst){
                HashMap<String,Boolean> process=new HashMap<>();
                java.util.LinkedList<pairs> Queue=new java.util.LinkedList();
                pairs sp=new pairs();
                sp.Vertex_Name=Src;
                sp.psf=Src;
                Queue.addLast(sp);
                while(!Queue.isEmpty()){

                    pairs rp=Queue.removeFirst();
                    if(process.containsKey(rp.Vertex_Name)){
                        continue;
                    }

                    process.put(rp.Vertex_Name,true);
                    if(containsEdge(rp.Vertex_Name,dst)){
                        System.out.print(rp.psf+dst);
                        return true;
                    }
                    Vertex rtpbs=vertices.get(rp.Vertex_Name);
                    ArrayList<String> nbrs=new ArrayList<>(rtpbs.neighbours.keySet());
                    for (String nbr:nbrs) {
                        if(!process.containsKey(nbr)){
                            pairs np=new pairs();
                            np.Vertex_Name=nbr;
                            np.psf= rp.psf+nbr;
                            Queue.addLast(np);
                        }
                    }
                }
                return false;
            }
            public boolean dfs(String Src,String dst){
                HashMap<String,Boolean> process=new HashMap<>();
                java.util.LinkedList<pairs> stack=new java.util.LinkedList();
                pairs sp=new pairs();
                sp.Vertex_Name=Src;
                sp.psf=Src;
                stack.addFirst(sp);
                while(!stack.isEmpty()){

                    pairs rp=stack.removeFirst();
                    if(process.containsKey(rp.Vertex_Name)){
                        continue;
                    }

                    process.put(rp.Vertex_Name,true);
                    if(containsEdge(rp.Vertex_Name,dst)){
                        System.out.print(rp.psf+dst);
                        return true;
                    }
                    Vertex rtpbs=vertices.get(rp.Vertex_Name);
                    ArrayList<String> nbrs=new ArrayList<>(rtpbs.neighbours.keySet());
                    for (String nbr:nbrs) {
                        if(!process.containsKey(nbr)){
                            pairs np=new pairs();
                            np.Vertex_Name=nbr;
                            np.psf= rp.psf+nbr;
                            stack.addFirst(np);
                        }
                    }
                }
                return false;
            }
            void call(){
                int a;
                System.out.println("           Graph Using HashMaps          ");
                System.out.println("-----------------------------------------");
                System.out.println("01- Creation");
                System.out.println("02- Display");
                System.out.println("03- No of Vertices");
                System.out.println("04- Vertex Availability");
                System.out.println("05- Add Vertex");
                System.out.println("06- Add Edges");
                System.out.println("07- Remove Edge");
                System.out.println("08-Check Path");
                System.out.println("09- Breath First Search");
                System.out.println("10- Depth First Search");
                System.out.println("11- Exit");
                Scanner s=new Scanner(System.in);
                a= s.nextInt();
                switch (a){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    default:
                        break;
                }
            }


        }
        class Graph_Using_Matrix{
            public static void DFS(int[][] arr,int currentVertex,boolean[] visit ){
                visit[currentVertex]=true;
                System.out.println(currentVertex+" ");
                for(int i=0;i<arr.length;i++){
                    if(arr[currentVertex][i]==1 && visit[i] == false){
                        DFS(arr,i,visit);
                    }
                }
            }
            public static void BFS(int[][] arr){
                java.util.Queue<Integer> PENDING=new java.util.LinkedList<>();
                boolean[] visit=new boolean[arr.length];
                System.out.println("Enter starting vertex for traversal");
                Scanner sc=new Scanner(System.in);
                int a= sc.nextInt();
                visit[a]=true;
                PENDING.add(a);
                while(!PENDING.isEmpty()){
                    int currentvertex=PENDING.poll();
                    System.out.println(currentvertex+" ");
                    for(int i=0;i<arr.length;i++){
                        if (arr[currentvertex][i] == 1 && !visit[i]) {
                            PENDING.add(i);
                            visit[i]=true;

                        }
                    }
                }
            }
            public static void DFS(int[][] arr) {
                boolean visit[] = new boolean[arr.length];
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the starting vertex");
                int a= sc.nextInt();
                DFS(arr,a,visit);
            }
            void Creation(){
                Scanner s=new Scanner(System.in);
                System.out.println("Enter No of Edges and Vertices");
                int a= s.nextInt();
                int b= s.nextInt();
                int[][] arr=new int[b][b];
                for(int i=0;i<a;i++){
                    int v1= s.nextInt();
                    int v2=s.nextInt();
                    arr[v1][v2]=1;
                    arr[v2][v1]=1;
                }

            }
            void call1(){
                int a;
                System.out.println("           Graph Using Matrix          ");
                System.out.println("-----------------------------------------");
                System.out.println("01- Creation");
                System.out.println("02- Display");
                System.out.println("03- No of Vertices");
                System.out.println("04- Vertex Availability");
                System.out.println("05- Add Vertex");
                System.out.println("06- Add Edges");
                System.out.println("07- Remove Edge");
                System.out.println("08-Check Path");
                System.out.println("09- Breath First Search");
                System.out.println("10- Depth First Search");
                System.out.println("11- Exit");
                Scanner s=new Scanner(System.in);
                a= s.nextInt();
                switch (a){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    default:
                        break;
                }
            }

        }
        public void sts(){
            System.out.println("           Graph           ");
            System.out.println("---------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.println("01- Graph Using Matrix");
            System.out.println("02- Graph Using HashMaps");
            int a= sc.nextInt();
            switch (a){
                case 1:
                    Graph_Using_HashMaps GUH=new Graph_Using_HashMaps();
                    GUH.call();
                    break;
                case 2:
                    Graph_Using_Matrix GUM=new Graph_Using_Matrix();
                    GUM.call1();
                    break;
            }
        }
        void main1() {
            Graph g=new Graph();
            g.sts();

        }
    }
    public class PriorityQueue {
        static class Min_Heap {
            ArrayList<Integer> heap;

            public Min_Heap() {
                heap = new ArrayList<>();
            }

            boolean isEmpty() {
                return heap.size() == 0;
            }

            int size() {
                return heap.size();
            }
            void add(Scanner sc){
                System.out.println("Enter your data ? if not press 0");
                int a= sc.nextInt();
                if(a==0){
                    return;
                }
                else {
                    insert(a);
                    add(sc);
                }
            }

            int Min() {
                if (heap.size() == 0) {
                    return 0;
                }
                return heap.get(0);
            }

            void insert(int element) {
                heap.add(element);
                int ChildIndex = heap.size() - 1;
                int Parent = (ChildIndex - 1) / 2;
                while (ChildIndex > 0) {
                    if (heap.get(ChildIndex) < heap.get(Parent)) {
                        int temp = heap.get(ChildIndex);
                        heap.set(ChildIndex, heap.get(Parent));
                        heap.set(Parent, temp);
                        ChildIndex = Parent;
                        Parent = (ChildIndex - 1) / 2;
                    } else {
                        return;
                    }
                }
            }

            int removeMin() {
                if (heap.size() == 0) {
                    return 0;
                }
                int temp = heap.get(0);
                heap.set(0, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                int index = 0;
                int minIndex = index;
                int left = 1;
                int right = 2;
                while (left < heap.size()) {
                    if (heap.get(left) < heap.get(minIndex)) {
                        minIndex = left;
                    }
                    if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
                        minIndex = right;
                    }
                    if (minIndex == index) {
                        break;
                    } else {
                        int temp1 = heap.get(index);
                        heap.set(index, heap.get(minIndex));
                        heap.set(minIndex, temp);
                        index = minIndex;
                        left = 2 * index + 1;
                        right = 2 * index + 2;
                    }

                }
                return temp;
            }

            void call(Scanner sc) {
                System.out.println("     Min Heap/Priority Queue     ");
                System.out.println("---------------------------------");
                System.out.println("01- Add");
                System.out.println("02- Remove");
                System.out.println("03- Get");
                System.out.println("03- Exit");
                int k=sc.nextInt();
                switch (k){
                    case 1:
                        add(sc);
                        break;
                    case 2:
                        removeMin();
                        break;
                    case 3:
                        Min();
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
            }
        }
        static class Max_Heap{}
        void main2(){
            System.out.println("          Priority Queue          ");
            System.out.println("----------------------------------");
            System.out.println("01- Min Heap/Priority Queue");
            System.out.println("02- Max Heap/Priority Queue");
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            switch (a){
                case 1:
                    Min_Heap he=new Min_Heap();
                    he.call(sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
    public class sorting{
        void Sort(){
            System.out.println("               Sorting Algorithm            ");
            System.out.println("--------------------------------------------");
            System.out.println("01- Bubble Sort");
            System.out.println("02- Selection Sort");
            System.out.println("03- Quick Sort");
            System.out.println("04- Insertion Sort");
            System.out.println("05- Merge Sort");
            System.out.println("06- Bucket Sort");
            System.out.println("07- Counting Sort");
            System.out.println("08- Comb Sort");
            System.out.println("09- Radix Sort");
            System.out.println("10- Shell Sort");
            System.out.println("11- Bitonic Sort");
            System.out.println("12- Cocktail Sort");
            System.out.println("13- Cycle Sort");
            System.out.println("14- Tim Sort");
            System.out.println("15- Heap Sort");
        }
    }
    public class hashing{}
    public class Array{}


    void DataStructuresCall(int a) {
        switch (a) {
            case 1:
                Array ar=new Array();
                break;
            case 2:
                LinkedList LL=new LinkedList();
                LL.call();

                break;
            case 3:
                Stack S=new Stack();
                S.call4();
                break;
            case 4:
                Queue Q=new Queue();
                Q.call5();
                break;
            case 5:
                Tree T=new Tree();
                T.call6();
                break;
            case 6:
                Graph g=new Graph();
                g.main1();
                break;
            case 7:
                hashing hs=new hashing();
                break;
            case 8:
                PriorityQueue PQ=new PriorityQueue();
                PQ.main2();
                return;
            case 9:
                sorting s=new sorting();
                s.Sort();
                return;
            case 10:
                return;
            default:
                System.out.println("invalid input-- try Again");
                DataStructuresCall(a);
                break;
        }
    }
    public static void main(String[] args){
        int a;

        System.out.println("                 Data Structures                 ");
        System.out.println("-------------------------------------------------");
        System.out.println("What do want to create");
        System.out.println("press 1- Array");
        System.out.println("press 2- LinkedList");
        System.out.println("press 3- Stack");
        System.out.println("press 4- Queue");
        System.out.println("press 5- Tree");
        System.out.println("press 6- Graph");
        System.out.println("press 7- Hashing");
        System.out.println("press 8- Heap/priority queue");
        System.out.println("press 9- Sorting");
        System.out.println("press 10- Exit from program");
        Scanner A = new Scanner(System.in);
        a = A.nextInt();
        DataStructures DK = new DataStructures();
        DK.DataStructuresCall(a);

    }
}
```

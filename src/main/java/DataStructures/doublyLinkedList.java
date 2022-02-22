package DataStructures;

import java.util.Scanner;

public class doublyLinkedList {

    public class Node{

        public Node next;
        public Node prev;
        public Integer key;

        public Node(Integer x){
            key = x;
        }
    }

    Node sentinel;

    public doublyLinkedList(){
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public Node search(int k){
        Node x = sentinel.next;
        while(x != sentinel && x.key != k){
            x = x.next;
        }
        return x;
    }

    public void insert(int key){
        Node x = new Node(key);
        x.next = sentinel.next;
        sentinel.next.prev = x;
        sentinel.next = x;
        x.prev = sentinel;
    }

    public void delete(int key){

        if(isEmpty()){
            System.out.println("Linked list is empty");
            return;
        }

        Node foundNode = search(key);
        foundNode.prev.next = foundNode.next;
        foundNode.next.prev = foundNode.prev;
    }

    public boolean isEmpty(){
        if(sentinel.prev == sentinel || sentinel.next == sentinel)
            return true;
        return false;
    }

    public void printList(){
        if(!isEmpty()){
            Node x = sentinel.next;
            while (x != sentinel){
                System.out.print(x.key + ", ");
                x = x.next;
            }
        }
    }


    public void reverse(){
        Node previous = sentinel;
        Node current = sentinel.next;
        Node next = current.next;

        while(current!=sentinel){
            current.next = previous;
            previous = current;
            current = next;
            next = current.next;
        }

        sentinel.next = previous;
    }

    public static void commandPrompt(){
        System.out.println("Enter a command");
    }

    public static void main(String[] args){
        doublyLinkedList list = new doublyLinkedList();
        Scanner in = new Scanner(System.in);

        while(true){

            commandPrompt();
            String s2 = in.nextLine();

            if(s2.contains("delete")){
                String [] segments = s2.split(" ");
                list.delete(Integer.parseInt(segments[1]));
                list.printList();
            }

            else if(s2.contains("insert")){
                String [] segments = s2.split(" ");
                list.insert(Integer.parseInt(segments[1]));
                list.printList();
            }

            else if(s2.contains("reverse")){
                list.reverse();
                list.printList();
            }
        }
    }



}

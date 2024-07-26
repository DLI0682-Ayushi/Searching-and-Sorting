package LinkedList;
import java.util.Scanner;
class Node1 {
    int data;
    Node2 next;
    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList1 {
    private Node2 head;
    public void addToEnd(int data) {
        Node2 newNode = new Node2(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void reverse() {
        Node2 prev = null;
        Node2 current = head;
        Node2 next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void display() {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList1 myList = new LinkedList1();
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.addToEnd(scanner.nextInt());
        }
        System.out.println("Original list:");
        myList.display();
        myList.reverse();
        System.out.println("Reversed list:");
        myList.display();
        scanner.close();
    }
}

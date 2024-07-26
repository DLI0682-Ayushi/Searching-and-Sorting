package LinkedList;
import java.util.Scanner;

class Node4 {
    int data;
    Node4 next;

    public Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList4 {
    private Node4 head;

    public void addToEnd(int data) {
        Node4 newNode = new Node4(data);
        if (head == null) {
            head = newNode;
        } else {
            Node4 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node4 findNthFromEnd(int n) {
        if (head == null || n <= 0) {
            return null; // Invalid input
        }

        Node4 slow = head;
        Node4 fast = head;

        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null; // List has fewer than n nodes
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

public class FindNodeFromEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList4 myList = new LinkedList4();

        System.out.print("Enter the number of elements in the list: ");
        int numElements = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            myList.addToEnd(scanner.nextInt());
        }

        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        Node4 nthNode = myList.findNthFromEnd(n);

        if (nthNode != null) {
            System.out.println("N-th node from the end: " + nthNode.data);
        } else {
            System.out.println("Invalid input or list has fewer than N nodes.");
        }

        scanner.close();
    }
}

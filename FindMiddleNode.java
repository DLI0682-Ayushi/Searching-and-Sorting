package LinkedList;
import java.util.Scanner;

class Node3 {
    int data;
    Node3 next;

    public Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList3 {
    private Node3 head;

    public void addToEnd(int data) {
        Node3 newNode = new Node3(data);
        if (head == null) {
            head = newNode;
        } else {
            Node3 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node3 findMiddleNode() {
        if (head == null) {
            return null; // Empty list
        }

        Node3 slow = head;
        Node3 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

public class FindMiddleNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList3 myList = new LinkedList3();

        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.addToEnd(scanner.nextInt());
        }

        Node3 middleNode = myList.findMiddleNode();

        if (middleNode != null) {
            System.out.println("Middle node value: " + middleNode.data);
        } else {
            System.out.println("The list is empty.");
        }

        scanner.close();
    }
}

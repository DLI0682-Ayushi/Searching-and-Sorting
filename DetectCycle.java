package LinkedList;
import java.util.Scanner;

class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList2 {
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

    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false; // No cycle for empty or single-node list
        }

        Node2 slow = head;
        Node2 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move one step
            fast = fast.next.next; // Move two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList2 myList = new LinkedList2();

        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myList.addToEnd(scanner.nextInt());
        }

        // Create a cycle (for demonstration purposes)
        // Uncomment the following lines to create a cycle:
        // myList.addToEnd(myList.head.data); // Point the last node to the head

        boolean hasCycle = myList.hasCycle();

        if (hasCycle) {
            System.out.println("The list contains a cycle.");
        } else {
            System.out.println("The list does not contain a cycle.");
        }
    }
}

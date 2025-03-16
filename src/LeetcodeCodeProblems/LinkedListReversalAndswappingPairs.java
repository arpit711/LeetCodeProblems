package LeetcodeCodeProblems;

public class LinkedListReversalAndswappingPairs {

    public static void linkedListProblem() {
        Node tempNode;
        Node head = new Node(8);
        tempNode = head;
//                head.next = new Node(12);
//                tempNode = head.next;
        int k = 10;
        tempNode.next = new Node(10);
        tempNode = tempNode.next;
        tempNode.next = new Node(2);
        tempNode = tempNode.next;
        tempNode.next = new Node(5);
        tempNode = tempNode.next;
        tempNode.next = new Node(16);
        tempNode = tempNode.next;
        tempNode.next = new Node(4);
        tempNode = tempNode.next;
//        while (k > 0) {
//            tempNode.next = new Node(k);
//            tempNode = tempNode.next;
//            if (k % 2 == 0) k = k - 2;
//        }
        printList(head);
        System.out.println("after Method calls");
//        head = reversePairsRecursive(head);
//        head = reversePairsIterative(head);
        head = reverseListRecursive(head, null);
//        head = reverseListIterative(head);
        printList(head);
    }

    public static Node reversePairsIterative(Node head) {

        if (head == null || head.next == null) return head; // No swap possible

        Node dummy = new Node(0); // Dummy node to simplify head swaps
        dummy.next = head;
        Node prev = dummy, first = head, second = head.next;

        while (second != null) {
            if ((first.data + second.data) % 2 == 0) { // Check if sum is even
                // Swap nodes
                prev.next = second;
                first.next = second.next;
                second.next = first;

                // Update pointers after swap
                prev = second; // Move prev to swapped node
                second = first.next; // Move second to next node
            } else {
                // Move forward without swapping
                prev = first;
                first = second;
                second = second.next;
            }
        }
        if (dummy.next == null)
            return head;
        else dummy.next = head;
        return dummy;
    }

    public static Node reversePairsRecursive(Node head) {

        if (head == null || head.next == null) return head;

        if ((head.data + head.next.data) % 2 == 0) {
            Node first = head;
            Node second = head.next;

            // Swap nodes
            first.next = reversePairsRecursive(second.next);
            second.next = first;

            return second;  // New head after swap
        }

        // Move to next pair
        head.next = reversePairsRecursive(head.next);
        return head;  // New head after swap
    }

    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverseListRecursive(Node head, Node prev) {
        if (head == null) return head;
        Node newNode = head.next;
        head.next = prev;
        prev = head;
        if (newNode != null) {
            head = reverseListRecursive(newNode, prev);
        }
        return head;
    }

    public static Node reverseListIterative(Node head) {
        if (head == null || head.next == null) return head;
        Node prevNode = null, currentNode = head, nextNode = head.next;
        while (nextNode != null) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = prevNode;
        return currentNode;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        linkedListProblem();
    }

    private static class Node {
        private final int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}


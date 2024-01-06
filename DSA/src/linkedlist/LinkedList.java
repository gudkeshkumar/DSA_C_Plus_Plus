package linkedlist; 

public class LinkedList {
    // Inner Node class
    public class Node {
        public int value; 
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // 
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
    
    public int getLength() {
        return length;
    }

    public void append(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the list is empty, have both head and tail
        // point at the new node.
        // The LL could be come empty if the original node was removed.
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, set the next node of the
            // current tail to the new node
            // and update the tail to be the new node
            tail.next = newNode;
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }

    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0)
            return null;

        // start at the head node
        Node temp = head;
        Node pre = head;
        // iterate through the linked list until the last node is reached
        while (temp.next != null) {
            pre = temp; // keep track of the second-to-last node
            temp = temp.next;
        }
        // set the new tail node to be the second-to-last node
        tail = pre;
        // remove the reference to the former tail node
        tail.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public void prepend(int value) {
        // create a new node with the specified value
        Node newNode = new Node(value);
        // if the linked list is currently empty
        if (length == 0) {
            // set the new node as both the head and tail of the linked list
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next reference to the current head node
            newNode.next = head;
            // set the new node as the new head node of the linked list
            head = newNode;
        }
        // increment the length of the linked list
        length++;
    }

    public Node removeFirst() {
        // if the length of the linked list is 0, return null
        if (length == 0)
            return null;
        // save a reference to the current head node
        Node temp = head;
        // set the new head node to be the next node in the linked list
        head = head.next;
        // remove the reference to the former head node
        temp.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set tail to null
        if (length == 0) {
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public Node getAtIndex(int index) {
        // if the index is less than 0 or greater than or equal to the length of the
        // linked list, return null
        if (index < 0 || index >= length)
            return null;
        // start at the head of the linked list
        Node temp = head;
        // traverse the linked list until the desired node is reached
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // return the pointer to the node at the desired index
        return temp;
    }

    public boolean set(int index, int value) {
        // retrieve the node at the specified index
        Node temp = getAtIndex(index);

        // if the index is out of bounds, return false
        if (temp != null) {
            // if the node is found, set the value of the node
            temp.value = value;
            // return true to indicate that the value was set successfully
            return true;
        }
        // return false if the index is out of bounds
        return false;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

}

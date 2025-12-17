package LinkedList;
import java.util.Scanner;
 class ListNode {
     public int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }
  }
public class MergeSortedList {
        public ListNode mergeTwoLists(ListNode  list1, ListNode list2) {

            if(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    list1.next=mergeTwoLists(list1.next,list2);
                    return list1;
                }
                else{
                    list2.next=mergeTwoLists(list1,list2.next);
                    return list2;
                }
            }
            if(list1==null)
                return list2;
            return list1;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter values for the linked list
        System.out.println("Enter values for the linked list (enter -1 to stop):");

        // Head of the linked list
        ListNode head = null;

        // Tail of the linked list
        ListNode tail = null;

        // Read values until the user enters -1
        while (true) {
            int val = scanner.nextInt();

            // If the user enters -1, stop reading input
            if (val == -1) {
                break;
            }

            // Create a new node with the entered value
            ListNode newNode = new ListNode(val);

            // If the list is empty, set the new node as the head
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, append the new node to the end of the list
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Print the linked list
        System.out.println("Linked list:");
        printLinkedList(head);
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


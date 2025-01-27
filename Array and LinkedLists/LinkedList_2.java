public class LinkedList_2 {
    int data;
    LinkedList_2 next;
    LinkedList_2 prev;

    public LinkedList_2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList_2_Operations {
    private LinkedList_2 head;

    public void add(int data) {
        LinkedList_2 newList = new LinkedList_2(data);
        if(head == null) {
            head = newList;
        }
        else {
            LinkedList_2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newList;
            newList.prev = current;
        }
    }

    public void display() {
        LinkedList_2 current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
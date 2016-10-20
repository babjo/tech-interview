/**
 * Created by LCH on 2016. 10. 20..
 */
public class SinglyLinkedList <T>{

    private Node head;
    private int size;

    public SinglyLinkedList(){
        head = null;
        size = 0;
    }

    class Node{
        T t;
        Node next;
    }

    public void add(Node target){
        if(head == null) head = target;
        else {
            Node it = head;
            while (it.next != null)
                it = it.next;
            it.next = target;
        }
        size++;
    }

    public void add(Node target, int location){
        if(location == 0) {
            target.next = head;
            head = target;
        }else {
            Node previous = get(location);
            target.next = previous.next;
            previous.next = target;
        }
        size++;
    }

    public void remove(int location){
        if(location == 0){
            head = head.next;
        }else {
            Node previous = get(location - 1);
            Node target = previous.next;
            previous.next = target.next;
        }
        size--;
    }

    public Node get(int location){
        if ( location > size ) {
            throw new IllegalArgumentException("The index [" + location + "] is greater than the current size [" + size + "].");
        }

        Node it = head;
        for (int i=0; i< location; i++)
            it = it.next;
        return it;
    }
}

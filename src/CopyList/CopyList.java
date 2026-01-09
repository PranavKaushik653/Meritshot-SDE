package CopyList;

public class CopyList {

    static class Node{
        int value;
        Node next;
        Node random;

        Node(int value){
            this.value=value;
        }
    }

    static Node copyRandomList(Node head){
        if(head == null)return null;

            Node current=head;
            while(current!=null){
                Node copy=new Node(current.value);
                copy.next=current.next;
                current.next=copy;
                current=copy.next;
            }
            current=head;
            while(current!=null){
                if (current.random != null) {
                    current.next.random = current.random.next;
                }
                current = current.next.next;
            }
            current= head;
            Node dummy = new Node(0);
            Node copyCurr = dummy;

            while (current!= null) {
                copyCurr.next = current.next;
                current.next = current.next.next;

                current = current.next;
                copyCurr = copyCurr.next;
            }
            return dummy.next;
        }
    }

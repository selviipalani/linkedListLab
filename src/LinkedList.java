public class LinkedList <E> {
    Node<E> head;
    Node<E> tail;
    int size;

    /**
     * constructor sets all our head, tail and size
     *
     */
    public LinkedList(){
        head = tail = null;
        size = 0;
    }

    /**
     * private class to create notes
     * @param <E>
     */
    private class Node<E> {
        E data;
        Node<E> next;

        /**
         * private class constructor to create nodes w data and next attribute accessible throughout class
         * @param value
         */
        public Node(E value) {
            data = value;
            next = null;

        }
    }
    /**
     * adds a node to the end of the list given a value
     * @param value
     */
    public void add(E value) {
        Node <E> node = new Node<E>(value);
        if (head==null) {
            head = node;
            tail=node;
        } else {
            tail.next=node;
            tail=node;
        }
    }

    /**
     * adds a node to the linked list given a specified index and value
     * @param index
     * @param value
     */
    public void add(int index, E value){
        Node node = new Node<E>(value);
        int range = 0;
        for(Node cur = this.head;cur != null;cur = cur.next){
            range += 1;
        }
        if(this.head == null){
            head = node;
            tail = node;
        } else if (index <= range){
            Node newNode = head;
            while(--index > 0){
                newNode = newNode.next;
            }
            node.next = newNode.next;
            newNode.next = node;

        }
        else{
            System.out.println("Sorry, index is out of range");
        }
    }

    /**
     * returns the item given a specified index
     * @param index
     * @return
     */
    public E get(int index){
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return (E) curr.data;
    }

    /**
     * removes an element from a linked list given a specified position
     * @param index
     * @return
     */
    public E remove(int index){
        if(index == 0){
            Node node = head;
            head = head.next;
            --size;
            return (E) node.data;
        }else{
            Node prev = head;
            for(int i = 0; i < index-1; i++){
                prev = prev.next;
            }
            Node newNode = prev.next;
            prev.next = newNode.next;
            --size;
            return (E) newNode.data;
        }
    }

    /**
     * reverses linked list
     * @param head
     * @return
     */
    public Node<E> reverse(Node<E> head){
        Node <E> prev = null;
        Node <E> current =  head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;
    }

    /**
     * to string to properly display linked list
     * @return
     */
    @Override
    public String toString() {
        return toString(head);
    }

    public String toString(Node front){
        if(front.next != null){
            return front.data + "->" + toString(front.next);
        }return (String) front.data;
    }

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.toString());
        list.add("e");
        System.out.println(list.toString());
        list.add(3,"d");
        System.out.println(list.toString());
        list.get(2);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.head = list.reverse(list.head);
        System.out.println(list.toString());
    }
}

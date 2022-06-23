package book;

public class Node {
    Node next = null;
    int value;
    public Node (int value){
        this.value = value;
    }

    public Node getNextNode(){
        if (next !=null) {
            return next;
        }
        return null;
    }

}

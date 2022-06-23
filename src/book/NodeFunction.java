package book;

import java.util.ArrayList;
import java.util.List;

public class NodeFunction {
    public boolean DeleteNode(Node node){
        if(node==null || node.getNextNode()== null){
            return false;
        }
        node.value =node.getNextNode().value;
        node.next = node.getNextNode().getNextNode();
        return true;
    }

    public Node AddTwoNode(Node a, Node b, int flag){
        Node result=null;
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        int newvale =(a.value+ b.value+flag)%10;
        int nextflag = (a.value+ b.value+flag)/10;
        result= new Node (newvale);
        if(a.getNextNode()!=null||b.getNextNode()!=null){
            result.next = AddTwoNode(a.getNextNode(), b.getNextNode(),nextflag);
        }
        return result;
    }

   public BNode LFS(BNode node){
        BNode result = null;
        if(node == null){
            return null;
        }
        if (node.getLeftNode()!=null){
           LFS(node.getLeftNode());
       }
       if (node.getRightNode()!=null) {
           LFS(node.getLeftNode());
       }
        return result;
   }


//    public BNode BFS(BNode node){
//        Queue<BNode> queue = new LinkedList<BNode>();
//        while(!queue.isEmpty()){
//            BNode next =  queue.poll();
//        }
//
//        return result;
//    }

    public List<Integer> NodeTOList(BNode node){
        List<Integer> result = new ArrayList<Integer>();
        if(node==null){
            return null;
        }
        result.add(node.value);
        if(node.getLeftNode()!=null){
            NodeTOList(node.getLeftNode());
        }
        if(node.getRightNode()!=null){
            NodeTOList(node.getRightNode());
        }


        return result;
    }
    public Node findCrossNode(Node a, Node b){
        Node l1 = a; Node l2 = b;
        if (l1 == null|| l2 ==null){
            return null;
        }
        while(l1!=l2){
            if(l1.next!=null){
                l1 = l2;
            }else{
                l1 = l1.next;
            }
            if(l2.next!=null){
                l2 = l1;
            }else{
                l2 = l2.next;
            }
        }
        return l1;
    }
}

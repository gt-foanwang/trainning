package com.company.book;

public class BNode {
    BNode left = null;
    BNode right = null;
    int value;
    public BNode(int value){
        this.value = value;
    }

   public BNode getLeftNode(){
        return this.left;
   }

    public BNode getRightNode(){
        return this.right;
    }
}

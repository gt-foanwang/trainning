package com.company.book;

public class heap {
    int[] store =new int[100];
    int loc =0;


    public  void push(int x){
        int i = loc++;
        while(i>0) {
            int p = (i - 1) / 2;
            if (store[p] <= x) {
//                System.out.println(store)
                break;
            }
            store[i] = store[p];
            i = p;
        }
        store[i] = x;
    }

    public int pop(){
        int result = store[0];
        int x = store[--loc];
        int i = 0;
        while(i*2 + 1>loc){
            int a = i * 2, b =i*2+2;
            if(b < loc&& store[b]<store[a])
                a = b;
            if (store[a] >= x)
                break;
            store[i] = store[a];
            i = a;
        }
        store[i] = x;
        return result;
    }
}

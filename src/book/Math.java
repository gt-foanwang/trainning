package com.company.book;

import java.util.ArrayList;
import java.util.List;

public class Math {
    public boolean isPrime(int number){
        for(int i = 2; i < number-1; i++){
           int a = number%i;
           if(a == 0){
               return false;
           }
        }
        return true;
    }

    public boolean isPrime2(int number){
        for(int i =2;i+i<number;i++){
            int a = number%i;
            if(a == 0) {
                return false;
            }
        }
        return true;
    }

    public Integer[] primeArray(int number){
        List<Integer> primeArray =  new ArrayList<Integer>();
        for(int i=2;i< number;i++){
            if(this.isPrime(i)){
                primeArray.add(i);
            }
        }
        Integer[] result = new Integer[primeArray.size()];
        result = primeArray.toArray(result);
        return result;
    }
    public Integer primeCount(int a, int b){
        Integer count= 0;

        if(a < 2){
            a = 2;
        }
        for(int i=a;i< b;i++){
            if(this.isPrime(i)){
               count+=1;
            }
        }
        return count;
    }
}


package com.company.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class basic {
    public boolean checkZoo(){
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int length = name.length();
        if(length>20||length <=0){
            return false;
        }
        int zcount = 0;
        int ocount= 0;
        for(int i = 0; i < length;i++){
            if(name.charAt(i)=='z'){
                zcount+=1;
            }
            if(name.charAt(i)=='o'){
                ocount+=1;
            }
        }
        if(ocount*2 != zcount){
            return false;
        }
        return true;
    }

    public void isDivisible(){
        Scanner s = new Scanner(System.in);
        int N = 0;
        Deque<Integer> dequeX = new ArrayDeque<>();
        N = s.nextInt();
        int[] data = new int[N];
        String sum = "";
        for(int i=0; i<N; i++){
            data[i] = s.nextInt()%10;
        }
        if(data[N-1]%10 ==0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    public String solve(int[] A){
        int length = A.length;
        int even = 0;
        int odd = 0;
        if(length%2!=0){
            return "NON";
        }
        for(int i =0;i < length;i++){
            System.out.println("i:"+i+" A[i]:"+A[i]);
            int temp = 0;
            if(i <= length/2-1){
                temp = Character.getNumericValue(String.valueOf(A[i]).charAt(0));
            }else{
                int len = String.valueOf(A[i]).length();
                temp = Character.getNumericValue(String.valueOf(A[i]).charAt(len-1));
            }
            System.out.println("i:"+i+"temp:"+temp);
            if(i%2==0){
                odd +=temp;
                System.out.println("odd number:"+odd);
            }else{
                int len = String.valueOf(A[i]).length();
                even+=temp;
                System.out.println("        even number:"+even);
            }
        }

        if(Math.abs(odd-even)%11 == 0) {
            return "OUI";
        }
        return "NON";
    }

    public void bestIndex() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i_A=0; i_A<arr_A.length; i_A++)
        {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int max = Integer.MAX_VALUE;
        for(int i = 0;i < N; i++){
            int sum =0;
            int length = N-i;
            int right = 1;
            int j= i;
            while(length > 0) {
                for (int k = 0; k < right; k++) {
                    sum += A[j++];
                }
                right++;
                length -= right;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
        wr.close();
        br.close();
    }

    public void MinimizeCost(){
        int[] A = new int[10];
        List B = Arrays.asList(A);
        Collections.sort(B);
    }

}

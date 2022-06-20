package com.company.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataStructure {
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int i = 0;i < T;i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] A = new int[N];
            String[] arr_A = br.readLine().split(" ");
            Nondecreasing(N, arr_A);
        }
        br.close();
    }
    public void Nondecreasing(int N, String[] stringarray){
        int[] input = new int[N];
        int temp = Integer.parseInt(stringarray[0]);
        String result ="";
        for(int i =0 ;i < N;i++){
            if(temp > input[i]){
                input[i] = temp;
            }else{
                temp = input[i];
            }
            result +=temp+" ";
        }
        System.out.println(result);
    }
    public void MaxmumSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arrayA = br.readLine().split("");
        int[] A = new int[N];
        int count =0;
        int sum = 0;
        for(int i = 0 ;i < arrayA.length; i++){
            System.out.println(Integer.parseUnsignedInt(arrayA[i]));
        }
//        for(int i = 0 ;i < arrayA.length; i++){
//            System.out.println(Integer.parseInt(arrayA[i]));
//            if(Integer.parseInt(arrayA[i]) >0){
//                sum+=Integer.parseInt(arrayA[i]);
//                count+=1;
//            }
//        }
        System.out.println(sum+" "+count);
        br.close();
        wr.close();
    }
}

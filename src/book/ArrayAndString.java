package com.company.book;

import java.util.*;

public class ArrayAndString {
    public int IsSpecial(String check){
        int result =0;
        char[] temp = check.toCharArray();
//        for(int i =0; i < check.length();i++){
//            if(){
//
//            }
//        }
        return result;
    }

    public int isInclud(String a, String b){
        if(a.length()!=b.length()){
            return -1;
        }
        Map<String,Integer> checkbox = new HashMap<String, Integer>();
        for(int i =0; i< a.length() ;i++){
            String check = a.substring(i,i+1);
            if(checkbox.containsKey(check)){
                int temp =checkbox.get(check);
                checkbox.put(check, temp+1);
            }else{
                checkbox.put(check,1);
            }
        }
        for(int i=0; i< b.length();i++){
            String check = b.substring(i,i+1);
            if(checkbox.containsKey(check)){
                int temp =checkbox.get(check);
                if(temp>1){
                    checkbox.put(check, temp-1);
                }else{
                    checkbox.remove(check);
                }
            }else{
                return -1;
            }
        }
        if(checkbox.isEmpty()) {
            return 1;
        }else{
            return -1;
        }
    }

    public String replaceSpace(String A, String replace){
        String newString = A.replace(" ", replace);
        return newString;
    }

    public String pressString(String orangeString){
        String result ="";
        char[] charlist= orangeString.toCharArray();
        int len = charlist.length;
        System.out.println("len:"+len);
        int start = 0;
        for(int i=1; i < len; i++){
            if(charlist[i-1]!=charlist[i]){
                result += shortString(orangeString, start, i-1);
                start = i;
                System.out.println("i:"+i+" start:"+start+ " result:"+result);
            }
            if(i==(len-1)){
                result += shortString(orangeString, start, i);
                start = i;
                System.out.println("i:"+i+" start:"+start+ " result:"+result);
            }
        }
        if(result.length()>= len){
            result =  orangeString;
        }
        return result;
    }
    public String shortString(String checkstring, int start, int end){
        System.out.println("shortString.....start:"+start+" end:"+end);
        char[] charlist= checkstring.toCharArray();
        String result = checkstring.substring(start,start+1);
        int len = end -start +1;
        result +=len;
        return result;
    }

    public boolean isSubstring(String s1, String s2){
        boolean result = false;
        char[] temp = s1.toCharArray();
        int len = s1.length();
        for(int i = 0; i < len-1; i++){
            for(int count=1; count < len; count++){
                
            }
        }
        return result;
    }
}

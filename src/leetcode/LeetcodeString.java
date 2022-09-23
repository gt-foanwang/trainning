package leetcode;

import java.util.Stack;

public class LeetcodeString {
    public String longestCommonPrefix(String[] strs) {
        String check = strs[0];
        for (int j = 1; j < strs.length; j++) {
           while(strs[j].indexOf(check)!=0){
               check  = check.substring(0,check.length()-1);
           }
        }
        return check;
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        
        return true;
    }
}

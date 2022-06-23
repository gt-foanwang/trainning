package leetcode;

import java.io.IOException;
import java.util.*;


public class easy {

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        int length = nums.length;
        for(int i =0; i < length-1;i++ ){
            int j = i+1;
            while(i<j){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
                j++;
            }

        }
        return result;
    }
    public static boolean isPalindrome(int x) {
        char[] str = Integer.toString(x).toCharArray();
        Integer start =0;
        Integer end =  str.length-1;
        while(start < end){
            if(str[start]==str[end]){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(String s) {
        char[] array = s.toCharArray();
        int result= 0;
        Integer len = s.length();
        Queue<Character> queue = new LinkedList<Character>();
        queue.add('I');
        char temp = 'I';
        for(int i = len-1; i >= 0; i--) {
            if (array[i] == 'I') {
                 temp = queue.poll();
                if(temp=='V'||temp=='X'){
                    result -= 1;
                }else{
                    result += 1;
                }
                queue.add(array[i]);
            }

            if (array[i] == 'V') {
                queue.clear();
                result += 5;
                queue.add(array[i]);
            }

            if (array[i] == 'X') {
                temp = queue.poll();
                if (temp == 'L' || temp == 'C') {
                    result -= 10;
                } else {
                    result += 10;
                }
                queue.add(array[i]);
            }

            if (array[i] == 'L') {
                queue.clear();
                result += 50;
                queue.add('L');
            }

            if (array[i] == 'C') {
                temp = queue.poll();
                if (temp == 'D' ||temp == 'M') {
                    result -= 100;
                } else {
                    result += 100;
                }
                queue.add(array[i]);
            }

            if (array[i] == 'D') {
                queue.clear();
                result += 500;
                queue.add(array[i]);
            }

            if (array[i] == 'M') {
                queue.clear();
                result += 1000;
                queue.add(array[i]);
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        int strslen = strs.length;
        if(strslen==0){
            return "";
        }
        int c = 0;
        String prefix = strs[0];
        for(int i = 1;i < strslen;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix= prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        Stack<Character> temp = new Stack<Character>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                temp.push(c);
            }else if(!temp.empty()){
                char pop = temp.pop();
                if(c == ')' && pop != '(') return false;
                else if(c == ']' && pop != '[') return false;
                else if(c == '}' && pop != '{') return false;
            }
            else
                return false;
        }
        if(!temp.isEmpty())
            return false;
        return true;
    }






    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i < nums.length;i++){
            set.add(nums[i]);
        }
        return set.size();
    }
    public int removeElement(int[] nums, int val) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i < nums.length;i++){

        }
        return -1;
    }

    public static boolean checkCommon(String compare,Integer size, String[] strs){
        for(int i = 1;i < strs.length;i++){
            if(!compare.equals(strs[i].indexOf(0,size))){
                return false;
            }
        }
        return true;
    }


    public static int strStr(String haystack, String needle) {
        int needlelen= needle.length();
        if (haystack.length() ==needlelen&&haystack.equals(needle)){
            return 0;
        }
        for(int i =0;i<haystack.length()-needlelen+1;i++){
            if(haystack.substring(i,i+needlelen).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
            mid = start+(end-start)/2;
        }
        if(start<=end){
            return start-1;
        }else{
            return end+1;
        }

    }

    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        for(int i =0;i < nums.length;i++){
            result = Math.max(result+nums[i],result);
        }
        return result;
    }

    public static int lengthOfLastWord(String s) {
        char[] temp = s.toCharArray();
        int len = s.length();
        int result =0;
        for(int i =len-1; i >=0; i--) {
            if (temp[i] != ' ') {
                    result += 1;
            }else{
                if(result!=0){
                    break;
                }
            }
        }
        return result;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag = true;
        for(int i =len-1; i >= 0; i--){
            int total = digits[i];
            if(flag){
                total =digits[i]+1;
            }
            if(total/10!=1){
                flag = false;
            }
            digits[i] = total%10;
        }
        if(flag == true){
            int[] sol= new int[digits.length+1];
            for(int i =0; i<sol.length;i++){
                System.out.print(sol[i]+" ");
            }
            sol[0]=1;
            return sol;
        }else{
            return digits;
        }
    }


    public static String addBinary(String a, String b) {
        if(a.length()==0){
            return b;
        }
        if(b.length()==0){
            return a;
        }
        char[] tempa = a.toCharArray();
        char[] tempb = b.toCharArray();
        boolean flag = false;
        int dis = Math.abs(a.length()- b.length());
        Stack<String> stack = new Stack<String>();
        if(tempa.length> tempb.length){
            for(int i =tempa.length-1; i >= 0;i--){
                int total =0;
                if(flag == true) {
                    total+=1;
                }
                if(tempa[i]=='1'){
                    total+=1;
                }
                if((i-dis>=0)&&tempb[i-dis]=='1'){
                    total+=1;
                }
                if (total>=2){
                    flag=true;
                }else{
                    flag=false;
                }
                if(total%2 == 1){
                    stack.push("1");
                }else{
                    stack.push("0");
                }
                System.out.println("total:"+total+"flag:"+flag);
            }
        }else {
            for(int i = tempb.length-1; i >= 0;i--){
                int total =0;
                if(flag == true) {
                    total+=1;
                }
                if((i-dis>=0)&&tempa[i-dis]=='1'){
                    total+=1;
                }
                if(tempb[i]=='1'){
                    total+=1;
                }
                if (total>=2){
                    flag=true;
                }else{
                    flag=false;
                }
                if(total%2 == 1){
                    stack.push("1");
                }else{
                    stack.push("0");
                }
            }
        }
        if (flag==true){
            stack.push("1");
        }
        int size = stack.size();
        String result = "";
        for(int i =0;i < size ;i++){
            result= result+stack.pop();
        }
        return result;
    }

    public static int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int start= 1;
        int end = x;
        while(start< end) {
            int mid = start + (end - start)/2;
            int temp = x/mid;
            if (temp== mid) {
                return mid;
            } else if (temp <mid) {
                end = mid;
            } else if (mid < x / mid) {
                start = mid + 1;

            }
        }
        return (int)start-1;
    }




    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void main(String[] args) throws IOException {
        String[] strs = new String[]{"abc","aca"};
        int[] array1 = new int[]{9};
        int[] array2 = new int[]{9,9,9,9,9};
//        ListNode list1 = new ListNode(array1[0]);
        System.out.println(mySqrt(2147395599));
    }
}

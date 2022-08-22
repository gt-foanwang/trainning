package leetcode;

import java.util.Arrays;

public class LeeCodeString {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] result = new String[1];
        for(int i = 0;i < list1.length;i++){
            for(int j =0; j< list2.length; j++){
                if(list1[i].equals(list2[j])){
                    result[0] = list1[i];
                }
            }
        }
        return result;
    }
}

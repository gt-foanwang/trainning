package leetcode;

public class array {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0; i < nums.length;i++){
            for(int j =i+1; j<nums.length;j++){
                if(target == nums[i]+nums[j]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int []nums = {2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.print("num[0]:"+result[0]);
        System.out.print("num[1]:"+result[1]);
    }
}

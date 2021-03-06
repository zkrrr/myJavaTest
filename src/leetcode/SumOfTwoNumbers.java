package leetcode;

/*

给定一个整数数组nums和一个目标值target,请你在该数组中找出和为目标值的那两个整数,
并返回他们的数组下标.
你可以假设每种输入只会对应一个答案.但是,你不能重复利用这个数组中同样的元素.

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */

public class SumOfTwoNumbers {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] result = SumOfTwoNumbers.twoSum(nums, target);
        System.out.println("["+result[0]+", "+result[1]+"]");
    }
}

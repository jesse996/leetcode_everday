import java.util.Arrays;

/**
 * 最接近的三数之和 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<len-2;i++){
            int j=i+1,k=len-1;
            while(j<k){
                int tmp=nums[i]+nums[j]+nums[k];
                sum=Math.abs(tmp-target)<Math.abs(sum-target)?tmp:sum;
                if(tmp==target){
                    return tmp; 
                }else if(tmp>target) k--;
                else j++;
            }
        }
        return sum;
    }
}
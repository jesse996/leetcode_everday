import java.util.*;

/**
 * 三数之和 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list =new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i>0&&  nums[i]==nums[i-1]   ) continue;
            int j=i+1,k=len-1;
            while(j<k){
                int tmp=nums[i]+nums[j]+nums[k];
                if(tmp==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(k>j && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }else if(tmp>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return list;
    }
}
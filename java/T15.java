/**
 * 15. 三数之和
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */

//1.排序 2.
import java.util.*;

class T15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = i + 1; j < nums.length-1; j++) {
          if (map.containsKey(-nums[i] - nums[j])) {
            list.add(Arrays.asList(nums[i], nums[j], -(nums[j] + nums[i])));
            continue;
          }
          map.put(nums[j], j);
          while(nums[j]==nums[j+1]) j++;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    // System.out.println(new T15().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    Integer[] datas = new Integer[]{1,2,3,4,5};
    List list = Arrays.asList(datas);
    System.out.println(list.size());
  }
}
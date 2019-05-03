// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

// 你可以假设数组中不存在重复的元素。

// 你的算法时间复杂度必须是 O(log n) 级别。

// 示例 1:

// 输入: nums = [4,5,6,7,0,1,2], target = 0
// 输出: 4
// 示例 2:

// 输入: nums = [4,5,6,7,0,1,2], target = 3
// 输出: -1

//先排序，再查找
class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0)
      return -1;
    int[] arr = new int[nums.length];
    int i = 0, len = nums.length;
    while (i < len - 1 && nums[i] < nums[i + 1])
      i++;
    for (int j = 0; j < len; j++) {
      arr[(j + i) % len] = nums[j];
    }
    for (int o = 0; o < len; o++) {
      System.out.print(arr[o] + " ");
    }
    int index = this.bs(arr, target);
    if (index == -1)
      return index;
    return (index + i + 1) % len;
  }

  public int bs(int[] arr, int target) {
    int len = arr.length;
    int min = 0, max = len - 1, mid;
    while (min <= max) {
      mid = (min + max) / 2;
      if (arr[mid] < target) {
        min = mid + 1;
      } else if (arr[mid] > target) {
        max = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}

public class T33 {
  public int search(int[] nums, int target) {
    return search(nums, 0, nums.length - 1, target);
  }

  private int search(int[] nums, int low, int high, int target) {
    if (low > high)
      return -1;
    int mid = (low + high) / 2;
    if (nums[mid] == target)
      return mid;
    if (nums[mid] < nums[high]) {//右边有序
      if (nums[mid] < target && target <= nums[high])
        return search(nums, mid + 1, high, target);
      else
        return search(nums, low, mid - 1, target);
    } else {//左边有序
      if (nums[low] <= target && target < nums[mid])
        return search(nums, low, mid - 1, target);
      else
        return search(nums, mid + 1, high, target);
    }
  }


  public static void main(String[] args) {
    T33 s = new T33();
    System.out.println(s.search(new int[] { 3, 1 }, 1));
    // int a = new Solution().bs(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, }, -4);
    // System.out.println(a);
  }
}
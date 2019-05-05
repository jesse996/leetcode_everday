import java.util.ArrayList;
import java.util.List;

// 给定一个没有重复数字的序列，返回其所有可能的全排列。

// 示例:

// 输入: [1,2,3]
// 输出:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

public class T46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    recursion(nums, 0, list);
    return list;
  }

  private static void recursion(int[] nums, int start, List<List<Integer>> list) {
    if (start >= nums.length - 1) { // 此时全排列已经完成, 把数组装入List
      List<Integer> temp = new ArrayList<Integer>();
      for (int i : nums) // 不能对int[] 数组使用Arrays.asList哦
        temp.add(i);
      list.add(temp);
      return;
    }
    // 把后面的数组元素交换到start位置,并对start+1剩下的元素进行全排列
    for (int i = start; i < nums.length; i++) {
      swap(nums, start, i);
      recursion(nums, start + 1, list);
      swap(nums, start, i); // 部分全排完成再交换回去!!!
    }
  }

  private static void swap(int[] nums, int i1, int i2) {
    int temp = nums[i1];
    nums[i1] = nums[i2];
    nums[i2] = temp;
  }
  public static void main(String[] args) {
    System.out.println( new T46().permute(new int[]{1,2,3}));
  }
}


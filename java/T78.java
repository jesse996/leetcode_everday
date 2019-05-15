import java.util.*;

// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。

// 示例:

// 输入: nums = [1,2,3]
// 输出:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
//n=0,ret=1
//n=1,ret=2
//n=2,ret=4  == 2+f(2-1)
//n=3,ret=7  == 3+f(3-1)
// 

//用map[i][j]表示nums[i][j]的子串
class T78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();// 最后输出的结果
        int n = nums.length;
        if (n == 0)
            return ret;
        ret.add(new ArrayList<Integer>());// 初始化
        for (int i : nums) {
            List<Integer> tmp;
            List<List<Integer>> ttmp = new ArrayList<List<Integer>>();
            for (List<Integer> j : ret) {
                tmp = new ArrayList<Integer>(j);
                tmp.add(i);
                ttmp.add(tmp);
            }
            ret.addAll(ttmp);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.print(subsets(new int[] { 1, 2, 3 }).toString());
    }
}
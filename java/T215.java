// 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

// 示例 1:

// 输入: [3,2,1,5,6,4] 和 k = 2
// 输出: 5
// 示例 2:

// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// 输出: 4
// 说明:

// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

class Solution {
  public int findKthLargest(int[] nums, int k) {
    return quickFind(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quickFind(int[] arr, int l, int r, int positon) {
    if (l >= r)
      return arr[l];
    int i = l, j = r;
    swap(arr, l, (l + r) / 2);
    int v = arr[l];
    while (i < j) {
      while (i < j && arr[j] >= v)
        j--;
      arr[i] = arr[j];
      while (i < j && arr[i] <= v)
        i++;
      arr[j] = arr[i];

    }
    arr[i] = v;
    if (positon < i) {
      return quickFind(arr, l, i - 1, positon);
    } else if (positon > i) {
      return quickFind(arr, i + 1, r, positon);
    }
    return v;

  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
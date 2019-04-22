
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * 则中位数是 2.0 示例 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 */

class T4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i, j, m = nums1.length, n = nums2.length;
    if (m > n) {
      // 确保m<=n
      int[] tem = nums1;
      nums1 = nums2;
      nums2 = tem;
      int tmp = m;
      m = n;
      n = tmp;
    }
    int imin = 0, imax = m;
    while (imin <= imax) {
      i = (imin + imax) / 2;
      j = (n + m + 1) / 2 - i;
      if (i < imax && nums2[j - 1] > nums1[i]) {
        // i too small
        imin = i + 1;
      } else if (i > imin && nums1[i - 1] > nums2[j]) {
        // i too large
        imax = i - 1;
      } else {
        // find i
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          maxLeft = nums1[i - 1];
        } else {
          maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n) % 2 != 0) {
          return maxLeft;
        }
        int maxRight = 0;
        if (i == m) {
          maxRight = nums2[j];
        } else if (j == n) {
          maxRight = nums1[i];
        } else {
          maxRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft + maxRight) / 2.0;
      }
    }
    return 0.0;
  }

  public static void main(String[] args) {
    System.out.println(new T4().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
  }
}
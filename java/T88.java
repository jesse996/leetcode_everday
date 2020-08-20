// 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

// 说明:

// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
// 示例:

// 输入:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// 输出: [1,2,2,3,5,6]


//一，从前往后，需要辅助空间
public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c=nums1.clone();
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(c[i]<nums2[j]){
                nums1[k++]=c[i++];
            }else{
                nums1[k++]=nums2[j++];
            }
        }
        while(i<m){
            nums1[k++]=c[i++];
        }
        while(j<n){
            nums1[k++]=nums2[j++];
        }
    }
}
//二，从后往前，不需要辅助空间

class T88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p= m-- + n-- -1;
        while(m>=0&&n>=0){
            nums1[p--]=nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        while(n>=0){
            nums1[p--]=nums2[n--];
        }
    }
}
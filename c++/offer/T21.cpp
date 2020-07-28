//
// Created by 95157 on 2020/7/28.
//
#include <vector>

using namespace std;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
vector<int> exchange(vector<int> &nums) {
    int i = 0, j = nums.size() - 1;
    while (i < j) {
        while (i < j && (nums[i] & 1) != 0) i++;
        while (i < j && (nums[j] & 1) == 0) j--;
        auto t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    return nums;
}
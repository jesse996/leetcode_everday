/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let map = {}
  for (let i = 0; i < nums.length - 1; i++) {
    map[target - nums[i]] = i
    if (nums[i + 1] in map) return [map[nums[i + 1]], i + 1]
  }
}

/**
 * 用一个哈希表来存储，先循环队列，让当前值为value，让target-value为当前的key，就是key+value=target
 * 判断下一个value是否存在于哈希中的key中，只用判断下一个，因为只会循环一次，每次都会加入到哈希表中
 */
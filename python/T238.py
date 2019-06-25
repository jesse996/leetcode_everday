class Solution:
    def productExceptSelf(self, nums):
        left = 1
        right = 1
        i = 0
        output = list.copy(nums)
        while i < len(nums):
            output[i] = left
            left *= nums[i]
            i += 1
        j = len(nums)-1
        while j >= 0:
            output[j] *= right
            right *= nums[j]
            j -= 1
        return output


s = Solution()
nums = list(range(1, 5))
print(s.productExceptSelf(nums))

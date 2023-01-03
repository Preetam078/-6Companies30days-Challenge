//You are given an integer array nums of length n. Return maximum length of Rotation Function.
class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int sum = 0;
        int f = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f += i* nums[i];
        }
        int ans = f;
        int n = nums.length;
        for(int i = n-1; i >= 1; i--) {
            f = f + sum - n*nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
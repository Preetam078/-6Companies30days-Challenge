class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[]v = new int[len];
        
        for(int i = 0; i < len; i++) {
            v[i] = nums[i];
        }
        
        Arrays.sort(v);
        int start = 0, end = len-1;
        
        while(start <= len-1 && v[start] == nums[start]) start++;
        while(end >= 0 && v[end] == nums[end]) end--;
        
        if(start > len-1 || end < 0) return 0;
        return end-start+1;
    }
}
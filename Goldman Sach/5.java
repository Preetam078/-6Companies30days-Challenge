class Solution {
    public boolean isPossible(int[] nums) {
        // This hashmap tells us about whether a number in num is available for a job or not
        HashMap<Integer,Integer> avaibilityMap = new HashMap<>();
        
        // This hashmap tells a number (say x), if there is a job vacancy for them
        HashMap<Integer,Integer> wantMap = new HashMap<>();
        for(int i : nums){
            avaibilityMap.put(i, avaibilityMap.getOrDefault(i,0)+1);
        }
      
        for(int i=0;i<nums.length;i++){
            if(avaibilityMap.get(nums[i])<=0){
                continue;
            }

            else if(wantMap.getOrDefault(nums[i],0)>0){
 
                avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i], wantMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i]+1, wantMap.getOrDefault(nums[i]+1,0)+1);
            }
            else if(avaibilityMap.getOrDefault(nums[i],0)>0 && avaibilityMap.getOrDefault(nums[i]+1,0)>0 && avaibilityMap.getOrDefault(nums[i]+2,0)>0){
 
                avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
                avaibilityMap.put(nums[i]+1, avaibilityMap.getOrDefault(nums[i]+1,0)-1);
                avaibilityMap.put(nums[i]+2, avaibilityMap.getOrDefault(nums[i]+2,0)-1);
                wantMap.put(nums[i]+3, wantMap.getOrDefault(nums[i]+3,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
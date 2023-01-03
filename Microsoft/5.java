//Largest Divisible Subset.


//Recursion solution (TLE)
class Solution {
    private List<Integer>ans = new ArrayList<>();
    private List<Integer>res = new ArrayList<>();
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        solve(nums, 0, 1);
        return res;
    }
    
    private void solve(int[]nums, int i, int prev) {
        //base condition
        if(i >= nums.length) {
            if(ans.size() > res.size()) {
                res.clear();
                res.addAll(ans);
            }
            return;
        }
        if(prev%nums[i] == 0 || nums[i]%prev == 0) {
            ans.add(nums[i]);
            solve(nums, i+1, nums[i]);
            ans.remove(ans.size()-1);
        }
        solve(nums, i+1, prev);
    }
}


//Memorization 
class Solution {
    static List<Integer> res;
    static int dp[];
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        dp=new int[nums.length+1];
        List<Integer> ans=new ArrayList<>();
        res=new ArrayList<>();
        Arrays.fill(dp,-1);
        solve(nums,0,1,ans);
        return res;
    }
    
    static void solve(int nums[], int i, int prev,List<Integer> ans){
        
        if(i>=nums.length) {
            if(ans.size()>res.size()){
                res.clear();
                res.addAll(ans);
            }
            return;
        }
        
        if(ans.size()>dp[i] && (nums[i]%prev==0 || prev%nums[i]==0)){
            dp[i]=ans.size();
            ans.add(nums[i]);
            solve(nums,i+1,nums[i],ans);
            ans.remove(ans.size()-1);
        }
        
        solve(nums,i+1,prev,ans);  
    }
}
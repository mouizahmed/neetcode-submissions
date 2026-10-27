class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] res = new int[n];

        // build prefix product array
        pref[0] = 1;
        for (int i = 1; i < n; i++) {
           pref[i] = pref[i-1] * nums[i-1];
        }

        // build suffix product array
        suff[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }
        
        // build the result
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];            
        }

        return res;
    }
}  

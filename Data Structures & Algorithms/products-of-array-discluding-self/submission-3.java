class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        int[] pref = new int[len];
        int[] suff = new int[len];

        // build prefix product
        pref[0] = 1;
        for (int i = 1; i < len; i++) pref[i] = pref[i-1] * nums[i-1];

        // build suffix product
        suff[len-1] = 1;
        for (int i = len-2; i >= 0; i--) suff[i] = suff[i+1] * nums[i+1];
        
        // build res
        for (int i = 0; i < len; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}  

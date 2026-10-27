class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];
        int required = 0;

        for (char c : s1.toCharArray()) if (need[c - 'a']++ == 0) required++;

        int have = 0, l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            window[c-'a']++;
            if (need[c-'a'] == window[c-'a']) have++;
            while (have == required) {
                if ((r-l+1) == s1.length()) return true;
                
                c = s2.charAt(l);
                window[c-'a']--;
                if (window[c-'a'] < need[c-'a']) have--;
                l++;
            }
        }

        return false;
    }
}

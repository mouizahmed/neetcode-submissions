class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];

        int required = 0;
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            if (need[index] == 0) required++;
            need[index]++;
        }

        int have = 0, l = 0;
        for (int r = 0; r < s2.length(); r++) {
            int index = s2.charAt(r) - 'a';
            window[index]++;
            if (window[index] == need[index]) have++;

            while (have == required) {
                if ((r-l+1) == s1.length()) return true;

                index = s2.charAt(l) - 'a';
                window[index]--;
                if (window[index] < need[index]) have--;
                l++;
            }
        }

        return false;
    }
}

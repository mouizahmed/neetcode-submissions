class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_count = new int[26];

        for (char c : s.toCharArray()) {
            s_count[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            s_count[c-'a']--;
        }


        for (int count : s_count) {
            if (count != 0) return false;
        }

        return true;
    }
}

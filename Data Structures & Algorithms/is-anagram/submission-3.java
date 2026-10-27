class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] s_count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            s_count[s.charAt(i)-'a']++;
            s_count[t.charAt(i)-'a']--;
        }

        for (int count : s_count) {
            if (count != 0) return false;
        }

        return true;
    }
}

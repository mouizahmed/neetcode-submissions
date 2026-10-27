class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> cur = new HashSet<>();
        int l = 0;
        int length = 0;

        for (int r = 0; r < s.length(); r++) {
            while (cur.contains(s.charAt(r))) {
                cur.remove(s.charAt(l));
                l++;
            }

            cur.add(s.charAt(r));
            length = Math.max(length, r-l+1);
        }

        return length;
    }
}

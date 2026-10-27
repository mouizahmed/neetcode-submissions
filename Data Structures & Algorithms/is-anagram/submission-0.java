class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s_chars = new HashMap<>();
        Map<Character, Integer> t_chars = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            if (s_chars.containsKey(ch)) s_chars.put(ch, s_chars.get(ch) + 1);
            else s_chars.put(ch, 1);
        }

        for (Character ch : t.toCharArray()) {
            if (t_chars.containsKey(ch)) t_chars.put(ch, t_chars.get(ch) + 1);
            else t_chars.put(ch, 1);
        }

        if (s_chars.equals(t_chars)) return true;
        else return false;
    }
}

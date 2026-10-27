class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] c_count = new int[26];

            for (char c : s.toCharArray()) {
                c_count[c-'a']++;
            }
            map.computeIfAbsent(Arrays.toString(c_count), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

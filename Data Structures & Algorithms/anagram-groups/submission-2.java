class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> res;

        for (String s : strs) {
            int[] occurences = new int[26];
            for (int i = 0; i < s.length(); i++) {
                occurences[s.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(occurences);
                List<String> list;
                if (map.containsKey(key)) {
                    list = map.get(key);
                    list.add(s);
                } else {
                    list = new ArrayList<>();
                    list.add(s);
                }
                map.put(key, list);
        }
        res = new ArrayList<>(map.values());
        return res;
    }
}

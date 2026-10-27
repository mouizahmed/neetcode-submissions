class Solution {
    public int characterReplacement(String s, int k) {
        int L = 0, maxF = 0, res = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int R = 0; R < s.length(); R++) {
            count.put(s.charAt(R), count.getOrDefault(s.charAt(R), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(R)));

            while ((R - L + 1) - maxF > k) {
                count.put(s.charAt(L), count.get(s.charAt(L)) - 1);
                L++;
            }

            res = Math.max(res, R - L + 1);

        }

        return res;

    }
}

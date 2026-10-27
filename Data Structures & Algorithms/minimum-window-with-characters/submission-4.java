class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int L = 0, have = 0, need = countT.size(), resLen = Integer.MAX_VALUE;

        int[] res = {-1, -1};

        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(countT.get(c))) have++;

            while (have == need) {
                if (R - L + 1 < resLen) {
                    resLen = R - L + 1;
                    res[0] = L;
                    res[1] = R;
                }

                char leftC = s.charAt(L);
                window.put(leftC, window.get(leftC) - 1);

                if (countT.containsKey(leftC) && window.get(leftC) < countT.get(leftC)) have--;
                L++;
            }


        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] +1);
    }
}

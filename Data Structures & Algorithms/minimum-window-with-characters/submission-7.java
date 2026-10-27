class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int required = countT.size(), have = 0, l = 0, bestLen = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(countT.get(c))) have++;

            while (required == have) {
                if ((r-l+1) < bestLen) {
                    res[0] = l;
                    res[1] = r;
                    bestLen = r-l+1;
                }
                c = s.charAt(l);
                window.put(c, window.get(c)-1);
                
                if (countT.containsKey(c) && window.get(c) < countT.get(c)) have--;
                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}

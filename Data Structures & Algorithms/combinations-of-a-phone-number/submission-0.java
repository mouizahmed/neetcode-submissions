class Solution {

    String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int start, String path) {
        if (start >= digits.length()) {
            res.add(path);
            return;
        }

        String chars = digitMap[digits.charAt(start) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(digits, start+1, path + c);
        }
    }


}

class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = clean.toCharArray();
        System.out.println(clean);
        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int lo = 0, hi = matrix.length-1;

        // binary search over the first col
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] == target) return true;
            else if (target < matrix[mid][0]) hi = mid-1;
            else if ((target > matrix[mid][0]) && (target > matrix[mid][matrix[0].length-1])) lo = mid+1;
            else { // binary search within row
                int left = 0, right = matrix[mid].length-1;
                while (left <= right) {
                    int m = left + (right - left) / 2;
                    if (matrix[mid][m] == target) return true;
                    else if (matrix[mid][m] < target) left = m+1;
                    else right = m-1;
                }

                return false;
            }
        
        }




        return false;
    }
}

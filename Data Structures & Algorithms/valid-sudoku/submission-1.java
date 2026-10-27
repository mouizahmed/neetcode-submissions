class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap();
        HashMap<Integer, Set<Character>> cols = new HashMap();
        HashMap<String, Set<Character>> squares = new HashMap();

        for (int r = 0; r < board.length; r++) {
            if (rows.get(r) == null) rows.put(r, new HashSet<>());
            for (int c = 0; c < board[0].length; c++) {
                if (cols.get(c) == null) cols.put(c, new HashSet<>());
                String squaresKey = (r / 3) + "," + (c / 3);
                if (squares.get(squaresKey) == null) squares.put(squaresKey, new HashSet<>());
                
                char value = board[r][c];
                if (value == '.') continue;

                if (rows.get(r).contains(value) || cols.get(c).contains(value) || squares.get(squaresKey).contains(value)) return false;

                rows.get(r).add(value);
                cols.get(c).add(value);
                squares.get(squaresKey).add(value);
            }
        }

        return true;  
    }
}

/*
Time: O(n^2)
Space: O(n^2)

** Can use .computeIfAbsent(key, k -> new HashSet<>()).contains(); to simplify.
** Can use Space O(n) instead if we checked if checked all rows first, then checked all columns, then checked all 3x3 boxes. Still Time O(n^2).
*/

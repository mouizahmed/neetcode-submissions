class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer,Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r,c))) return false;

        path.add(new Pair<>(r, c));
        int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (dfs(board, word, nr, nc, i+1)) return true;
        }

        path.remove(new Pair<>(r, c));
        return false;
    }
}

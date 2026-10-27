class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }

        int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir: DIRS) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {   
                        fresh--;
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                    }
            }
            }
            time++;
        }

        if (fresh == 0) return time;
        else return -1;
    }
}

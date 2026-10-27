class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> done = new HashSet<>();
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pr : prerequisites) {
            preMap.get(pr[0]).add(pr[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }

        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }

        return res;
    }

    private boolean dfs(int c) {
        if (visiting.contains(c)) return false;
        if (done.contains(c)) return true;

        visiting.add(c);
        for (int pr : preMap.get(c)) {
            if (!dfs(pr)) return false;
        }
        visiting.remove(c);
        done.add(c);
        order.add(c);
        return true;

    }
}

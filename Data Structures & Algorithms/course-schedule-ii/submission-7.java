class Solution {
    private final static int IN_PROGRESS = 1;
    private final static int DONE = 2;
    private int resIdx = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer>[] iToDeps = new Set[numCourses];

        int[] statuses = new int[numCourses];
        int[] result = new int[numCourses];
        
        
        for (int i = 0; i < numCourses; i++) {
            iToDeps[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int position = prerequisites[i][0];
            int dependency = prerequisites[i][1];
            iToDeps[position].add(dependency);
        }
        // numCourses = 3
        // prerequisites = [[1,0]]
        // -> [0,1,2]
        // iToDeps = [_,0,_]
        
        for (int i = 0; i < numCourses; i++) {
            if (statuses[i] == DONE) {
                continue;
            }
            if (dfs(iToDeps, i, statuses, result)) {
                return new int[0];
            }
        }
        return result;
    }

    public boolean dfs(Set<Integer>[] iToDeps, int nodeIndex, int[] statuses, int[] result) {
        if (statuses[nodeIndex] == IN_PROGRESS) {
            return true;
        }
        statuses[nodeIndex] = IN_PROGRESS;
        for (int i : iToDeps[nodeIndex]) {
            if (statuses[i] != DONE) {
                if (dfs(iToDeps, i, statuses, result)) {
                    return true;
                };
            }
        }
        
        result[resIdx++] = nodeIndex;
        statuses[nodeIndex] = DONE;
        return false;
    }
}

class Solution {
    private final static int IN_PROGRESS = 1;
    private final static int DONE = 2;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // 0 before 1

        //
//1. dfs from 0 till n -1
// 2. add to stack
// 3. return from stack - it's the result
// detect cycle- if already in stack - no result

// data structs: 
// 0. prereq - array of arrays, index- a, array - b
// 1. hashmap with items in stack
// 2. stack

        Set<Integer>[] iToDeps = new Set[numCourses];

        int[] statuses = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        
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
            if (dfs(iToDeps, i, statuses, stack)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int i = numCourses - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }
// iToDeps = [_,0,_]
//statuses = [ ]
        // stack = [0, 1, ]
    public boolean dfs(Set<Integer>[] iToDeps, int nodeIndex, int[] statuses, Deque<Integer> stack) {
        boolean cycleDetected = false;
        if (statuses[nodeIndex] == IN_PROGRESS) {
            return true;
        }
        statuses[nodeIndex] = IN_PROGRESS;
        for (int i : iToDeps[nodeIndex]) {
            if (statuses[i] != DONE) {
                cycleDetected = cycleDetected || dfs(iToDeps, i, statuses, stack);
            }
        }
        
        stack.push(nodeIndex);
        statuses[nodeIndex] = DONE;
        return cycleDetected;
    }
}

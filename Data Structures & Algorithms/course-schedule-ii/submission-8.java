class Solution {
    private final static int IN_PROGRESS = 1;
    private final static int DONE = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] cursor = {0};
        List<Integer>[] courseToPrereq = new List[numCourses];

        int[] statuses = new int[numCourses];
        int[] result = new int[numCourses];
        
        
        for (int i = 0; i < numCourses; i++) {
            courseToPrereq[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            courseToPrereq[course].add(prereq);
        }
 
        for (int i = 0; i < numCourses; i++) {
            if (statuses[i] == DONE) {
                continue;
            }
            if (!visit(courseToPrereq, i, statuses, result, cursor)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean visit(List<Integer>[] courseToPrereq, int nodeIndex, int[] statuses, int[] result, int[] cursor) {
        if (statuses[nodeIndex] == IN_PROGRESS) {
            return false;
        }
        statuses[nodeIndex] = IN_PROGRESS;
        for (int i : courseToPrereq[nodeIndex]) {
            if (statuses[i] != DONE) {
                if (!visit(courseToPrereq, i, statuses, result, cursor)) {
                    return false;
                };
            }
        }
        
        result[cursor[0]++] = nodeIndex;
        statuses[nodeIndex] = DONE;
        return true;
    }
}

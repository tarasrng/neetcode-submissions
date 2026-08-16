class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> survivors = new ArrayDeque<>();
        
        int i = 0;
        while (i < asteroids.length) {
            int left = !survivors.isEmpty() ? survivors.pop() : asteroids[i++];
            if (i == asteroids.length) {
                survivors.push(left);
                break;
            }
            int right = asteroids[i++];
            boolean[] collisionSurvivors = getCollisionSurvivors(left, right);
            while (collisionSurvivors[1] && !collisionSurvivors[0] && !survivors.isEmpty()) {
                left = survivors.pop();
                collisionSurvivors = getCollisionSurvivors(left, right);
            }
            if (collisionSurvivors[0]) {
                survivors.push(left);
            }
            if (collisionSurvivors[1]) {
                survivors.push(right);
            }
        }

        int[] result = new int[survivors.size()];
        for (int survivorsI = 0; survivorsI < result.length; survivorsI++) {
            result[result.length - survivorsI - 1] = survivors.pop();
        } 
        return result;
    }

    private boolean[] getCollisionSurvivors(int l, int r) {
        boolean[] survivors = new boolean[]{true, true};
        boolean isLeftPositive = l == Math.abs(l);
        boolean isRightPositive = r == Math.abs(r);

        boolean canCollide = isLeftPositive && !isRightPositive;
        boolean collision = false;
        if (canCollide) {
            if (Math.abs(r) >= Math.abs(l)) {
                survivors[0] = false;
            } 
            if (Math.abs(r) <= Math.abs(l)){
                survivors[1] = false;
            }
        }
        return survivors;
    }
}
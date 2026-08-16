class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> survivorsStack = new ArrayDeque<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (survivorsStack.isEmpty()) {
                survivorsStack.push(asteroid);
            } else {
                int survivor = survivorsStack.pop();
                boolean[] collisionSurvivors = getCollisionSurvivors(survivor, asteroid);
                while (collisionSurvivors[1] && !collisionSurvivors[0] && !survivorsStack.isEmpty()) {
                    survivor = survivorsStack.pop();
                    collisionSurvivors = getCollisionSurvivors(survivor, asteroid);
                }
                if (collisionSurvivors[0]) {
                    survivorsStack.push(survivor);
                }
                if (collisionSurvivors[1]) {
                    survivorsStack.push(asteroid);
                }
            }
        }
        
        int[] result = new int[survivorsStack.size()];
        for (int survivorsI = 0; survivorsI < result.length; survivorsI++) {
            result[result.length - survivorsI - 1] = survivorsStack.pop();
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
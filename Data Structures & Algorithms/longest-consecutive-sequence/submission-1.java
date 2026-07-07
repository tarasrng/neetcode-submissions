class Solution {
    public int longestConsecutive(int[] nums) {
        //[2,20,4,10,3,4,5]
     
        // [2:3,20:20,4:5,10:10,3:4,4:4,5:5]
        // [2:1,20:1,4:1,10:1,3:2,4:1,5:4]
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        for (int num : nums) {
            parent.put(num, num);
            size.put(num, 1);
        }

        for (int num : nums) {
            if (parent.containsKey(num + 1)) {
                union(num, num + 1, parent, size);
            }
        }
        return Collections.max(size.values());
    }

    public void union(Integer a, Integer b, Map<Integer, Integer> parent, Map<Integer, Integer> size){
        Integer parentA = find(a, parent); 
        Integer parentB = find(b, parent); 
        // handle duplicates
        if (!parentA.equals(parentB)) {
            parent.put(parentA, parentB);
            size.put(parentB, size.get(parentA) + size.get(parentB));
        }
    }

    public Integer find(Integer n, Map<Integer, Integer> parent) {
        Integer root = parent.get(n);
        while (!n.equals(root)) {
            n = root;
            root = parent.get(root);
        }
        return root;
    }
}

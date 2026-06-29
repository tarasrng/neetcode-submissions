class Solution {
    public int[] productExceptSelf(int[] nums) {
        // iterate, multiply, store total
        // iterate again, divide total by nums[i], store
        int total = 1;
        int numOfZeros = 0;
        int[] products = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                numOfZeros++;
            } else {
                total *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (numOfZeros == 0) {
                    products[i] = total / nums[i];
                } else {
                    products[i] = 0;
                }
            } else {
                if (numOfZeros == 1) {
                    products[i] = nums[i] = total;
                } else {
                    products[i] = 0;
                }
            }
        }

        return products;
    }
}  

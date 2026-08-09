class Solution {
    public boolean canJump(int[] nums) {
        int zero = -1;

        for (int i = nums.length-2; i >= 0; i--) {
            if (zero != -1) {
                if (nums[i] > zero) {
                    zero = -1;
                } else {
                    zero++;
                }
            }

            if (zero == -1 && nums[i] == 0) {
                zero = 1;
            }
        }

        if (zero == -1) return true;
        return false;
    }
}
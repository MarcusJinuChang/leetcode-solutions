class Solution {
    public int majorityElement(int[] nums) {
        int n = nums[0];
        int c = 1;

        for (int i = 1; i < nums.length; i++) {
            c += nums[i] == n ? 1 : -1;
            if (c == 0){ 
                n = nums[i];
                c++;
            }
        }

        return n;
    }
}
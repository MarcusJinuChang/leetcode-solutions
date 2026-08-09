class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int pm = 1;
        int sm = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = pm;
            pm *= nums[i];
        }

        for (int i = nums.length-1; i >= 0; i--) {
            answer[i] *= sm;
            sm *= nums[i];
        }

        return answer;
        
    }
}
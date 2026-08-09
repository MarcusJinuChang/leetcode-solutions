class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> varr = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                varr.add(i);
                cnt++;
            }

            if (!varr.isEmpty() && nums[i] != val) {
                nums[varr.get(0)] = nums[i];
                varr.remove(0);
                nums[i] = val;
                varr.add(i);
            }
        }

        return nums.length-cnt;
    }
}
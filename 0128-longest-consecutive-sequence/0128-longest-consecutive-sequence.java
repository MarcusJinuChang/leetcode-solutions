class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int prev = set.first();
        int mcnt = 1;
        int cnt = 1;

        for (int n: set) {
            if (n - prev == 1) {
                cnt++;
            } else {
                mcnt = Math.max(mcnt, cnt);
                cnt = 1;
            }

            prev = n;
        }

        mcnt = Math.max(mcnt, cnt);
        return mcnt;
    }
}
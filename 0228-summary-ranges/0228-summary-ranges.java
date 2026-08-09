class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;

        int prev = nums[0];
        int st = nums[0];
        int fn = nums[0];
        int cur;

        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];

            if (cur - prev == 1) {
                fn++;
            } else {
                if (st != fn) 
                    ans.add(st + "->" + fn);
                else 
                    ans.add(st + "");

                st = cur;
                fn = cur;
            }

            prev = cur;
        }

        if (st != fn) 
                    ans.add(st + "->" + fn);
                else 
                    ans.add(st + "");

        return ans;
    }
}
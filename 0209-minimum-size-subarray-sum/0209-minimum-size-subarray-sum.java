class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        boolean sliding = false;
        int size = 0;
        int sum = 0;
        int first = 0;
        int last = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            sum += val;
            last = i;

            if (sliding) {
                sum -= nums[first];
                first++;

                if (sum - nums[first] >= target) {
                    do {
                        sum -= nums[first];
                        size--;
                        first++;
                    } while (sum - nums[first] >= target && first < last);
                }

                continue;
            }

            size = i+1;

            if (sum < target) {
                continue;
            }
            
            sliding = true;
            
            if (i == nums.length - 1) {
                if (sum - nums[first] >= target) {
                    do {
                        sum -= nums[first];
                        size--;
                        first++;
                    } while (sum - nums[first] >= target && first < last);
                }
            }
        }

        if (!sliding) return 0;
        return size;
    }
}
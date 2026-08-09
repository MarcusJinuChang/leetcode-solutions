class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (map.containsKey(cur) && Math.abs(i - map.get(cur)) <= k)
                return true;

            map.put(cur, i);
        }

        return false;
    }
}
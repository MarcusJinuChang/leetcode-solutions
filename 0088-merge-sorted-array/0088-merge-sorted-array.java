class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < m; i++) {
            int in = nums1[i];
            if (!map.keySet().contains(in)) {
                map.put(in, 1);
            } else {
                map.put(in, map.get(in) + 1);
            }
        }

        for (int in: nums2) {
            if (!map.keySet().contains(in)) {
                map.put(in, 1);
            } else {
                map.put(in, map.get(in) + 1);
            }
        }

        ArrayList<Integer> ar = new ArrayList<>();

        for (int in: map.keySet()) {
            for (int i = 0; i < map.get(in); i++) {
                ar.add(in);
            }
        }

        for (int i = 0; i < ar.size(); i++) {
            nums1[i] = ar.get(i);
        }
    }
}
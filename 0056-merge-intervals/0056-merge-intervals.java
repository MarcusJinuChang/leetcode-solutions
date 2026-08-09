class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        // System.out.println(Arrays.deepToString(intervals));

        ArrayList<int[]> ar = new ArrayList<>();
        int[] a = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] b = intervals[i];

            if (a[1] >= b[0]) {
                a[1] = Math.max(a[1], b[1]);
            } else {
                ar.add(a);
                a = b;
            }
        } ar.add(a);





        int[][] ans = new int[ar.size()][2];

        for (int i = 0; i < ar.size(); i++) {
            ans[i] = ar.get(i);
        }

        return ans;
    }
}
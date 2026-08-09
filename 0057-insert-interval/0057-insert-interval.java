class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ar = new ArrayList<>();
        boolean placed = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                // no overlap yet, current interval ends before newInterval starts
                ar.add(intervals[i]);

            } else if (intervals[i][0] > newInterval[1]) {
                // no more overlap possible, insert newInterval before this one (once)
                if (!placed) {
                    ar.add(newInterval);
                    placed = true;
                }
                ar.add(intervals[i]);

            } else {
                // overlap starts here — use inner loop to absorb everything it touches
                int start = Math.min(intervals[i][0], newInterval[0]);
                int end = Math.max(intervals[i][1], newInterval[1]);

                int j = i + 1;
                for (; j < intervals.length && intervals[j][0] <= end; j++) {
                    end = Math.max(end, intervals[j][1]);
                }

                ar.add(new int[]{start, end});
                placed = true;
                i = j - 1; // outer loop's i++ will land exactly on j
            }
        }

        if (!placed) {
            ar.add(newInterval);
        }

        int[][] ans = new int[ar.size()][2];
        for (int k = 0; k < ar.size(); k++) {
            ans[k] = ar.get(k);
        }
        return ans;
    }
}
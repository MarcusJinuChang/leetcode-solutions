class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int cnt = points.length;

        int[] look = points[0];
        int i = 1;

        while (i < points.length) {
            if (look[1] >= points[i][0]) {
                cnt--;
                look[1] = Math.min(look[1], points[i][1]); // shrink to the overlap
            } else {
                look = points[i];
            }
            i++;
        }

        return cnt;
    }
}
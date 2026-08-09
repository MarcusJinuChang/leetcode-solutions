class Solution {
    public boolean isHappy(int n) {
        while (n != 1) {
            // System.out.println(n);
            n = happify(n);
            if (n == 4) return false;
        }

        return true;
    }

    int happify(int n) {
        int next = 0;

        while (n != 0) {
            next += (n%10) * (n%10);
            n/=10;
        }

        return next;
    }
}
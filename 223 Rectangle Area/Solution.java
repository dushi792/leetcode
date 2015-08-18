public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (H-F)*(G-E);
        // calculate overlap
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int buttom = Math.max(B,F);
        int overlap = 0;
        if (left<right && top > buttom)
            overlap = (right-left) * (top-buttom);

        return area1+area2-overlap;
    }
}

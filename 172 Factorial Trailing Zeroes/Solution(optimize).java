public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] tb = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        
        int result = 0;
        int curr = 0;
        int msk = 0xF;
        for(int i = 0; i < 8; i++) {
            result = result << 4;
            curr = msk&n;
            result |= tb[curr];
            n = n >> 4;
        }
        return result;
    }
}
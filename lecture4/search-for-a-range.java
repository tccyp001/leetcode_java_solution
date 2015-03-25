public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = lowbound(A,target);
        ret[1] = upbound(A,target);
        return ret;
    }
    public int upbound(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int lastFoundIndex = -1;
        while(start<end) {
            int mid = (start+end)/2;
            if(A[mid]==target) lastFoundIndex = mid;
            if(A[mid]>target) end = mid;
            else start = mid +1;
        }
        return lastFoundIndex;
    }
    public int lowbound(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int lastFoundIndex = -1;
        while(start<end) {
            int mid = (start+end)/2;
            if(A[mid]==target) lastFoundIndex = mid;
            if(A[mid]>=target) end = mid;
            else start = mid +1;
        }
        return lastFoundIndex;
    }
}
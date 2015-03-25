public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length;
        while(start<end) {
            int mid = (start + end )/2;
            if(A[mid] ==target) return mid;
            if(A[mid]<target) start = mid +1;
            else end = mid;
        }
        return start;
    }
}
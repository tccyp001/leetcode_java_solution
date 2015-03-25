public class Solution {
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int mid = 0;
        while(start<end) {
            mid = start + (end - start)/2;
            if(A[mid] == target) return true;
            if(A[start] == A[mid]){
                 start++;
            } 
            else if(A[start] < A[mid]) {
                if (A[mid] > target && A[start]<=target) end = mid;
                else start = mid +1;
            }
            else {
                if(A[mid] < target && A[end-1]>=target) start = mid +1;
                else end = mid;
            }
        }
        return false;
    }
}
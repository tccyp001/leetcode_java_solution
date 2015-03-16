public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
        int first = 1, second = 0;
        while(first<A.length) {
            if(A[first]==A[second])first++;
            else A[++second] = A[first++];
        }
        return second+1;
    }
}
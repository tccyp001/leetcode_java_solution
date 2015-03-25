public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0;i<A.length;i++) {
            if(A[i] != i+1 && A[i]>0 && A[i] <=A.length ) {
                if(A[A[i]-1] == A[i]) continue;
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
                i--;
            }
        }
		for(int i =0;i<A.length;i++) {
			if(A[i]!=(i+1))return i+1;
		}
		return A.length+1;
        
    }
}
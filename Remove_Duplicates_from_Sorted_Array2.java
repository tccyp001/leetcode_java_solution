/* //Solution 1
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=2) return A.length;
        int first = 1, second = 0;
        int cnt=0;
        while(first<A.length) {
            if(A[first]!=A[second]) {
                A[++second] = A[first++];
                cnt = 0;
            }
            else if(cnt<1) {
                A[++second] = A[first++];
                cnt++;
            }
            else first++;
        }
        return second+1;
    }
}
*/

//Solution2
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <1)return 0;
        int count = 0;
        int j =1 ;
        for(int i = 1;i<A.length;i++)
        {
            if(A[i] != A[j-1])count=0;
            else count++;
            if(count>=2)continue;
            else A[j++] = A[i];
        }
        return j;
    }
}
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combineDFS(ret, path, 0, k, n);
        return ret;
        
    }
    public void combineDFS(List<List<Integer>> ret, ArrayList<Integer> path, int start, int left, int n)
    {
        if(left==0) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start;i<n;i++) {
            path.add(i+1);
            combineDFS(ret, path, i+1, left-1, n);
            path.remove(path.size()-1);

        }
    }
}
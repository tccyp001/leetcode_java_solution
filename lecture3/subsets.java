public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetsDFS(path,ret,0,S);
        return ret;
    }
    public void subsetsDFS(ArrayList<Integer> path, 
                ArrayList<ArrayList<Integer>> ret, int start, int[] S) {
        ret.add(new ArrayList<Integer>(path));
        
        for(int i = start;i<S.length;i++) {
            path.add(S[i]);
            subsetsDFS(path,ret,i+1,S);
            path.remove(path.size()-1);
        }
    }
}
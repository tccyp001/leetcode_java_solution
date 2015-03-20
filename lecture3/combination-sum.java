public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combSumSub(path, ret, candidates, 0, target);
        return ret;
    }
    public void combSumSub(List<Integer> path, List<List<Integer>> ret,
                           int[] candidates, int index, int target) {
        
        if(0==target) ret.add(new ArrayList<Integer>(path));
        if(index>=candidates.length)return;
        if(candidates[index]>target)return;

        path.add(candidates[index]);
        combSumSub(path, ret, candidates, index, target - candidates[index]);
        path.remove(path.size()-1);
        combSumSub(path, ret, candidates, index+1, target);
                                   
    }
}

//Solution 2
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> path  = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        combinationSumSub(candidates, 0, target, path, ret);
        return ret;
    }
    public void combinationSumSub(int[] candidates, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret)
    {
        if(target == 0) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i= start;i<candidates.length;i++) {
            if(candidates[i]>target)return;
            path.add(candidates[i]);
            combinationSumSub(candidates, i, target - candidates[i], path, ret);
            path.remove(path.size()-1);
        }
    }
}
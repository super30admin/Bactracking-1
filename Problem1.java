//Accepted on LT
// Perform Dfs and backtrackinging


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l = new ArrayList<>();
        helper(candidates,target,l,0);
        return result;
        
    }
    public void helper(int[] candidates, int target,List<Integer> l,int idx){
        //base
        if(target==0){
            
            result.add(new ArrayList<>(l));
            return;
        }
        if(target<0) return;
        if(idx>=candidates.length) return;

        //not choose
        helper(candidates,target,l,idx+1);


        //choose
        l.add(candidates[idx]);
        helper(candidates,target-candidates[idx],l,idx);
        l.remove(l.size()-1);
        

    }
}
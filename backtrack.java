class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null)return result;
        helper(candidates,0,target,new ArrayList<>());
        return result;
        }
        private void helper(int[] candidates,int i,int amount,List<Integer> path){
           if(amount ==0){
            result.add(path);
            return;
        }
        if(amount<0 || i == candidates.length) return;
        List<Integer> temp = new ArrayList<>(path);
        temp.add(candidates[i]);
        helper(candidates ,i, amount-candidates[i] , temp);
        helper(candidates,i+1,amount,new ArrayList<>(path));
    }
}
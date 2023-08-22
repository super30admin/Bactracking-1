class Problem39 {
// TC : O(2^(m+n))
// SC : O(m+n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList=new ArrayList<>();
        helper(candidates,finalList,new ArrayList<Integer>(),target,0);
        return finalList;
        
    }
    private void helper(int[] candidates,List<List<Integer>> finalList,List<Integer> subList, int target, int pivot){
        //base case
        if(target<0)
            return;
        if(target==0){
            finalList.add(new ArrayList<>(subList));
            return;
        }
        
        //actual logic
        for(int i=pivot;i<candidates.length;i++){
            subList.add(candidates[i]);
            helper(candidates,finalList,subList,target-candidates[i],i);
            subList.remove(subList.size()-1);
        }
    }
}

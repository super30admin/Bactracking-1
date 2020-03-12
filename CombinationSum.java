class Solution {
    
    //TimeComplexity: O(n*2^n) - n - no of elements in the candidates and 
    //SpaceComplexity: O(n^2)
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    List<Integer> stack = new LinkedList<>();
    dfs(result, candidates, target, 0,0, stack); 
        return result;
    }
    
    public void dfs(List<List<Integer>> result, int[] candidates, int target, int index, int sum, List<Integer> stack) {
        
        if(sum > target)return;
        
        if(sum == target)result.add(new LinkedList<>(stack));
        
        for(int i =index;i< candidates.length;i++){
            stack.add(candidates[i]);
            dfs(result, candidates, target, i,sum + candidates[i], stack); 
            stack.remove(stack.size()-1);
        }
        
        
        
       
    }
    
   
}

class CombinationSum {
    // Aproach 1 - Backtracking
    // Time complexity O(2^n)
    // Space complexity O(n) by recursion stack
    // Tested in leetcode
    
    // Driver function calls helper function to recurse and get all combination sum of candidates 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result,new ArrayList<>(),candidates,target,0,0);
        return result;
    } 
    
    // This function stores the combinations of input array if the sum of components is equal to target.
    public void helper(List<List<Integer>> result, ArrayList<Integer> temp,int[] candidates, int target,int sum, int index){
        // when sum is equal to target store the array combination into the output list.
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        // stop recursion when sum is greater than target
        if(sum > target){
            return;
        }
        // loop through all element of the input array, add the current element into the temp list and add to the temp sum.
        // recurse again untill satisfies the condition.
        for(int i=index; i<candidates.length; i++){
            temp.add(candidates[i]);
            sum += candidates[i];
            // call itself
            helper(result,temp,candidates,target,sum,i);
            for(int t : temp)
                System.out.print(t + " ");
            System.out.println();
            // undo the current move
            sum -= temp.get(temp.size()-1);
            temp.remove(temp.size()-1);
        }
        
    }
}
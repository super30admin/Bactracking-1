//Time complexity: O(n^(target/min(candidates))+1)
//Space complexity: O(target/min(candidates)+1)
//Executed on leetcode.
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {        
        List<Integer> list = new ArrayList<Integer>();
        backtracking(candidates, 0, target, list);
        return output;
    }
    
    private void backtracking(int[] candidates, int index, int target, List<Integer> list)
    {
        if(target<0)
            return;
        else if(target==0)
        {
            output.add(new ArrayList<>(list));      //Using recurrsion calling each possible combination of N array tree.
            return;
        }
        
        for(int i=index;i<candidates.length;i++)    //when summation adds up to target add to the list of values to output list.
        {
            list.add(candidates[i]);        
            
            backtracking(candidates, i, target-candidates[i], list);
            
            list.remove(list.size()-1); 
        }
                   
    }
}
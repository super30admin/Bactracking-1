// Time Complexity - Exponential (n^n) where n is the number of elements in the candidates array
// Space Complexity - O(1)
// This solution worked on LeetCode


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates  == null || candidates.length == 0){
            return result;
        }
        backtrack(candidates,0, target,0, new ArrayList<>());
        return result;
    }
 
    private void backtrack(int[] candidates,int index,int target,int sum,List<Integer> temp){
         // Base Case
        if(sum == target){                  // if sum = target that means the target is achieved using the list
            result.add(new ArrayList<>(temp));      // Add the list to the result
            return;     
        }
        if(sum > target) return;                // if sum > target that means the last element in the list exceeded the sum hence needs to be backtracked
        // Logic
        for(int i=index;i < candidates.length;i++){           
            temp.add(candidates[i]);
            backtrack(candidates, i, target, sum + candidates[i], temp);      // Since same element can be repeated so i and not i+1
            temp.remove(temp.size() -1 );       // Backtrack
        }
    }
}

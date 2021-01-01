/*
# normal recursive solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates is None or len(candidates) == 0:
            return []
        
        self.result = []
        self.helper(candidates, 0, 0, [], target)
        
        return self.result
    
    def helper(self, candidates, index, total, temp, target):
        if index >= len(candidates) or total > target:
            return
        
        if total == target:
            self.result.append(temp)
            return
        
        self.helper(candidates, index+1, total, []+temp, target)
        temp.append(candidates[index])
       
        self.helper(candidates, index, total+candidates[index], []+temp, target)


# backtracking - its helpful as it reduces the space complexity as we are not creating new list at every recursive call and we also save
# on TC as copying elements from old to new list takes some time        
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates is None or len(candidates) == 0:
            return []
        
        self.result = []
        self.helper(candidates, 0, 0, [], target)
        
        return self.result
    
    def helper(self, candidates, index, total, temp, target):
        if index >= len(candidates) or total > target:
            return
        
        if total == target:
            self.result.append([]+temp)
            return
        
        self.helper(candidates, index+1, total, temp, target)
        temp.append(candidates[index])
        self.helper(candidates, index, total+candidates[index], temp, target)
        temp.pop()

*/

/*
// normal recursive sol
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, int sum, List<Integer> temp, int target){
        if (index >= candidates.length || sum > target)
            return;
        
        if (sum == target){
            result.add(temp);
            return;
        }
        
        // dont choose
        helper(candidates, index+1, sum, new ArrayList<>(temp), target);

        // choose
        temp.add(candidates[index]);
        helper(candidates, index, sum+candidates[index], new ArrayList<>(temp), target);
    }
}

// backtracking with recursive approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, int sum, List<Integer> temp, int target){
        if (index >= candidates.length || sum > target)
            return;
        
        if (sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // dont choose
        helper(candidates, index+1, sum, temp, target);

        // choose
        temp.add(candidates[index]);
        helper(candidates, index, sum+candidates[index], temp, target);
        //backtrack
        temp.remove(temp.size()-1);
    }
}
*/

// Time Complexity : O(n^m) where n is length of array and m is target
// Space Complexity : O(n+m) as there is only single list maintained so n and m is max stack size as we are given input will start from 1
//                    if input had negative numbers then it might be different. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: The iterative for loop considers all the possible combinations and then
// moves ahead and repeats the same


// backtracking with iterative approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, int sum, List<Integer> temp, int target){
        if (sum > target)
            return;
        
        if (sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=index; i<candidates.length; i++){
            temp.add(candidates[i]);
            helper(candidates, i, sum+candidates[i], temp, target);
            temp.remove(temp.size()-1);
        }
        
    }
}
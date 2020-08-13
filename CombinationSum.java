/**
Problem: Combination Sum
Did it run on LeetCode: Yes

Time Complexity: O(2 ^ n), where n is the size of the candidates array
Space Complexity: O(n), where n is the size of the candidates array

Approach 1: Recursion
1. At every point, we have only 2 choices. Either choose the element, or don't choose.
2. If the element is chosen, we add it to the current sum, and add it to the temp list.
3. If the element is not chosen, we proceed with other elements
4. Whenever the current sum matches the target, we append that list to the result list.

Approach 2: Backtracking
1. In backtracking, we follow the same methodology like recursion, but the appoach is slightly different.
2. We use  a 3-pronged approach. First, we perform an action, then we recurse, and if the condition is not met, we then backtrack(i.e, removing the previously performed action)
3. Backtracking is basically optimizing the space.
*/

//Recursion
class Solution {
    List<List<Integer>> result;
    int globalTarget;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        globalTarget = target;
        traverse(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    public void traverse(int[] candidates, List<Integer> temp, int sum, int i) {
        if(sum > globalTarget || i >= candidates.length) {
            return;
        }
        if(sum == globalTarget) {
            result.add(temp);
            return;
        }
        //don't choose that number
        traverse(candidates, new ArrayList<>(temp), sum, i+1);
        temp.add(candidates[i]);
        traverse(candidates, new ArrayList<>(temp), sum + candidates[i], i);
        
    }
}

//BackTracking
class Solution {
    List<List<Integer>> result;
    int globalTarget;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        globalTarget = target;
        backTrackTraverse(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    public void backTrackTraverse(int[] candidates, List<Integer> temp, int sum, int index) {
        if(sum > globalTarget || index >= candidates.length) {
            return;
        }
        if(sum == globalTarget) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            //Action
            temp.add(candidates[i]);
            //Recurse
            backTrackTraverse(candidates, temp, sum + candidates[i], i);
            //backtrack
            temp.remove(temp.size() - 1); //removing the element at the last 
        }
        
    }
}
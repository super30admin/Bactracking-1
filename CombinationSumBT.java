// Time Complexity: Exponential time complexity
// Space Complexity: recursive stack has O(n) space complexity
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to iterate through the array and recurse on each element until
// break condition is met. We perform action of adding element to path,
// recurse to same element, if break condition is success, we add path to result
// else backtracking is performed and further index element is added
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
        
    public void helper(int[] candidates, int target, int index, List<Integer> path) {
        if(target<0) return;
        if(target==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
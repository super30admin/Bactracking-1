// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


List<IList<int>> result;
public IList<IList<int>> CombinationSum(int[] candidates, int target) {
    result = new List<IList<int>>();
    if(candidates == null || candidates.Count() == 0)
        return result;
    
    helper(candidates, target, 0, new List<int>());
    
    return result;
}

//this is for loop based recursion
private void helper(int[] candidates, int target, int index, List<int> path)
{
    //base
    if(target == 0)
    {
        //we have to create new list before addign to list in case of backtracking
        result.Add(new List<int>(path));
        return;
    }
    
    if(target < 0)
        return;
    
    //logic            
    for(int i = index; i < candidates.Count(); i++)
    {
    //there is another way of doing above code using backtracking, so that it dont creates new new list everytime
    path.Add(candidates[i]);
    //index is i below to recursion call because we can pick same element again
    helper(candidates, target - candidates[i], i, path);
    path.RemoveAt(path.Count - 1);
}



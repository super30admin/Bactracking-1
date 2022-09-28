// Time Complexity: O(N(T/M) + 1) N = number of candidate, T = target value, M = minimum value among the candidates
// Space Complexity: O(T/M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        if(candidates == null)
        {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        searchCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    
    public void searchCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = index; i < candidates.length; i++)
        {
            if(candidates[i] <= target)
            {
                current.add(candidates[i]);
                searchCombinations(candidates, i, target - candidates[i], current, result);
                current.remove(new Integer(candidates[i]));
            }
            
        }
    }
}

// Time Complexity: O(n(4n))
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, it was very hard. Understanding the algorithm and implementing it

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) 
    {
        result = new ArrayList<>();
        helper(num,0,0,0,new StringBuilder(),target);
            return result;
    }
    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target) {
        
        if(pivot == num.length()) {
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }
        
        for(int i = pivot; i < num.length(); i++)
        {
            if(num.charAt(pivot) == '0' && i != pivot)
            {
                continue;
                
            } 
            
            long current = Long.parseLong(num.substring(pivot, i+1));
            int le = path.length();
            
            if(pivot == 0)
            {
                //action
                path.append(current);
                
                //recursion
                helper(num, i+1, current, current, path, target);
                
                //backtracking
                path.setLength(le);
            }
            else
            {
                path.append('+');  
                path.append(current);
                
                //recursion
                helper(num, i+1, calc +current, +current, path, target);
                
                //backtracking
                path.setLength(le);
                
                
                path.append('-');     
                path.append(current);
                
                //recursion
                helper(num, i+1, calc -current, -current, path, target);
                
                //backtracking
                path.setLength(le);
                
                
                path.append('*');
                path.append(current);
                
                //recursion
                helper(num, i+1, calc -tail +tail*current, tail*current, path, target);
                
                //backtracking
                path.setLength(le);
            }
        }
    }
}
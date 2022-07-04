/*
This approach attempts to solve the sum with the for loop based recursion. At each point, we partition the string into substrings,
and add the operators between them to check if the target is being reached.

Did this code run on leetcode: No

Problems with this code: It is endlessly permutating for some reason, and gives the wrong answer
*/
class Solution {
    int sign;
    List<String> result;
    //Time Complexity = O(n*2^n)
    //Space Complexity = O(n)
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        
        //Sign variable is maintained because target sign will affect how we evaluate the target at each step
        if(target > 0)
            sign = 1;
        else if(target < 0)
            sign = 0;
        
        
        helper(num, target, 0, new StringBuilder());
        
        return result;
        
    }
    
    private void helper(String num, int target, int index, StringBuilder path)
    {
        if(target == 0)
        {   
            //Since we add an operator character along with the number, we have to remove it before we add the target string to result
            path.delete(path.length() - 1,path.length());
            result.add(path.toString());
            return;
        }
        //For positive target the bound would be less than 0 i.e negative
        if(target < 0 && sign == 1)
            return;
        //For negative target the bound would be more than 0 i.e positive
        if(target > 0 && sign == 0)
            return;
        
        for(int i = index; i < num.length(); i++)
        {   
            String subString = num.substring(index, i+1);
            int curr = Integer.parseInt(subString);
            
            path.append(subString);
           
            helper(num, target - curr, i + 1, path.append('+'));
            helper(num, target + curr, i + 1, path.append('-'));
            helper(num, target / curr, i + 1, path.append('*'));
            
           //Backtracking
            path.delete(path.length() - 1,path.length());
            path.delete(path.length() - 1,path.length());
            
            
        }
    }
}
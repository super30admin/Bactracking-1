// Time Complexity : O(4^n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// using recursion with for loop
//1.for each element in StringValue call make recursion call for very given operator until reaches at end and meet result = target



class Solution {
    List<String> result;// = new ArrayList<>();
    int targetSum;
    public List<String> addOperators(String num, int target) {
        targetSum = target;
        result = new ArrayList<>();
        dfs( num ,  0,0,0,"" );
        return result;
    }
    private void dfs(String num , int pivot,  long calc ,  long tail , String path )
    {
        if(pivot == num.length())
        { 
            if(calc == targetSum)
            {
                result.add(path);
            }

            return;
        }
    
        for(int i = pivot; i < num.length(); i++)
        {   //str = new StringBuilder();
         
         if(i != pivot && num.charAt(pivot) =='0') continue;
         
           long curr =  Long.parseLong(num.substring(pivot,i+1));
            
            if(pivot == 0)
            dfs(num, i+1, curr, curr, path + curr);
            else
            {
                dfs(num, i+1, calc + curr, curr, path + "+" + curr);
                dfs(num, i+1, calc - curr, -curr,  path + "-" + curr);
                dfs(num,i+1,calc - tail + tail * curr,tail * curr , path + "*" + curr);
            }
        }
    }
}
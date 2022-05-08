// Time Complexity : O(N!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    //backtracking
    IList<string> result;
    public IList<string> AddOperators(string num, int target) {
        result = new List<string>();
        if(num == null || num.Length == 0)
            return result;
        
        backtracking(num, target, 0, 0, 0, "");

        return result;
    } 
    private void backtracking(string num, int target, StringBuilder sb, long calc, long tail, int index)
    {
        //base
        if(index == num.Length)
        {
            if(target == calc)
            {
                result.Add(sb.ToString());
            }
            return;
        }               
            
        //logic
        for(int i = index; i < num.Length; i++)
        {            
            //this line is to avoid scenarios, where first element is 0 and we are appending non zero elemen to it
            //05, 0 is index and i is at 5, when we convert to log, it becomes 5, which is wrong
            //so wwe avoid sitation , where num index is 0 and i is not at index
            if(index != i && num[index] == '0') continue;
            int len = sb.Length;
            long curr = (long)Convert.ToDouble(num.Substring(index, i+1-index));            
            if(index == 0)
            {
                sb.Append(curr);
                backtracking(num, target, sb, curr, curr, i+1);
                sb.Length = len;
            }
            else
            {
                //+ case
                //action
                sb.Append("+");
                sb.Append(curr);
                //recurse
                backtracking(num, target, sb, calc + curr, curr, i+1);
                //backtrack
                sb.Length = len;
                
                //- case
                //action
                sb.Append("-");
                sb.Append(curr);
                //recurse
                backtracking(num, target, sb, calc - curr, -curr, i+1);
                //backtrack
                sb.Length = len;
                
                //* case
                //action
                sb.Append("*");
                sb.Append(curr);
                //recurse
                backtracking(num, target, sb, (calc - tail) + (tail * curr), tail * curr, i+1);
                //backtrack
                sb.Length = len;
            }
        }
        
    }
    

    //recursion only
    public IList<string> AddOperators(string num, int target) {
        result = new List<string>();
        if(num == null || num.Length == 0)
            return result;
        
        helper(num, target, 0, 0, 0, "");
        backtracking(num, target, 0, 0, 0, "");

        return result;
        
    } 
    private void helper(string num, int target, long calc, long tail, int index, string path)
    {
        //base
        if(index == num.Length)
        {
            if(target == calc)
            {
                result.Add(path);
            }
            return;
        }               
            
        //logic
        for(int i = index; i < num.Length; i++)
        {            
            //this line is to avoid scenarios, where first element is 0 and we are appending non zero elemen to it
            //05, 0 is index and i is at 5, when we convert to log, it becomes 5, which is wrong
            //so wwe avoid sitation , where num index is 0 and i is not at index
            if(index != i && num[index] == '0') continue;
            long curr = (long)Convert.ToDouble(num.Substring(index, i+1-index));            
            if(index == 0)
            {
                helper(num, target, curr, curr, i+1, path+curr);
            }
            else
            {
                //+ case
                helper(num, target, calc + curr, curr, i+1, path + "+" + curr);
                //- case
                helper(num, target, calc - curr, -curr, i+1, path + "-" + curr);
                //* case
                helper(num, target, (calc - tail) + (tail * curr), tail * curr, i+1, path + "*" + curr);
            }
        }
        
    }
    
    private void backtracking(string num, int target, long calc, long tail, int index, string path)
    {
        //base
        if(index == num.Length)
        {
            if(target == calc)
            {
                result.Add(path);
            }
            return;
        }               
            
        //logic
        for(int i = index; i < num.Length; i++)
        {            
            //this line is to avoid scenarios, where first element is 0 and we are appending non zero elemen to it
            //05, 0 is index and i is at 5, when we convert to log, it becomes 5, which is wrong
            //so wwe avoid sitation , where num index is 0 and i is not at index
            if(index != i && num[index] == '0') continue;
            long curr = (long)Convert.ToDouble(num.Substring(index, i+1-index));            
            if(index == 0)
            {
                helper(num, target, curr, curr, i+1, path+curr);
            }
            else
            {
                //+ case
                helper(num, target, calc + curr, curr, i+1, path + "+" + curr);
                //- case
                helper(num, target, calc - curr, -curr, i+1, path + "-" + curr);
                //* case
                helper(num, target, (calc - tail) + (tail * curr), tail * curr, i+1, path + "*" + curr);
            }
        }
        
    }
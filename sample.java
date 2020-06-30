// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    List<List<Integer>> result; // global result
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        //edge case
       if(candidates == null || candidates.length==0)
           return result; 
        
        backtrack(candidates, new ArrayList<>(), 0,0, target); //calling function on the given array, using a temp list, sum and index to track the candidates array
        return result;
    }
    
    private void backtrack(int[] candidates,List<Integer> temp, int sum, int index, int target)
    {
        //base
        if(sum>target) // if sum exceeds target , return
            return;
        if(sum==target) // if sum found equal to target
        {
            result.add(new ArrayList<>(temp)); // add the copy of temp till the point to result
            return;
        }
        
        //logic
        for(int i = index; i<candidates.length; i++) // iterating through candidates array
        {
            //action
            temp.add(candidates[i]); // adding the value of candidate to temp
            //recurse
            backtrack(candidates, temp, sum + candidates[i], i, target); //calling recursive func with increasing sum, new temp and on index as i
            //backtrack
            temp.remove(temp.size()-1); //return back to one step back when base case hits, to traverse other possible paths
        }
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(2^n *n) as a new list created at each point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    List<List<Integer>> result; //global result list
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        //edge case
       if(candidates == null || candidates.length==0)
           return result;
        
        helper(candidates, new ArrayList<>(), 0,0, target); //calling function on the given array, using a temp list, sum and index to track the candidates array
        return result;
    }
    
    private void helper(int[] candidates,List<Integer> temp, int sum, int index, int target)
    {
        //base
       if(sum>target || index>=candidates.length)  // if sum exceeds target or index crosses the cnadidates array length, return
           return;
        if(sum == target) // if sum found equal to target
        {
             result.add(temp); // add the temp for the call to result
             return;
        }
           
        
        //logic
        
        //don't choose
        helper(candidates, new ArrayList<>(temp), sum,index+1, target); // if not choose sum remains same, index increased and a new copy of temp passed so that we may not loose the current state
        
        //choose
        temp.add(candidates[index]); //add the choosed value to temp
         helper(candidates, new ArrayList<>(temp), sum+candidates[index],index, target); // if not choose sum increased by choosed value, index remain same as can choose again and a new copy of temp passed so that we may not loose the current state
    }
}


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
       if(candidates == null || candidates.length==0)
           return result;
        
        helper(candidates, new ArrayList<>(), 0,0, target);
        return result;
    }
    
    private void helper(int[] candidates,List<Integer> temp, int sum, int index, int target)
    {
        //base
       if(sum>target || index>=candidates.length)
           return;
        if(sum == target)
        {
             result.add(temp);
             return;
        }
           
        
        //logic
        //choose
        List<Integer> newList = new ArrayList<>(temp);
        newList.add(candidates[index]);
         helper(candidates, newList, sum+candidates[index],index, target);
        
         //don't choose
        helper(candidates, new ArrayList<>(temp), sum,index+1, target);
        
    }
}

// Time Complexity : O(4^n)
// Space Complexity : O(4^n *n) as a new string created at each point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    List<String> result;  //global result
    int targ; //global target
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        
        //edge case
        if(num==null || num.length() == 0)
            return result;
        
        helper(num,"",0,0,0); //calling helper for null path, 0 as curr, 0 as tail and 0 index
        return result;
    }
    
    private void helper(String num, String path, long calc, long tail, int index)
    {
        //base
        if(index == num.length()) // if index reaches the end
        {
          if(targ==calc) // and value found
                result.add(path); //add path to result
          return; 
        }
            
        
        //logic
      for(int i=index;i<num.length();i++)
        {
            //preceding zeros
         if(num.charAt(index) == '0' && index!=i) break;  //to check if preceding zero are there and the it lies before another value 
            long curr = Long.parseLong(num.substring(index, i+1)); //getting the substring value
            if(index==0)
                helper(num,path+curr,curr,curr,i+1); //calling helper for index 0 when tail and calc both are curr
            else
            {
                //+
                helper(num, path+"+"+curr, calc+curr, curr, i+1);  //calling helper for for + , tail will be the mess made that is curr that was added
                
                 //-
                helper(num, path+"-"+curr, calc-curr, -curr, i+1); //calling helper for for + , tail will be the mess made that is -curr that was subtracted
                
                 //*
                 helper(num, path+"*"+curr ,calc-tail+tail*curr, tail*curr, i+1); //calling helper for for * , calculated is calculated by nullifying the prev action using tail and then using tail to operate on current, tail becomes the new action done i.e operating tail on current
            }
        }
        
    }
}

// Time Complexity : O(4^n)
// Space Complexity : O(n) as a one string used throughout
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        
        //edge case
        if(num==null || num.length() == 0)
            return result;
        
        helper(num,new StringBuilder(),0,0,0);
        return result;
    }
    
    private void helper(String num, StringBuilder sb, long calc, long tail, int index)
    {
        //base
        if(index == num.length())
        {
          if(targ==calc)
                result.add(sb.toString());
          return;  
        }
            
        
        //logic
      for(int i=index;i<num.length();i++)
        {
            //preceding zeros
         if(num.charAt(index) == '0' && index!=i) break;
            long curr = Long.parseLong(num.substring(index, i+1));
          int len = sb.toString().length();
            if(index==0)
            {
                sb.append(curr); //action
                 helper(num,sb,curr,curr,i+1); //recurse
                sb.setLength(len); //backtrack
            } 
            else
            {
                //+
                sb.append("+");
                sb.append(curr);
                helper(num, sb, calc+curr, curr, i+1);
                sb.setLength(len);
                
                 //-
                sb.append("-");
                sb.append(curr);
                helper(num, sb, calc-curr, -curr, i+1);
                sb.setLength(len);
                
                 //*
                sb.append("*");
                sb.append(curr);
                helper(num, sb ,calc-tail+tail*curr, tail*curr, i+1);
                sb.setLength(len);
            }
        }
        
    }
}
// Time Complexity :l*(4^l)
// Space Complexity : O(l) - length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * This is the 0 - 1 recursion without backtracking in which String data structure is used instead of SB.
 * A new copy of the String is being created at every node.
 */

import java.util.ArrayList;

public class Operations&Exp {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        if(num.length() == 0)
        {
            return result;
        }
        
        helper(num,target,0,0,0,"");
        return result;
    }
    
    private void helper(String num, int target, int index, long calc, long tail, String path)
    {
        //base
        if(index == num.length())
        {
            if(calc == target)
            {
                result.add(path);
                return;
            }
        }
        //logic
        for(int i = index; i < num.length();i++)
        {
            long curr = Long.parseLong(num.substring(index,i + 1));
            if(i != index && num.charAt(index) == '0')
            {
                continue;
            }
            if(index == 0)
            {
                helper(num, target,i + 1, curr,curr,path + curr);
            }
            
            else
            {
                //+
                helper(num,target,i + 1, calc + curr, curr,path + '+' + curr);
                //-
                helper(num,target,i + 1, calc - curr, -curr,path +'-'+ curr );
                //*
                helper(num, target,i+1,calc - tail + tail * curr,tail*curr,path + '*' + curr );
            }
        }
    }
}


/*
 * Approach 2 - Using String Builder because it consists of BackTracking
 */

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        if(num.length() == 0)
        {
            return result;
        }
        
        helper(num,target,0,0,0,new StringBuilder());
        return result;
    }
    
    private void helper(String num, int target, long calc, long tail, int index, StringBuilder path){
        //base
        if(index == num.length())
        {
            if(calc == target)
            {
                result.add(path.toString());
            }
            return;
        }
        //logic

        for(int i = index; i<num.length();i++)
        {
                    if(i != index && num.charAt(index) == '0')
        {
            continue;
        }
            long curr = Long.parseLong(num.substring(index,i + 1));
            int le = path.length();
            
            if(index == 0)
            {
                //action
                path.append(curr); 
                //recurse
                helper(num,target,curr,curr,i + 1,path);
                //backtrack
                path.setLength(le);
            }
            
            else
            {
                //+
                //action
                path.append('+');
                path.append(curr);
                
                //recurse
                helper(num,target,calc + curr, curr, i + 1,path);
                
                //backtrack
                path.setLength(le);
                
                //-
                //action
                path.append('-');
                path.append(curr);
                
                //recurse
                helper(num,target,calc - curr,-curr,i+1,path);
                
                //backtrack
                path.setLength(le);
                
                //*
                //action
                path.append('*');
                path.append(curr);
                
                //recurse
                helper(num,target,calc - tail + tail * curr, tail*curr,i + 1, path);
                
                //backtrack
                path.setLength(le);
            }
        }
    }
}
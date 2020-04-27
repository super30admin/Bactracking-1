import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(target x 2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<String> output = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num, target,"",0,0,0);
        return output;
    }
    private void helper(String num, int target, String path, long calc, long tail,int index)
    {
      //base case
        if(index == num.length())
        {
            if(calc==target)
            {
                output.add(path);
            }
        }
        //logic
        for(int i = index; i < num.length();i++)
        {
            //for handleing preceding zero
            if(index!=i && num.charAt(index)=='0') break;
            //case 0
            long curr = Long.parseLong(num.substring(index,i+1));
            //for root node
            if(index ==0)
            {
                tail=0;
                //case 1 "+"
                helper(num, target,path+curr, curr,curr,i+1);
            }
            else
            {
                //case 1 "+"
                helper(num, target,path+"+"+curr, calc+curr,curr,i+1);
                //case 2 "-"
                helper(num, target,path+"-"+curr, calc-curr,-curr,i+1);
                //case 1 "*"
                helper(num, target,path+"*"+curr, calc-tail+tail*curr,tail*curr,i+1);
                
            }
        }

        
    }
}
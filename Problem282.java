// Time Complexity : O(N* 4^N)
// Space Complexity : O(N) --> recurssion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0,0,0,new StringBuilder());

        return result;
    }
    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path)
    {
        //base case
        if(pivot == num.length() && calc == target){        
            // all elements needs to there and caluculated value is target add path to result 
            result.add(path.toString());   // make a string as we are back tracking and using String Builder
        }

        //logic

        for(int i =pivot;i<num.length();i++)
        {
            if(num.charAt(pivot)=='0' && i!= pivot) continue;   // to handle to leading zeros
            int len = path.length();
            Long curr = Long.parseLong(num.substring(pivot,i+1));  // get individal numbers from string
            if(pivot ==0){     // at first level we can't have any operators as they are the only numbers
                //action
                path.append(curr);
                
                // recurse
                helper(num, target, i+1,curr, curr, path);      // curr and tail same as they are the only numbers
                // backtrack
                path.setLength(len);
            }
            else{
                //+
                //action
                path.append("+");
                path.append(curr);
                // recurse
                helper(num, target, i+1,calc+curr, curr, path);   
                // backtrack
                path.setLength(len);
                //-
                //action
                path.append("-");
                path.append(curr);
                // recurse
                helper(num, target, i+1,calc-curr, -curr, path);
                // backtrack
                path.setLength(len);
                //*
                //action
                path.append("*");
                path.append(curr);
                // recurse
                helper(num, target, i+1, calc-tail + tail*curr ,tail*curr, path);
                // backtrack
                path.setLength(len);
            }
        }
    }
}
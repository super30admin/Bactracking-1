// Time Complexity : O(3 ^ N)
// Space Complexity : O(N * 3^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        if(num == null || num.length() == 0)    return result;
        
        helper(num, target, 0, 0, 0, new StringBuilder());
        
        return result;
    }
    //With backtracking -- We are using Stringbuilder 
public void helper(String num, int target, int index, long calc, long tail, StringBuilder path){
        
        if(index == num.length() ){ //At leaf, check that calculated value is target or not
            if(calc == target){
                result.add(path.toString());
                return;
            }
        }
        for(int i = index; i< num.length(); i++ ){
            
            if(num.charAt(index) == '0' && index != i)  continue;
            //When we are having zero at front, skip that iteration.
            long currVal = Long.parseLong(num.substring(index, i + 1)); // Make substring from index to i
            
            int currLen = path.toString().length();
            
            if(index == 0){
                //New path will be path + currVal  
                path.append(currVal);
                helper(num, target, i + 1, currVal, currVal, path);
                path.setLength(currLen); //Backtracted to current path
            }else {
                path.append("+");
                path.append(currVal);
                helper(num, target, i + 1, calc + currVal , +currVal , path );
                path.setLength(currLen); //Backtracted to current path


                path.append("-");
                path.append(currVal);
                helper(num, target, i + 1, calc - currVal , -currVal , path );
                path.setLength(currLen); //Backtracted to current path


                path.append("*");
                path.append(currVal);
                helper(num, target, i + 1, calc - tail + tail * currVal, tail * currVal, path );                               
                path.setLength(currLen); //Backtracted to current path
            }
            
        }
    }
    
}



/*

//Without Backtracking

public void helper(String num, int target, int index, long calc, long tail, String path){
        
        if(index == num.length() ){
            if(calc == target){
                result.add(path);
                return;
            }
        }
        for(int i = index; i< num.length(); i++ ){
            
            if(num.charAt(index) == '0' && index != i)  continue;
            //When we are having zero at front, skip that iteration.            
            long currVal = Long.parseLong(num.substring(index, i + 1)); // Make substring of index to i
            
            if(index == 0){
                //New path will be path + currVal  
                helper(num, target, i + 1, currVal, currVal, path + currVal);
            }else {
                helper(num, target, i + 1, calc + currVal , +currVal , path + "+" + currVal );
                helper(num, target, i + 1, calc - currVal , -currVal , path + "-" + currVal );
                helper(num, target, i + 1, calc - tail + tail * currVal, tail * currVal, path + "*" + currVal );                
            }
            
        }
    }

*/
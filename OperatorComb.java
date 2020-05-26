// Time Complexity : O(4^n) where n is the number of elements in the array and we have 4 decisions at each instance 
// Space Complexity : O(n) where n is the number of operands in the stringbuilder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 0 case is difficult to understand and "105" case is not working
/* Your code here along with comments explaining your approach:  Started with exploring all the paths from starting index. Since we can have substring of
any length at the start we have a for loop to go over. Initially, we have cal value as 1 and tail value as 1 and path as "". The reason we are maintaining
a cal value is to have the running calculation (ignoring the bodmas) but tail is helping us to rectify our mistake by keeping a track of what has been
added latest to the cal variable. Whatever the wrong calculation we are doing, we are subtracting especially and only in the case of multiplication, 
we are reducing the tail value and adding the tail * cal value to rectify our mistake and get the correct value. We are exploring all combinations 
starting from the first k operands with all the operators with the last operand. Then backtracking to the previous k-1 operands with the kth operand
having all the operators. At the end we are backtracked to try the substrings of operands (joined/concatenated) to try the operator with the operands iff any. */

// RECURSION
class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        String path = "";
        if(num == null || num.length() == 0){return result;}
        targ = target;
        helper(num, path, 0, 0, 0);                                                         // Start the recursion
        return result;
    }
    private void helper(String num, String path, long cal, long tail, int index){      
        if(index == num.length()){                                                                  // A pass is done, check if you got something
            if(cal == targ){                                                                        // Calculated value == target, add to result
                result.add(path);        
            }
          return;
        }
        for(int i = index; i < num.length(); i++){                                      // Looping over the string 
        if(index != i && num.charAt(index) == '0') break;                               // Special Case of 0, its getting ignored without this?!
        long curr = Long.parseLong(num.substring(index, i+1));                          
        if(i == 0){
            helper(num, path + curr, curr, curr, i+1);                                      // The very first value goes into the path, no calculation required here
        } else{
              helper(num,  path + "+" + curr, cal + curr, curr, i+1);                       // Explore operand with  + operator
               helper(num, path + "-" + curr, cal - curr, -curr, i+1);                      // Explore operand with - operator
               helper(num, path + "*" + curr, cal - tail + tail*curr, curr*tail, i+1);      // Explore operands with * operators and rectify your mistake
        }
        }
    }
}


// BACKTRACKING 
class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(num == null || num.length() == 0){return result;}
        targ = target;
        helper(num, path, 0, 0, 0);                                                         // Start the recursion
        return result;
    }

    private void helper(String num, StringBuilder path, long cal, long tail, int index){      
        if(index == num.length()){
            if(cal == targ){
                result.add(path.toString());        
            }
          return;
        }
        for(int i = index; i < num.length(); i++){
        if(index != i && num.charAt(index) == '0') break;                                               // Special case of 0
        int len = path.toString().length();                                                         // Capture the length to backtrack to this length (length  - 1-> previous length)
        long curr = Long.parseLong(num.substring(index, i+1));
        if(i == 0){
            path.append(curr);
            helper(num, path, curr, curr, i+1);                                                         // Adding the first operand to the path, no calculation here
            path.setLength(len);
        } else{
                path.append("+");                                                           // Explore operands with  + operator
                path.append(curr);
                helper(num,  path, cal + curr, curr, i+1);
                path.setLength(len);                                                        // Exploration done, backtrack to previous length
                
                path.append("-");                                                           // Explore operads with - operator
                path.append(curr);
                helper(num, path, cal - curr, -curr, i+1);
                path.setLength(len);                                                        // Exploration done, backtrack to previous length
            
                path.append("*");                                                           // Explore operads with * operator
                path.append(curr);
                helper(num, path, cal - tail + tail*curr, curr*tail, i+1);
                path.setLength(len);                                                        // Exploration done, backtrack to previous length
        }
        }
    }
}
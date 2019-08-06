/**
 * Time Complexity: O(3^n)
 * Space Complexity: O(1) - no extra space used
 * Idea:
 * 1. Traverse the expression tree for every combination of character and create a sub expression tree with operators.
 * 2. Check for value by having a running value and add if it meets target.
 * 3. break on reaching end of string
 * 
 * Leetcode: yes 
 */


import java.util.*;
class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        int position = 0;
        helper(result, num, target, 0,0,"",position);
        return result;
    }


    void helper(List<String> result, String num, int target, long curSum, long preSum, String path, int position){

        //base case
        if(position == num.length() && curSum == target){
            result.add(path);
            return;
        }

        if(position == num.length()){
            return;
        }

        for(int i=position;i<num.length();i++){
            String currString = num.substring(position, i+1);
            if(currString.length() > 1 && currString.charAt(0) == '0'){
                break;
            }
            // System.out.println(currString);
            Long currNum = Long.parseLong(currString);

            /**recursive calls */

            if(path.isEmpty()){
                helper(result, num, target, currNum, currNum, currString, i+1);
            }
            else {
                // add
                helper(result, num, target, curSum + currNum, currNum, path+"+"+currNum, i+1);            
                // sub
                helper(result, num, target, curSum - currNum, -currNum, path+"-"+currNum, i+1);            
                //mul
                helper(result, num, target, curSum - preSum + preSum * currNum, preSum*currNum, path+"*"+currNum, i+1);            
             }

            
        }
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Expression Add Operators");
        ExpressionAddOperators obj = new ExpressionAddOperators();
        String num = "123";
        int target = 7;
        System.out.println(obj.addOperators(num, target));
    }
}

/*
Author: Akhilesh Borgaonkar
Problem: find all unique combinations in candidates where the candidate numbers sums to target
Approach: Used backtracking approach here. Start parsing the num string and keep checking the previous calculation answer (viz. prev here) if it is equal to target. 
    If the previous calculation is equal to target then return the resultant list. Else, backtrack with other operators. To overcome missing valid '0' in the num string,
    I am checking if the current index is '0' and if it is not at 0th index which means it is significant 0. Also, to consider the multiplication priority before previous
    operator calculation, I am maintaining a previous calculated value and previous index digit to subtract from the current value before multiplying to next value.
Time Complexity: O(m^n) where m is number of operators allowed and n is length of input string
Space complexity: O(m+n)
LC verified. 
Problems faced: Initially was not able to consider the significance of '0' in middle of string. But, later handled it by putting a check condition
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> output = new ArrayList<>();
        StringBuilder numSb = new StringBuilder();
        if(num == null || num.length()<1)
            return output;
        backtrack(output, num, numSb, target, 0, 0, 0);
        return output;
    }
    
    public static void backtrack(List<String> output, String num, StringBuilder numSb, int target, int currPos, long prev, long prev_product){

        if(currPos==num.length()) {
            if(target==prev)
                output.add(numSb.toString());
            return;
        }
        for(int i=currPos; i<num.length(); i++){
            if(num.charAt(currPos) == '0' && i != currPos)
                break;
            long currVal = Long.parseLong(num.substring(currPos, i+1));
            int currLen = numSb.length();
            if(currPos==0) {
                backtrack(output, num, numSb.append(currVal), target, i+1, currVal, currVal);
                numSb.setLength(currLen);
            } else {
                backtrack(output, num, numSb.append("+").append(currVal), target, i+1, prev+currVal, currVal);
                numSb.setLength(currLen);
                backtrack(output, num, numSb.append("-").append(currVal), target, i+1, prev-currVal, -currVal);
                numSb.setLength(currLen);
                backtrack(output, num, numSb.append("*").append(currVal), target, i+1, prev-prev_product + prev_product*currVal, prev_product*currVal);
                numSb.setLength(currLen);
            }
        }
    }
}

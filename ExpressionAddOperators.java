/*
Time: O(N*4^N), Space: O(4^N)
Algorithm:
==========
1. Store previous processed value, so that if precdence issue occurs, we could update the value based on BODMAS rule
2. If current recursive call is trying multiplication, we should use previous calculation value, subtract previous number, and then 
add multiplication result to previous number and current number
*/
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, "", result, 0, 0, 0);
        return result;
    }
    
    private void backtrack(String num, int target, String currStr, List<String> result, int index, long sum, long tail) {
        if(index == num.length() && target == sum)
            result.add(currStr);
        
        for(int i = index; i < num.length(); i++) {
            if(i != index && num.charAt(index) == '0') break;           // Multiple 0's at the beginning ignored
            
            long curr = Long.parseLong(num.substring(index, i+1));      // Get current to process 
            
            if(index == 0) {
                backtrack(num, target, currStr + curr, result, i+1, curr, curr );
            }
            else {
                 backtrack(num, target, currStr + "+" + curr, result, i+1, sum+curr, curr); //+ operator
                 backtrack(num, target, currStr + "-" + curr, result, i+1, sum-curr, -curr); // - operator
                 backtrack(num, target, currStr + "*" + curr, result, i+1, sum-tail+(tail*curr), tail * curr); //* operator
            }
        }
    }
}
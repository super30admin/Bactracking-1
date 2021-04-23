/**Leetcode Question 282 - Expression Add Operator */
/**Algorithm - Recursion
 * Parse the given num string and take its value in a curr.
 * For the + case, pass the num, target, calc = calc + curr, tail = curr, index = i+1
 * For the - case, pass calc = calc - curr, tail = -curr, index = i+1
 * For the * case, pass calc = calc - tail + tail * curr, tail = curr*tail, index = i+1
 */
/**TC - O(4^N)
 * SC - O(H) - Height of the recursion stack = Length of the string
 */
public class ExpressionAddOperator {
    class Solution {
        List<String> result;
        public List<String> addOperators(String num, int target) {
            result = new ArrayList<>();
            if(num == null || num.length() == 0){
                return result;
            }
            helper(num, target, 0, 0, 0,"");
            return result;
        }
        private void helper(String num, int target, long calc, long tail, int index, String path){
            //base
            if(target == calc && index == num.length()){
                result.add(path);
                return;
            }
            
            //logic
            for(int i = index; i<num.length(); i++){
                long curr = Long.parseLong(num.substring(index,i+1));
                if(index!=i && num.charAt(index) == '0'){
                    continue;
                }
                if(index == 0){
                    helper(num, target, curr,curr, i+1, path + curr);
                }
                else{
                    //case 1 = +
                    helper(num, target, calc +curr, curr, i+1, path + "+" + curr);
                    
                    //case 2 = -
                    helper(num, target, calc - curr, -curr, i+1, path + "-" + curr);
                    
                    //case 3 = *
                    helper(num, target, calc-tail+tail *curr, curr*tail, i+1, path + "*" + curr);
                }
            }
        }
    }
}

public class ExpressionAddOperator {
  /**
   * 
   * Approach 1 : Using String
   * 
   * Time Complexity: O(N * 3^N)
   * Space Complexity: O(N)
   *    - Tree could be N levels deep. N being the length of String num.
   * 
   */
  List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        helper(num, 0, target, 0, 0, "");
        
        return result;
    }
    
    void helper(String num, int index, int target, long calc, long tail, String path){
        // base case
        if(calc == target && index == num.length()){
            result.add(path);
            return;
        }
        
        
        // logic
        for(int i = index; i < num.length(); i++){
            // preceeding zero
            if(num.charAt(index)  == '0' && i > index){ continue; }
            long curr = Long.parseLong(num.substring(index, i+1));
            
            if(index == 0){
                helper(num, i+1, target, curr, curr, path + curr);
            } else {
                // + operator
                helper(num, i+1, target, calc + curr, +curr, path + "+" + curr);
                
                // - operator
                helper(num, i+1, target, calc - curr, -curr, path + "-" + curr);
                
                // * operator
                helper(num, i+1, target, calc - tail + tail * curr, tail * curr, path + "*" + curr );
            }
        }
    }
}

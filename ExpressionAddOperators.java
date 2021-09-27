// TIME: O(4^n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class ExpressionAddOperators {
    List<String> answer;
    public List<String> addOperators(String num, int target) {
        answer = new ArrayList<>();
        helper(num, 0, 0, 0, target, "");
        return answer;
    }
    
    
    private void helper(String num, int pivot, long cal, long tail, int target, String path) {
        
        // base case
        if (pivot == num.length()) {
            if (cal == target) {
                answer.add(path);
            }
            
            return;
        }
        
        
        // recursion logic
        for (int i = pivot; i < num.length(); i++) {
            
            if (i != pivot && num.charAt(pivot) == '0') continue;
            
            Long curr = Long.parseLong(num.substring(pivot, i+1)); 
            
            if (pivot == 0) {
                helper(num, i + 1, curr, curr, target, path + curr);
            } else {
                // +
                helper(num, i + 1, cal + curr, curr, target, path + '+' + curr);
                
                // -
                helper(num, i + 1, cal - curr, -curr, target, path + '-' + curr);
                
                // *
                helper(num, i + 1, cal - tail + tail * curr, tail * curr, target, path + '*' + curr);
            }
            
        }
        
        
    }
}

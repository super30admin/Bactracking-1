class Solution {

    // Time Complexity: O(3^ N)
    // Space Complexity: O(N)

    private List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        // Edge Case Checking
        if(num == null || num.length() == 0)
            return result;

        backtracking(num, target, 0, 0, 0, "");

        return result;
    }

    private void backtracking(String num, int target, int index, long prevSum, long prevAdd, String expr){
        // Base Case
        if(index >= num.length()){
            if(prevSum == target){
                result.add(expr);
            }
            return;
        }

        // Logic
        for(int i = index; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i+1));

            if((num.charAt(index) == '0') && index != i)
                continue;

            if(index == 0){
                backtracking(num, target, i+1, curr, curr, expr+curr);
            }else{
                // +
                backtracking(num, target, i+1, prevSum + curr, curr, expr + '+' + curr);
                // -
                backtracking(num, target, i+1, prevSum - curr, -curr, expr + '-' + curr);
                // *
                backtracking(num, target, i+1, prevSum - prevAdd + prevAdd * curr, prevAdd * curr, expr + '*' + curr);
            }
        }
    }
} 

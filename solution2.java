//Time Complexity: O(4^n)
//Space complexity: O(n)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0l, 0l, new StringBuilder());
        return result;
    }
    
    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder expression) {
        //base case
        if( pivot == num.length() ) {
            if( calc == target ) {
                result.add(expression.toString());
            }
            return;
        }
        
        //logic
        for(int i = pivot; i < num.length(); i++) {
            int le = expression.length();
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if( i != pivot && num.charAt(pivot) == '0') {
                continue;
            }
            if( pivot == 0 ) {
                expression.append(curr);
                helper(num, target, i+1, curr, curr, expression);
                expression.setLength(le);
            } else {
                expression.append("+");
                expression.append(curr);
                helper(num, target, i+1, calc+curr, curr, expression);
                expression.setLength(le);
                expression.append("-");
                expression.append(curr);
                helper(num, target, i+1, calc-curr, -curr, expression);
                expression.setLength(le);
                expression.append("*");
                expression.append(curr);
                helper(num, target, i+1, calc-tail + (curr*tail), curr*tail, expression);
                expression.setLength(le);
            }
        }
    }
}
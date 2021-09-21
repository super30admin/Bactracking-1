// Time Complexity: Exponential time complexity O(n*4^n)
// Space Complexity: recursive stack has O(n) space complexity
// Did you complete it on leetcode: Yes
// Any problems faced: Understood in class

// Write your approach:
// Idea here is to iterate through the array and recurse for all cases,
// if there is no operator used, we continue to recurse on remaining string
// if we adopt an operator, there can be 3 cases, we have taken either a + or - or *.
// As + and - do not pose problem in BODMAS rule
// we add or subtract current value from calculated expression value.
// However, if we use * BODMAS rule gets violated for + - used earlier
// as the were not of precedence.
// To handle it, we maintain calculated value and tail value for each updated expression
// and as soon as a multiplication is encountered we nullify previous action
// by subtracting the previous tail from calculated value
// and perform multiplication operation before others
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num==null) return result;
        dfs(num, target, 0, new StringBuilder(), 0, 0);
        return result;
    }
    
    public void dfs(String num, int target, int index, StringBuilder exp, long tail, long calc) {
        // base
        if(index==num.length() && calc == target) {
            result.add(exp.toString());
            return;
        }
        // logic
        
        // recurse
        for(int i = index; i<num.length(); i++) {
            if(index!=i && num.charAt(index)=='0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = exp.toString().length();
            if(index == 0) {
                dfs(num, target, i+1, exp.append(curr), curr, curr);
                exp.setLength(len);
            } else {
                // Case +
                exp.append("+");
                dfs(num, target, i+1, exp.append(curr), curr, calc + curr);
                exp.setLength(len);
                // Case -
                exp.append("-");
                dfs(num, target, i+1, exp.append(curr), -curr, calc - curr);
                exp.setLength(len);
                // Case *
                exp.append("*");
                dfs(num, target, i+1, exp.append(curr), tail*curr, (calc-tail)+(tail*curr));
                exp.setLength(len);
            }
        }
    }
}
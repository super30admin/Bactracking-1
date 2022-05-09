//tc --> exponential
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) {
            return result;
        }
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int target, long calc, long tail, int index, String path) {
        //base
        if(index == num.length()) {
            if(calc == target) {
                result.add(path);
            }
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i++) {
            //this to prevent the edge case where eg. 105 from 05 long parse takes it as 5 and we get result without 
            //considering 0 number but we should get result considering allnumbers ! so we need to avoid that case
            // hence i'm using continue
            if(i != index && num.charAt(index) == '0') {
                continue;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if(index == 0) {
                helper(num, target, cur, cur, i + 1, path + cur);
            }
            else {
                // + recursive call
                helper(num, target, calc + cur, cur, i + 1, path + "+" + cur);
                // - recursive call
                helper(num, target, calc - cur, -cur, i + 1, path + "-" + cur);
                // *recursive call
                helper(num, target, (calc - tail) + (tail * cur), tail * cur, i + 1, path + "*" + cur);
            }
        }
    }
}
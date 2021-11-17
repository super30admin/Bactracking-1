//Running on leetcode: no
class Solution {
    List<String> result;
    int goal;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) {
            return result;
        }
        goal = target;
        helper(num, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int index, long calc, long tail, String path) {
        //base
        if(index == num.length()) {
            if(calc == goal) {
                result.add(path);
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0) {
                helper(num, i + 1, curr, curr, path + curr);
            }
            
            else{
                //case +
                helper(num, i + 1, calc + curr, curr, path + "+" + curr);
                //case -
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr);
                //case *
                helper(num, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + curr);
            }
        }
    }
}

package LeetCode;
/*
 * 
 * 
 * TC = O(4^n)
 *  SC = O(n) 
 * 
 * */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, 0, "", num, target);
        return res;
    }
    
    private void backtrack(List<String> res, int index, long bufVal, long sum, String path, String num, int target) {
        if (index == num.length()) {
            if (sum + bufVal == target) {
                res.add(path);
            }
            return;
        } 
        
        for (int i = index; i < num.length(); i++) {
            // if (i != index && num.charAt(index) == '0')
            //     break;
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backtrack(res, i + 1, cur, sum, path + cur, num, target);   
            } else {
                backtrack(res, i + 1, cur, sum + bufVal, path + "+" + cur, num, target);
                backtrack(res, i + 1, -cur, sum + bufVal, path + "-" + cur, num, target);
                backtrack(res, i + 1, bufVal * cur, sum, path + "*" + cur, num, target);
            }
        }
    }
}

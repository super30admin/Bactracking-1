// TC : 4^n
// SC : O(length of string)
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        
        helper(num, target, 0, "", 0, 0);
        
            return result;
    }
    
    private void helper(String num, int target, int index, 
                        String path, long calc, long tail) {
        
        if(num.length() == index) {
            if(calc == target) {
                result.add(path);
            }
            return;
        }
        
        
        for(int i = index; i < num.length(); i++) {
            if(index != i && num.charAt(index) == '0') continue;
            long cur = Long.parseLong(num.substring(index, i+1));
            if(index == 0) {
                helper(num, target, i+1, path+cur, cur, cur);
            }
            else {
                // +
                helper(num, target, i+1, path+'+'+cur, calc + cur, +cur);
                // -
                helper(num, target, i+1, path+'-'+cur, calc - cur, -cur);
                // *
                helper(num, target, i+1, path+'*'+cur, calc - tail + tail * cur
                       , tail * cur);
            }
        }
    }
}

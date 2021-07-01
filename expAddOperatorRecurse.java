// Time Complexity: O(2^n)
//Space Complexity: O(2^n)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num, target,"",0,0,0);
        return result;
    }
    private void helper(String num, int target, String path, int index, long calc, long tail){
        // base
        if(index == num.length() && target == calc){
            result.add(path);
            return;
        } 
        //logic
        for(int i=index; i<num.length(); i++){
            if(num.charAt(index) == '0' && index != i) continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(num, target, path+curr, i + 1, curr, curr);
            } else {
                // + operator
                helper(num, target, path+'+'+curr, i + 1, calc+curr, curr);
                
                // - operator
                helper(num, target, path+'-'+curr, i + 1, calc-curr, -curr);
                
                // * operator
                helper(num, target, path+'*'+curr, i + 1, calc-tail + tail * curr, tail*curr);
            }
        }
    }
}
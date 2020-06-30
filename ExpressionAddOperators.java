// Time Complexity: O(4^n) - because we have 4 brances at each level
// Space Complexity: O(4^n)
class Solution {
    List<String> res;
    int targ;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        targ = target;
        if(num == null || num.length() == 0) return res;
        helper(num, "", 0, 0, 0); // num, path, curr sum, tail of the last calculation, and current index
        return res;
    }
    
    private void helper(String num, String path, long calc, long tail, int index) {
        if(index == num.length()) {
            if(calc == targ) {
                res.add(path);
            }
            return;
        }
        
        for(int i=index; i<num.length();i++) {
            if(index!=i && num.charAt(index)=='0') break; // when it is not the first index and 0 is encountered
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0) {
                helper(num,path+curr,curr,curr,i+1);
            } else {
                helper(num, path+"+"+curr,calc+curr,curr,i+1);
                helper(num, path+"-"+curr,calc-curr,-curr,i+1);
                helper(num, path+"*"+curr,calc-tail+tail*curr,tail*curr,i+1); 
            }
        }
        
    }
}
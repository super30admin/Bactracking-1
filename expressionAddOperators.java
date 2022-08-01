// Time Complexity : O(4^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0,0,0, new StringBuilder(), target);
        return result;
    }
    private void helper(String num, int idx, long calc, long tail, StringBuilder path, int target){
        //base
        if(idx == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }
        //logic
        for(int i = idx; i < num.length(); i++){
            //preceding zero
            if(i != idx && num.charAt(idx) == '0') continue;
            Long curr = Long.parseLong(num.substring(idx, i+1));
            int le = path.length();
            if(idx == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, i + 1 ,curr, curr, path, target);
                //backtrack
                path.setLength(le);
            
            } else{
                //+
                //action
                path.append('+');
                path.append(curr);
                //recurse
                helper(num, i + 1 ,calc + curr, curr, path, target);
                //backtrack
                path.setLength(le);
                //-
                //action
                path.append('-');
                path.append(curr);
                //recurse
                helper(num, i + 1 ,calc - curr, -curr, path, target);
                //backtrack
                path.setLength(le);
                //*
                //action
                path.append('*');
                path.append(curr);
                //recurse
                helper(num, i + 1 ,calc - tail + tail * curr, tail * curr, path, target);
                //backtrack
                path.setLength(le);
            }
            
        }
    }
}

/*
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0,0,0,"", target);
        return result;
    }
    private void helper(String num, int idx, long calc, long tail, String path, int target){
        //base
        if(idx == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }
        //logic
        for(int i = idx; i < num.length(); i++){
            //preceding zero
            if(i != idx && num.charAt(idx) == '0') continue;
            Long curr = Long.parseLong(num.substring(idx, i+1));
            if(idx == 0){
                helper(num, i + 1 ,curr, curr, path + curr, target);
            } else{
                //+
                helper(num, i + 1 ,calc + curr, curr, path + '+' + curr, target);
                //-
                helper(num, i + 1 ,calc - curr, -curr, path + '-' + curr, target);
                //*
                helper(num, i + 1 ,calc - tail + tail * curr, tail * curr, path + '*' + curr, target);
            }
            
        }
    }
}
*/
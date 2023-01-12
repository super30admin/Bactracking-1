// Expression Add Operators

// Time Complexity : O(n*3^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0)
            return result;

        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }
    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }
        //logic
        for(int i = pivot; i < num.length(); i++){
            if(num.charAt(pivot) == '0' && pivot != i)
                continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int le = path.length();
            if(pivot == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, i+1, curr, curr, path, target);
                //backtrack
                path.setLength(le);
            } else {
                //+
                //action
                path.append("+");
                path.append(curr);
                //recurse
                helper (num, i + 1, calc + curr, +curr, path, target);
                //backtrack
                path.setLength(le);

                //-
                //action
                path.append("-");
                path.append(curr);
                //recurse
                helper (num, i + 1, calc - curr, -curr, path, target);
                //backtrack
                path.setLength(le);

                //*
                //action
                path.append("*");
                path.append(curr);
                //recurse
                helper (num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                //backtrack
                path.setLength(le);
            }  
        }
    }
}
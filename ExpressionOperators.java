// Time Complexity : exponential
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : could not think of the backtracking solution

class ExpressionOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null)
            return result;
        helper(num, target, "", 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, String path, int index, long calc, long tail){
        if(index == num.length()){
            if(calc == target)
                result.add(path);
            return;
        }

        for(int i = index; i < num.length(); i++){
            if(index!=i && num.charAt(index) == '0')
                break;
            long curr = Long.parseLong(num.substring(index, i+1));

            if(index == 0){
                helper(num, target, path + curr, i+1, curr, curr);
            }else{
                //+
                helper(num, target, path + "+" + curr, i+1, calc + curr, curr);
                //-
                helper(num, target, path + "-" + curr, i+1, calc - curr, -curr);
                //*
                helper(num, target, path + "*" + curr, i+1, calc - tail + tail*curr, tail*curr);
            }
        }
    }
}
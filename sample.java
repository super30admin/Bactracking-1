
//o(2^n) time and o(h) space

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, target,0, new ArrayList<>());
        return result;
    }

    private void helper(int [] candidates, int target, int index, List<Integer> path){
        //base

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target< 0 ) return;
        //logic
        //not choose
        for(int i = index; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recursion
            helper(candidates, target - candidates[i], i, path);

            //backtrack

            path.remove(path.size() -1 );
        }
    }
}

// o(4^n) time and o(h) space


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder() , 0, 0,0);
        return result;

    }
    private void helper( String num, int target, StringBuilder sb, long calc, long tail, int index){
        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
            }
            return;
        }
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i +1));
            int len = sb.toString().length();
            if (index == 0) {
                sb.append(curr);
                helper(num, target, sb, curr, curr, i + 1);
                sb.setLength(len);
            }
            else{
                //+
                sb.append('+');
                sb.append(curr);
                helper(num, target, sb, calc +curr, curr, i + 1);
                sb.setLength(len);
                //-
                sb.append('-');
                sb.append(curr);
                helper(num, target, sb, calc  - curr, -curr, i + 1);
                sb.setLength(len);
                //*
                sb.append('*');
                sb.append(curr);
                helper(num, target, sb, calc - tail + tail * curr,tail*curr, i + 1);
                sb.setLength(len);
            }
        }
    }
}
/* 

Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

Time Complexity : O(2^n)
Space Complexity : O(2^n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        
        if(num.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<String>();
        recurse(num, target, 0, 0, 0, new String());
        return result;
    }

    private void recurse(String num, int target, int index, long sum, long trail, String path){
        if(index == num.length()){
            if(target == sum){
                result.add(path);
            }
        }

        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && index != i){
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                recurse(num, target, i + 1, curr, curr, path + curr);
            }
            else{
                //+
                recurse(num, target, i + 1, sum + curr, curr, path + '+' + curr);
                //-
                recurse(num, target, i + 1, sum - curr, -curr, path + '-' + curr);
                //*
                recurse(num, target, i + 1, sum - trail + (trail * curr), trail * curr, path + '*' + curr);
            }


        }
    }
}
// Time Complexity : O(n*4^n) where n is length of string
// Space Complexity : O(n) where n is length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some problem implementing the code. I was able to think the logic

import java.util.*;

class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();
        helper(num, 0, 0, 0, "", target);
        return result;
    }

    private void helper(String num, int idx, long calc, long tail, String path, int target){
        //base
        if(idx==num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }

        //logic

        for(int i=idx;i<num.length();i++){
            if(i!=idx && num.charAt(idx)=='0') continue;

            long curr = Long.parseLong(num.substring(idx,i+1));
            if(idx==0){
                helper(num, i+1, curr, curr, path+curr, target);
            }
            else{
                helper(num, i+1, calc+curr, curr, path+'+'+curr, target);

                helper(num, i+1, calc-curr, -curr, path+'-'+curr, target);

                helper(num, i+1, calc-tail + tail*curr, tail*curr, path+'*'+curr, target);
            }
        }
    }

    public static void main(String[] args){
        ExpressionAddOperators eo = new ExpressionAddOperators();
        System.out.println(eo.addOperators("123", 6));
    }
}
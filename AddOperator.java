// Time Complexity :  O(3^N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class AddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        helper(num, 0,0,0,"",target);
        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, String path, int target){
        // base
        if (pivot == num.length()){
            if (calc == target){
                result.add(path);
            }
            return;
        }

        //logic
        for (int i=pivot;i<num.length();i++){
            if (num.charAt(pivot) == '0' && pivot != i) continue;
            long curr = Long.parseLong(num.substring(pivot,i+1));
            if (pivot == 0){
                helper(num, i+1, curr, curr, path+curr, target );
            } else {
                //+
                helper(num, i+1, calc+curr, +curr, path+"+"+curr, target );
                //-
                helper(num, i+1, calc-curr, -curr, path+"-"+curr, target );
                //*
                helper(num, i+1, calc-tail + (tail*curr), tail*curr, path+"*"+curr, target );
            }
        }
    }
}
// Time Complexity : O(3^n), ; 3 choices at each node
// Space Complexity : O(n),
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, new StringBuilder(), 0, 0, 0, target);
        return result;
    }

    private void helper(String num, StringBuilder path, int index, long calc,
                        long tail, int target){

        //base
        //1. All nums has to be used
        if(index == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
        }


        //logic
        for(int i = index; i < num.length(); i++){

            //precceding zero case, single zero is allowed
            if(i != index && num.charAt(index) == '0') continue;

            //calculate curr num i.e till which num are we clubbing it together
            //Ex: In 123, 1, 12, 123
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = path.length();


            //3 cases at every node except first numbers i.e no operand at start
            if(index == 0){
                path.append(curr); //action
                helper(num, path, i+1, curr, curr, target);//recurse
                path.setLength(len); // backtrack
            }else{
                //+
                path.append("+"); //action
                path.append(curr);
                helper(num, path, i+1, calc + curr, curr, target); //recurse
                path.setLength(len); // backtrack
                //-
                path.append("-"); //action
                path.append(curr);
                helper(num, path, i+1, calc - curr, -curr, target); //recurse
                path.setLength(len); // backtrack
                //*
                path.append("*"); //action
                path.append(curr);
                helper(num, path, i+1, calc - tail + (tail*curr), tail*curr, target); //recurse
                path.setLength(len); // backtrack
            }
        }
    }

}

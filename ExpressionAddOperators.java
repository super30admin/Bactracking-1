import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    // Brute Force Approach
    // TC - n* 3^n (exponential)
    // SC - exponential

    static class Solution1 {
        List<String> result;
        public List<String> addOperators(String num, int target) {

            result = new ArrayList<>();
            helper(num,0,0,0,"",target);
            return result;
        }

        private void helper(String num , int pivot , long calc, long tail , String path, int target){
            //base case
            if(pivot == num.length()){
                if(calc == target){
                    result.add(path);
                }
                return;
            }

            //logic
            for(int i = pivot ; i < num.length() ; i++){
                if(i != pivot && num.charAt(pivot) == '0') continue;
                long curr = Long.parseLong(num.substring(pivot,i+1));

                if(pivot == 0){
                    helper(num,i+1,curr,curr,curr+path,target);
                }

                else{
                    //+
                    helper(num,i+1,calc+curr,curr,path+"+"+curr,target);

                    //-
                    helper(num,i+1,calc-curr,-curr,path+"-"+curr,target);

                    //*
                    helper(num,i+1,calc-tail+tail*curr,curr*tail,path+"*"+curr,target);
                }
            }
        }
    }

    // BackTracking Approach
    // TC: n * 3^n (exponential)
    // SC: exponential
    static class Solution2 {
        List<String> result;
        public List<String> addOperators(String num, int target) {

            result = new ArrayList<>();
            helper(num,0,0,0,new StringBuilder(),target);
            return result;
        }

        private void helper(String num , int pivot , long calc, long tail , StringBuilder path, int target){

            //base case
            if(pivot == num.length()){
                if(calc == target){
                    result.add(path.toString());
                }
                return;
            }

            //logic
            for(int i = pivot ; i < num.length() ; i++){
                //preceding 0
                if(i != pivot && num.charAt(pivot) == '0') continue;
                long curr = Long.parseLong(num.substring(pivot,i+1));

                int le = path.length();

                if(pivot == 0){

                    //action
                    path.append(curr);
                    //recurse
                    helper(num,i+1,curr,curr,path,target);
                    //backtracking - reset length to prev length
                    path.setLength(le);
                }

                else{
                    //+
                    //action
                    path.append('+');
                    path.append(curr);
                    //recurse
                    helper(num,i+1,calc+curr,curr,path,target);
                    //backtracking
                    path.setLength(le);

                    //-
                    //action
                    path.append('-');
                    path.append(curr);
                    //recurse
                    helper(num,i+1,calc-curr,-curr,path,target);
                    //backtracking
                    path.setLength(le);

                    //*
                    //action
                    path.append('*');
                    path.append(curr);
                    //recurse
                    helper(num,i+1,calc-tail+tail*curr,curr*tail,path,target);
                    //backtracking
                    path.setLength(le);
                }
            }
        }
    }

}

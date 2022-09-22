// Time Complexity : n*  3^n (exponential) where n is the number of nodes
// Space Complexity :n*  3^n (exponential)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//Method 2 - BackTracking to avoid creating new string everytime, using StringBuilder
//TC: n*  3^n (exponential)
//SC: exponential
class Solution {
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

//Method 1 - Brute Force
//TC: n* 3^n (exponential)
//SC: exponential

class Solution {
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
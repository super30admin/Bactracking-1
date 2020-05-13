// Time Complexity : O(3^n) we could go down recursion each with + and - and *
// Space Complexity :  maxDepth of recursive stack or  O(3^n) in worst case.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtrack. The code follows the pattern action, recursion and backtrack. We do recursion per every operator and we stop when we get the target==to calculated value.
//Success
//Details 
//Runtime: 64 ms, faster than 71.76% of Java online submissions for Expression Add Operators.
//Memory Usage: 40.6 MB, less than 78.38% of Java online submissions for Expression Add Operators.

    public List<String> addOperators(String num, int target) {
        List<String> result= new ArrayList<>();
        backTrack(num,target,result,new StringBuilder(), 0,0,0);
        return result;
    }
    
    private void backTrack(String num, int target,List<String>  result,StringBuilder path,  long calculated, long tail, int index){
        //base
        if (index==num.length()){
            if (calculated==target){
                result.add(path.toString());
                return;
            }
        }
        //logic
        for (int i=index;i<num.length();i++){
            //for handling preceeding 0
            if (index!=i && num.charAt(index)=='0')
                break;
            long current= Long.parseLong(num.substring(index,i+1));
            int len= path.toString().length();
            if (index==0){
                //action
                path.append(current);
                //recurse
                backTrack(num,target,result,path,current,current,i+1);
                //backtrack
                path.setLength(len);
            }else{
                //action
                path.append("+");
                path.append(current);
                
                //recurse
                backTrack(num,target,result,path,calculated + current,current ,i+1);
                //backtrack
                path.setLength(len);
                
                //action
                path.append("-");
                path.append(current);
                
                //recurse
                backTrack(num,target,result,path,calculated - current,-current,i+1);
                //backtrack
                path.setLength(len);
                
                //action
                path.append("*");
                path.append(current);
                //recurse
                backTrack(num,target,result,path,calculated - tail + tail*current,tail*current,i+1);
                //backtrack
                path.setLength(len);
                
            }
        }
    }
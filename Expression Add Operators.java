//Backtracking
//Time Complexity : O(N*4^N). at each level there are 4 operations to be performed. This is done for the length of the string N. Hence N*4^N time is used.
//Space Complexity :  O(N) . recursive stack uses O(N) time.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :
/*
Each of the numbers must be used(ether as a single number or contacted) with any of three operators(+,-,*) to reach the target.
To get the solution, exhaustive search should be done. This leads to perform recursion. Hence, there are 4 operations to be performed at each recursive call.
Using the Backtracking approach, the following steps are taken,
1)ACTION: choose the operator and the character/number and add with the previous path
2)RECURSE: with the new path , move to the next number or next operation depending on the current level in recurssion
3)BACKTRACK :  If the end of string is reached with the target not reached, then backtrack by going to the previous step. In this case, the length of the string is set 
to previous length.
*/
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num==null||num.length()==0){
            return result;
        }
        long tail =0, cal=0;
        int index=0;//use calculated,tail/previousand index to calculate the result
        //use a helper function to perform recurssion
        helper(num,target,new StringBuilder(),cal,tail,index);// to support backtracking ,used stringbuilder as the strings cannot be modified in java
        return result;
    }
    private void helper(String num,int target,StringBuilder path,long cal,long tail,int index){
        //base case
        if(index==num.length()){
            if(target==cal){
                result.add(path.toString());
            }
            return;
        }
        //recurse
        for(int i=index;i<num.length();i++){
            //get the current string
            //convert the string to long to perform airthemetic operation
            long cur = Long.parseLong(num.substring(index,i+1));
            //getting the sustring as 12+3 is also a possible answer
            if(index!=i && num.charAt(index)=='0') continue;//if i/p string is 105, one of the possible answer is 1*0+5 but if 0 is not ignored then the result would just have 1*5 hence ignore 0
            //get the length of the string so far
            int length = path.length();
            if(index==0){
                // to use 12 or 123
                path.append(cur);//ACTION
                helper(num,target,path,cur,cur,i+1);//RECURSE
                path.setLength(length);//BACKTRACK
            }
            else{
                // + operation
                //ACTION
                path.append("+");
                path.append(cur);
                helper(num,target,path,cal+cur,cur,i+1);//RECURSE
                path.setLength(length);//BACKTRACK
                //- operation
                //ACTION
                path.append("-");
                path.append(cur);
                helper(num,target,path,cal-cur,-cur,i+1);//RECURSE
                path.setLength(length);//BACKTRACK
                //* operation
                //ACTION
                path.append("*");
                path.append(cur);
                helper(num,target,path,cal-tail+cur*tail,cur*tail,i+1);//RECURSE
                path.setLength(length);//BACKTRACK
                //inorder to preserve the BODMAS and multiplication predecence, the formulua to calculate the value for multplication is calculated value-tail + (cur*tail)
            }
        }
    }
}
// Time Complexity : O(4^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will be using for loop recursion to find all the possible numbers. At every place we will be putting the operators except for the top most level. 
//We will be using a recursive function to add the operators and when we reach the leaf, we will check if it is equal to the target, 
//if yes then we will add it to the result list, if not then we will not.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result=new ArrayList<>();
        helper(num,0,0,0,target,"");
        return result;   
    }

    private void helper(String num,int pivot,long calc,long tail, int target,String path)
    {
        //base
        if(pivot==num.length())
        {
            if(target==calc)
            {
                result.add(path);
            }
            return;
        }

        //logic
        //make combinations
        for(int i=pivot;i<num.length();i++)
        {
            //placeholder preceding zero
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            //make substring from pivot to i
            long curr=Long.parseLong(num.substring(pivot,i+1));
            //make combinations
            if(pivot==0)
            {
                helper(num,i+1,curr,curr,target,path + curr);
            }
            else
            {
                //+
                helper(num, i+1 , calc+curr , curr , target , path + "+" + curr);

                //-
                helper(num , i+1 , calc-curr , -curr , target , path + "-" + curr);

                //*
                helper(num , i+1 , calc-tail+tail*curr , tail*curr , target , path + "*" + curr);
            }

        }
        
    }
}


//Backtracking

// Backtracking: Backtracking will be used to change the operators. At the leaf node, we will backtrack by setting the length of the path to the original length of the path.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result=new ArrayList<>();
        helper(num,0,0,0,target,new StringBuilder());
        return result;   
    }

    private void helper(String num,int pivot,long calc,long tail, int target,StringBuilder path)
    {
        //base
        if(pivot==num.length())
        {
            if(target==calc)
            {
                result.add(path.toString());
            }
            return;
        }

        //logic
        //make combinations
        for(int i=pivot;i<num.length();i++)
        {
            //placeholder preceding zero
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            //make substring from pivot to i
            long curr=Long.parseLong(num.substring(pivot,i+1));
            //make combinations
            int le=path.length(); //this is the original lenght of the path and it will be used for backtracking
            if(pivot==0)
            {
                //action
                path.append(curr);
                //recurse
                helper(num,i+1,curr,curr,target,path);
                //backtrack
                path.setLength(le);
            }
            else
            {
                //+
                //action
                path.append("+");
                path.append(curr);
                //recurse
                helper(num, i+1 , calc+curr , curr , target , path);
                //backtrack
                path.setLength(le); //setting the length of the path to its original length

                //-
                //action
                path.append("-");
                path.append(curr);
                //recurse
                helper(num , i+1 , calc-curr , -curr , target , path);
                //backtrack
                path.setLength(le);

                //*
                //action
                path.append("*");
                path.append(curr);
                //recurse
                helper(num , i+1 , calc-tail+tail*curr , tail*curr , target , path);
                //backtrack
                path.setLength(le);
            }

        }
        
    }
}
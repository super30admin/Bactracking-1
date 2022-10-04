class Solution {
    //tc-N*3n
    //SC-3n exponential 
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,0,0,0,new StringBuilder(),target);
        return result;
    }
    private void helper(String num,int pivot,long calc,long tail,StringBuilder path,int target)
    {
        //basecase
         if(pivot == num.length())
         {
             if(calc == target)
             {
                 result.add(path.toString());
             }
             return;
         }
        
        //logic
        //check for 0
       
        for(int i=pivot;i<num.length();i++)
        {
         if(num.charAt(pivot) == '0' && i != pivot) continue;
         long curr = Long.parseLong(num.substring(pivot,i+1)); // 2 23 234
         int le = path.length();// 15
            if(pivot ==0)
            {
                //action
                path.append(curr);//19
                //recurse
                helper(num,i+1,curr,curr,path,target);
                //backtrack
                path.setLength(le);//15
            }
            else
            {//+
                //action
                path.append('+');
                path.append(curr);
                //recurse
                helper(num,i+1, calc+curr, +curr, path, target);
                //backtrack
                path.setLength(le);
                //-
                //action
                path.append('-');
                path.append(curr);
                //recurse
                helper(num,i+1, calc-curr, -curr, path, target);
                //backtrack
                path.setLength(le);
                //*
                  //action
                path.append('*');
                path.append(curr);
                //recurse
                helper(num, i+1, calc-tail + tail*curr, tail*curr, path, target);
                //backtrack
                path.setLength(le);
                
            }
        }
        
    }
}
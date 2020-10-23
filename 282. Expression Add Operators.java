class Solution {//class solution time of 4^n
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num,target,new String(),0,0,0);
        return result;
    }
    private void helper(String input, int target,String expr,long prev,long curr, int index)
    {
        //Base 
        if(index == input.length())
        {
           if(curr == target)
           {
               result.add(expr);
           }
            return;
        }
        // Make a choice
        for(int i = index ; i< input.length(); i++)
        {
            //precedding zeros
            if(index!= i && input.charAt(index)== '0')break;
            //calculate the sum
            long elem = Long.parseLong(input.substring(index,i+1));
            if(index == 0)
            {
                helper(input,target,expr+elem,elem,elem,i+1);
            }
            else
            {
                //+
                helper(input,target,expr+"+"+elem,elem,curr + elem,i+1);
                //-
                helper(input,target,expr+"-"+elem,-elem,curr - elem,i+1);
                //*
                helper(input,target,expr+"*"+elem,prev*elem,curr - prev + prev*elem,i+1);
            }
        }
    }
}
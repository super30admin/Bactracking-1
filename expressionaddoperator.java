//Time Complexity : O(4^n) as we have 4 chooses at every recursive call
//Space Complexity : O(n) as we are using String path so new string gets created everytime
//Did your code run on leetcode : yes

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0 , 0 , "");
        return result;
    }
    
    private void helper(String num, int target, long calc, long tail ,int idx, String path)
    {
        //base
        if(idx == num.length()){
            //here target is not going to zero but  we are calculating calc equal to target
            if(target == calc){
                result.add(path);
            }
            return;
        }
        
        //logic
        //for loop based recursion 
        for(int i = idx; i < num.length() ; i++)
        {
            long curr = Long.parseLong(num.substring(idx , i + 1));
            
            //preceding zeros
            if(num.charAt(idx) == '0' && idx != i) continue;
            
            //to form individual numbers
            if (idx == 0){
                helper(num,target,curr, curr, i + 1, path + curr);
            }
            else{
                //+
                helper(num,target,calc + curr, + curr, i + 1, path + "+" + curr);
                //-
                 helper(num,target,calc - curr, - curr, i + 1, path + "-" + curr);
                //*
                helper(num,target,calc - tail + curr * tail, curr * tail, i + 1, path + "*" + curr);


            }
        }
    }
}

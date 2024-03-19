// Time Complexity :O( N * 4^N). N= length of string, at every step along the way, we consider exactly 4 different choices or 4 different recursive paths. The base case is when the value of index reaches N 
//i.e. the length of the nums array. Hence, our complexity would be O(4^N) and substring would be O(N).
// Space Complexity : O(N), recursion stack space - N levels in worst case; taking only one digit at a time. Also O(N) for storing path in worst case
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : We have the option to choose or not the number, create new path reference for each recursion which adds to the space.


class Solution {
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        this.result =  new ArrayList<>();
        if(num == null) return result;

        helper(num,0,new StringBuilder(), 0,0,target);
        return result;    
    }

    private void helper(String num, int pivot, StringBuilder path, long calc, long tail, int target){
        //base - cover all digits
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }


        //create curr
        for(int i = pivot; i < num.length(); i++){
            //preceding zero - if curr number is starting from 0, like 05 in 105. Parsing would lead to skipping character zero.
            if(num.charAt(pivot) == '0' && i != pivot) break;
            
            long curr = Long.parseLong(num.substring(pivot,i+1));
            int len = path.length();
            // we don't add an operator before the first curr
            if(pivot == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, i+1, path, curr, curr, target);
                //backtrack
                path.setLength(len);
            }
            else{
                //+
                //action
                path.append("+");
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc+curr, curr, target);
                //backtrack
                path.setLength(len);

                //-
                //action
                path.append("-");
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc-curr, -curr, target);
                //backtrack
                path.setLength(len);

                //*
                //action
                path.append("*");
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc-tail + (curr*tail), curr * tail, target);
                //backtrack
                path.setLength(len);
            }
        }
    }
}
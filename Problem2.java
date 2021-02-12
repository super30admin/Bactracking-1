// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //create a result array
    List<String> res;
    public List<String> addOperators(String num, int target) {
        //intialize the result array
        res = new ArrayList<>();
        //call the backtrack function
        backtrack(num, target, new StringBuilder(), 0, 0 , 0);
        return res;
    }

    private void backtrack(String num, int target, StringBuilder path, long calc, long tail, int idx){
        //base
        if(idx == num.length()){
            //if target is reached add it to the res array
            if(calc == target){
             res.add(path.toString());   
            }
            return;
        }
        //logic
        //start a for loop to iterate through the strnig
        for(int i = idx; i < num.length(); i++){
            //check if you have a preceeding 0 in the first instance
            if(idx != i && num.charAt(idx) == '0') continue;
            //take the current which will be a substring from the current index to i+1 if say we have a double digit like 12
            long cur = Long.parseLong(num.substring(idx, i+1));
            //take the length of the current path to make sure we can backtrack to this length after
            int length = path.toString().length();
            if(idx == 0){
                //add the current to the path
                path.append(cur);
                //call the recursive function
                backtrack(num, target, path, cur, cur, i+1);
                //now backtrack by going back to orginal length
                path.setLength(length);
            }
            //all other cases
            else{
                //in the + case
                //action
                path.append("+");
                path.append(cur);
                //call the recursive function
                backtrack(num, target, path, calc + cur, cur, i+1);
                //backtrack
                path.setLength(length);

                //in the - case
                //action
                path.append("-");
                path.append(cur);
                //call the recursive function
                backtrack(num, target, path, calc - cur, -cur, i+1);
                //backtrack
                path.setLength(length);


                //in the * case
                //action
                path.append("*");
                path.append(cur);
                //call the recursive function
                backtrack(num, target, path, calc - tail + tail*cur, tail*cur, i+1);
                //backtrack
                path.setLength(length);

            }

        }
    }
}
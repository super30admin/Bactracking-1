//Approach-1: Using the String - not a BackTracking approach
//Overall Time Complexity: O(3^N) - "Exponential" - For each node we have 3 children
//Overall Space Complexity: O(3^N) - "Exponential" - Every recursive call we are creating a new String
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        
        helper(num,0, 0, 0, "",target);
        
        return res;
    }
    
    public void helper(String num, int pivot, long calc, long tail, String path, int target){
        //Base Case
        //Reached the end and all the values are considered
        if(pivot == num.length()){
            if(calc == target){
                res.add(path);
                return;
            }
        }
        //Logic
        for(int i = pivot; i < num.length(); i++){
            //Handling the 0 case - 0 preifix case if its presnet we check and then we continue
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            //The level 0 case where there are no additional operations
            if(pivot == 0){
                helper(num, i + 1, curr, curr, path + curr, target);
            }else{ //We have three cases
                //+ case
                helper(num, i + 1, calc + curr, +curr, path + "+" + curr, target);
                //- case
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr, target);
                //* case
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr, target);
            }
        }
        
    }
}



//Approach-1: Using the StringBuilder - BackTracking approach
//Overall Time Complexity: O(3^N) - "Exponential" - For each node we have 3 children
//Overall Space Complexity: O(N) - Here we are dominated by the recursion stack
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        
        helper(num,0, 0, 0, new StringBuilder(),target);
        
        return res;
    }
    
    public void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target){
        //Base Case
        //Reached the end and all the values are considered
        if(pivot == num.length()){
            if(calc == target){
                res.add(path.toString());
                return;
            }
        }
        
        //Logic
        for(int i = pivot; i < num.length(); i++){
            //Handling the 0 case - 0 preifix case if its presnet we check and then we continue
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            int len = path.length();
            
            //The level 0 case where there are no additional operations
            if(pivot == 0){
                
                //Action
                path.append(curr);
                //Recurse
                helper(num, i + 1, curr, curr, path, target);
                //BackTrack
                path.setLength(len);
                
            }else{ //We have three cases
                //+ case
                //Action
                path.append("+");
                path.append(curr);
                //Recurse
                helper(num, i + 1, calc + curr, +curr, path, target);
                //Backtrack
                path.setLength(len);
                
                //- case
                //Action
                path.append("-");
                path.append(curr);
                //Recurse
                helper(num, i + 1, calc - curr, -curr, path, target);
                //Backtrack
                path.setLength(len);
                
                //* case
                //Action
                path.append("*");
                path.append(curr);
                //Recurse
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                //Backtrack
                path.setLength(len);
                
            }
        }
        
    }
}


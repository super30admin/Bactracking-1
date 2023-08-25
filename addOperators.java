// TC: O( N * (3 ^ L)) -> L is total digits in the given string, 3 -> we have 3 options at each node i.e + - *, N-> converting stringbuilder into string
// SC: O(2N) -> AT MAX TOTAL N elements will be there in stack i.e depth. N is total number of elements in the given string another N for stringbuilder i.e auxilary space
// https://www.youtube.com/watch?v=YYvqdF78Qx0&ab_channel=%7BS30%7D
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, target, new StringBuilder(), 0, 0);
        return result;
    }
    
    private void helper(String num, int pivot, int target, StringBuilder path ,long calc, long tail){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());    
            }
            return;
        }
        
        //logic
        for(int i=pivot; i< num.length(); i++){
             //handle precedence of '0'
            if(num.charAt(pivot) == '0' && i != pivot) continue;
            
            //form substrings
            long curr = Long.parseLong(num.substring(pivot, i+1));
           
            //handle first level
            int le = path.length();
            if(pivot == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, i+1, target, path, curr, curr);
                //backtrack
                path.setLength(le);
            }else{ //else for all other levels
                //+
                //action
                path.append("+");
                path.append(curr);    
                //recurse
                helper(num, i+1, target, path, calc + curr, +curr);
                //backtrack
                path.setLength(le);
                //-
                //action
                path.append("-");
                path.append(curr);    
                //recurse
                helper(num, i+1, target, path, calc - curr, -curr);
                //backtrack
                path.setLength(le);
                //*
                //action
                path.append("*");
                path.append(curr);    
                //recurse
                helper(num, i+1, target, path, calc - tail + tail*curr , tail*curr);  
                //backtrack
                path.setLength(le);
            }
           
        }
    }
}

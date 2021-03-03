/*
Time: O(3^n) 3 choices for every element
Space: O(n) - depth of the elements
*/

class Solution {
    List<String> result;
    int trgt;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        trgt = target;
        //edge case
        if(num == null || num.length() == 0) return result;
        
        helper(num , "", 0, 0, 0);
        return result;
    }
    
    //without backtracking
    private void helper(String num, String path, int index, long cal, long tail){
        //base case
        if(index == num.length()){
            if(cal == trgt){
                result.add(path);
            }
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i++){
            //skip if the char is 0 
            //i.e. 05 -> 5
            if(index != i && num.charAt(index) == '0') continue;
            
            long curr = Long.parseLong(num.substring(index, i+1));
            
            //handle separately for root -> index = 0
            //here cal and tail are curr 
            if(index == 0){
                helper(num, path+curr, i+1, curr, curr); // i+1 coz no repeate
            }
            else{
                //+
                helper(num, path + "+" + curr, i+1, cal+curr, curr);
                
                //-
                helper(num, path + "-" + curr, i+1, cal-curr, -curr);
                
                //*
                helper(num, path + "*" + curr, i+1, (cal-tail + tail*curr), tail*curr);
            }
        }
    }



    private void helperB(String num, StringBuilder sb, int index, long cal, long tail){
        //base case
        if(index == num.length()){
            //add to result 
            if(trgt == cal)
                result.add(sb.toString());
            
            return;
        }
        
        //logic
        for(int i = index; i < num.length(); i++){
            //preceding zero case
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            
            //if index = 0, cal and tail is same
            if(index == 0){
                //action - add to path -> sb
                sb.append(curr);
                //recurse
                helperB(num, sb, i+1, curr, curr);
                //backtrack
                sb.setLength(len);
            }
            else{
                //+
                sb.append("+"); //action
                sb.append(curr); //action
                helperB(num, sb, i+1, cal+curr, curr); //recurse
                sb.setLength(len); //backtrack
                
                //-
                sb.append("-"); //action
                sb.append(curr); //action
                helperB(num, sb, i+1, cal-curr, -curr); //recurse
                sb.setLength(len); //backtrack
                
                //*
                sb.append("*"); //action
                sb.append(curr); //action
                helperB(num, sb, i+1, cal-tail+tail * curr, tail*curr); //recurse
                sb.setLength(len); //backtrack
            }
        }
    }
}
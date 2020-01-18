// Time Complexity - O(4^n) where n is the length of the string
// Space Complexity - O(n) where n is the length of the string
// This solution worked on LeetCode

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0)
            return result;      
        backtrack("",num, target, 0, 0, 0);
        return result;
    }
    
    private void backtrack(String path, String num, int target,int index,long calculated, long tail){
        //Base Case
        if(index == num.length()){  // once the string is processed, check if the target is acheived
            if(calculated == target){
                result.add(path);
            }
            return;
        }
        // Logic
        for(int i=index; i<num.length(); i++){
            // Zero Case
            if(i != index && num.charAt(index) == '0')  break;  //if '0' is at the index
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index==0){ // first difit in the string
                backtrack(path + curr,num, target,i+1,curr,curr);
            }
            else{
                backtrack(path + '+' +curr,num, target,i+1,calculated + curr,+curr); // + Case
                backtrack(path + '-' +curr,num, target,i+1,calculated - curr,-curr);  // - Case
                backtrack(path + '*' +curr,num, target,i+1,calculated - tail + tail*curr,tail*curr); // * Case
            }
        }
    }
}

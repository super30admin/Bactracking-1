/* Time Complexity: O(4^N)
Space Complexity: O(n)
*/
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0)
            return result;
        backtrack("", num, target, 0,0,0);
        return result;
    }

    private void backtrack(String path, String num, int target, int index, long calculated, long tail){
        //Base Case
        if(index == num.length()){
            if(calculated == target){
                result.add(path);
                return;
            }
        }

        //Logic
        for(int i=index; i<num.length(); i++){
            //to take care of preceeding 0(more than one 0 should not be included)
            if(i != index && num.charAt(index) == '0')
                break;

            Long cur = Long.parseLong(num.substring(index, i+1)); //this takes care of the edge case where we dont choose and operator and just concatenate the new number to the previous one

            if(index==0){ 
                backtrack(path + cur, num, target, i+1, cur, cur);
            }else{
                backtrack(path + '+' + cur, num, target, i+1, calculated+cur, cur);
                backtrack(path + '-' + cur, num, target, i+1, calculated-cur, -cur);
                backtrack(path + '*' + cur, num, target, i+1, calculated-tail + (tail * cur), tail * cur);
            }
        }
    }
}
//TC:O(N*4^N)
//SC:O(N)

//we iterate over the array and calculate various results using the three operators given and check if that equals target
//if we get target == calculated value, we add the path that gave us the output, else we recurse throughout to find the desired answer
//
//

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num,target,0, 0, 0,"");
        return result;
    }
    private void helper(String num,int target,int index,long calc, long tail,String path){
        // base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }

        // logic
        for(int i = index; i < num.length(); i++){
            // If we have zero in between or before a number that is giving us incorrect output
            if(index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+ 1));
            if(index == 0){
                helper(num,target,i+1, curr, curr,path + curr);
            } else {
                // Addition
                helper(num,target,i+1,calc + curr,curr, path + "+" + curr);
                // Subtract
                helper(num,target,i+1,calc - curr,-curr, path + "-" + curr);
                // Multiplication
                helper(num,target,i+1, calc - tail + (tail * curr), tail*curr,path + "*" + curr);

            }

        }

    }
}
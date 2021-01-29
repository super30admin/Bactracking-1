// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : some difficulty with concept but understood now


// Your code here along with comments explaining your approach

public class Operators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, "", 0, 0, 0);
        return result;
    }

    public void helper(String num, int target, String path, long calc, long tail, int index){

        //base
        if(index == num.length()){
            //if exp. ans equals target add it to result
            if(calc == target){
                result.add(path);
            }
            return;
        }



        //logic
        for(int i = index; i < num.length(); i++){

            if(index != i && num.charAt(index) == '0') continue;

            long cur = Long.parseLong(num.substring(index,i+1));

            //if zero first
            if(index == 0){
                helper(num, target, path + cur, cur, cur, i+1);

            }
            else{
                //plus
                helper(num,target, path + "+" + cur, calc + cur, cur, i+1);
                //minus
                helper(num,target, path + "-" + cur, calc - cur, -cur, i+1);
                //multiply
                helper(num,target, path + "*" + cur, calc - tail + tail*cur, cur*tail, i+1);
            }
        }


    }
}
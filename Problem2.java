import java.util.ArrayList;
import java.util.List;

//T.C :exponential
//S.C : not sure
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem4 {

public class Problem2 {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res  = new ArrayList<>();

        helper (num,target, 0,0,0,"");
        return res;
    }
    private void helper(String num, int target, int index, long cal, long tail,String path){
        if(index == num.length()){
            if(cal == target){
                res.add(path);
            }
        }
        //logic
        for(int i = index;i<num.length();i++){
            if( num.charAt(index )== '0' && index != i){
                continue;
            }
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index ==0){
                helper(num,target,i+1,curr,curr,path+curr);
            }else{
                //+ operator
                helper(num,target,i+1,cal+curr,+curr,path + '+' + curr);
                //- operator
                helper(num, target,i+1,cal-curr,-curr,path + '-' + curr);
                //* operator
                helper(num, target, i+1,cal-tail + (tail*curr), tail*curr,path+"*"+ curr);

            }
        }
    }
}

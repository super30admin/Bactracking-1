package s30.backTracking.b1;

import java.util.ArrayList;
import java.util.List;

// Algo
// iterate through all the substrings of the number.
// for first each substring add it to the list
// then make the operations


// Time Complexity O(4^n) for every digit we have four choices
// Space Complexity O(n) recursive stack and exp list

public class ExpressionAddOperators {

    private List<String> exp;
    private List<String> result;
    private int target;

    public List<String> addOperators(String num, int target) {
        exp = new ArrayList();
        result = new ArrayList();
        this.target = target;

        addOperators(num, 0, 0, 0);

        return result;
    }

    private void addOperators(String num, int index, long res, long tail){

        //base
        if(index == num.length()){
            if(res == target){
                result.add(String.join("", exp));
            }
            return;
        }

        for(int i= index; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i+1));

            //Op
            if(exp.size() == 0){
                exp.add(curr+"");
                addOperators(num, i+1, curr, curr);
                exp.remove(exp.size()-1);
            }else {

                //add
                exp.add("+"); exp.add(curr+"");
                addOperators(num, i+1, res + curr, curr );
                exp.remove(exp.size()-1);
                exp.remove(exp.size()-1);


                //sub
                exp.add("-"); exp.add(curr+"");
                addOperators(num, i+1, res - curr, -curr );
                exp.remove(exp.size()-1);
                exp.remove(exp.size()-1);

                // mul
                exp.add("*"); exp.add(curr+"");
                addOperators(num, i+1, (res - tail) + (tail * curr) , tail * curr);
                exp.remove(exp.size()-1);
                exp.remove(exp.size()-1);

            }

            if(curr == 0) break;

        }
    }

}

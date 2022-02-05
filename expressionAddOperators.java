
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        addOperators("123", 6);
    }

    static List<String> result;
    public static List<String> addOperators(String num, int target) {
    result = new ArrayList<>();
    helper(num, "", 0, 0, 0, target);
        return result;
}

    private static void helper(String num, String path, int index, long calc, long tail, int target){
        //base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
                return;
            }
        }

        //logic
        for(int i=index; i<num.length(); i++){
            if(i!=index && num.charAt(index) == '0')
                continue;

            long curr = Long.parseLong(num.substring(index, i+1));

            if(index == 0){
                helper(num, path+curr, i+1, curr, curr, target);
            } else {
                //+
                helper(num, path + "+" + curr, i+1, calc+curr, curr, target);

                //_
                helper(num, path + "-" + curr, i+1, calc-curr, -curr, target);

                //*
                helper(num, path + "*" + curr, i+1, calc-tail + (tail*curr), tail * curr, target);

            }

        }
    }
}


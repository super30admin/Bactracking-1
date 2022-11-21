

// TC : O(4^n) // n = length of str
// SC : O(n)

package S30_Codes.Bactracking_1;
import java.util.ArrayList;
import java.util.List;


class ExpressionAddOperators {
    List<String> result;
    List<String> curExpr;
    int target;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList();
        curExpr = new ArrayList();
        this.target = target;

        checkCombination(num, 0, 0, 0);
        return result;
    }

    private void checkCombination(String str, int idx, long curAns, long prev){
        if(idx == str.length()){
            if(curAns == target){
                StringBuilder expr = new StringBuilder();
                for(String s : curExpr){
                    expr.append(s);
                }
                result.add( expr.toString() );
            }
            return;
        }

        long curNum = 0;

        for(int i=idx; i<str.length(); i++){
            curNum = curNum * 10 + (str.charAt(i)-'0');

            if(curExpr.size() == 0){
                curExpr.add(curNum + "");
                checkCombination(str, i+1, curNum, curNum);
                curExpr.remove(curExpr.size()-1);
            }
            else{

                // For '+'
                curExpr.add("+");
                curExpr.add(curNum + "");
                checkCombination(str, i+1, curAns+curNum, curNum);
                curExpr.remove(curExpr.size()-1);
                curExpr.remove(curExpr.size()-1);

                // For '-'
                curExpr.add("-");
                curExpr.add(curNum + "");
                checkCombination(str, i+1, curAns-curNum, -curNum);
                curExpr.remove(curExpr.size()-1);
                curExpr.remove(curExpr.size()-1);

                // For '*'
                curExpr.add("*");
                curExpr.add(curNum + "");
                checkCombination(str, i+1, (curAns-prev)+(prev*curNum), prev*curNum);
                curExpr.remove(curExpr.size()-1);
                curExpr.remove(curExpr.size()-1);
            }

            // Not Selecting leading 0
            if( curNum == 0 ) {
                break;
            }
        }
    }
}
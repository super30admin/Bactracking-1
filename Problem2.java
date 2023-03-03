import java.util.ArrayList;
import java.util.List;
/*
Expressions add operators
approach: use pivot onwards technique, at first level, we can't add operators, at other levels we have 3 options.
time: O(number of characters in string builder * 3^length of string)
space: O(number of digits)
 */
public class Problem2 {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result  = new ArrayList<>();
        dfs(num, target, 0, 0, 0,new StringBuilder());
        return result;
    }

    private void dfs(String num, int target, int pivot, long calc, long tail, StringBuilder path) {
        if(pivot==num.length()) {
            if(calc == target) {
                result.add(path.toString());
            }
            return;
        }

        for(int i=pivot;i<num.length();i++) {
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int le = path.length();
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            if(pivot==0) {
                path.append(curr);
                dfs(num, target, i+1, curr, curr, path);
                path.setLength(le);
            }
            else {
                //"+"
                path.append("+");
                path.append(curr);
                dfs(num, target, i+1, calc+curr, +curr, path);
                path.setLength(le);
                path.append("-");
                path.append(curr);
                dfs(num, target, i+1, calc-curr, -curr, path);
                path.setLength(le);
                path.append("*");
                path.append(curr);
                dfs(num, target, i+1, calc-tail+tail*curr, curr*tail, path);
                path.setLength(le);
            }

        }
    }
}

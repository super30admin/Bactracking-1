import java.util.List;
import java.util.ArrayList;

public class ExpressionAddOperatorsFor4WayRecursionNoBacktrack {

        // TWO LEVEL RECURSION - FOR LOOP + 4WAY - NO BACKTRACKING

        List<String> result;

        public List<String> addOperators(String num, int target) {

            result = new ArrayList<>();

            recurseNoBktrk(num, "", 0, 0, 0, target);

            return result;
        }

        private void recurseNoBktrk(String num, String pathExp, long cal, long tail, int pivot, int target) {

            // base
            // if pivot reaches the end character in num, covering all digits
            if(pivot == num.length()) {

                // and if target is reached
                if(cal == target) {

                    // add the expression to result
                    result.add(pathExp);
                }
                return;
            }


            //logic
            // for loop based recursion
            for(int i = pivot; i < num.length(); i++) {

                // update current substring
                Long curr = Long.parseLong(num.substring(pivot, i+1));

                // preceding zero - edge case
                if( num.charAt(pivot) == '0' && i != pivot ) continue;

                if(pivot == 0) {
                    // fourth choice of no operator
                    // first level in for loop from where 3-way (3-choice) recursion starts
                    recurseNoBktrk(num, pathExp+curr , curr, curr, i+1, target);
                }

                else{

                    // 3-way recursion
                    // +
                    recurseNoBktrk(num, pathExp + "+" + curr, cal +curr, curr, i+1, target);

                    // -
                    recurseNoBktrk(num, pathExp + "-" + curr, cal -curr, -curr, i+1, target);

                    //*
                    recurseNoBktrk(num, pathExp + "*" + curr, cal - tail + tail*curr, tail*curr, i+1, target);
                }
            }
        }

}

/*
TIME COMPLEXITY = O(N*4^N)

N = length of num,
4 choices at each level: -, +, *, no operator

O(4^N) = tree nodes

SPACE COMPLEXITY = O(N*4^N)

Extra Space O(N) for each O(4^N) nodes = O(N*4^N)

 */
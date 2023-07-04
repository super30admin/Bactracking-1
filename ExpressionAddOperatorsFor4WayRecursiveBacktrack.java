import java.util.List;
import java.util.ArrayList;

public class ExpressionAddOperatorsFor4WayRecursiveBacktrack {


        // TWO LEVEL RECURSION - FOR LOOP + 4WAY - WITH BACKTRACKING

        List<String> result;

        public List<String> addOperators(String num, int target) {

            result = new ArrayList<>();

            recursebacktrack(num, 0, new StringBuilder(), 0, 0, target);

            return result;
        }

        private void recursebacktrack(String num, int pivot, StringBuilder pathExp, long cal, long tail, int target) {

            int pl = pathExp.length();

            //base
            if(pivot == num.length()) {

                if(cal == target) {

                    result.add(pathExp.toString());
                }
                return;
            }

            //logic

            for(int i = pivot; i < num.length(); i++) {

                //preceding zero - edge case
                if(num.charAt(pivot) == '0' && i != pivot) continue;

                long curr = Long.parseLong(num.substring(pivot, i+1));

                if(pivot == 0) {

                    // fourth choice of no operator
                    // first level in for loop from where 3-way (3-choice) recursion starts

                    //action
                    pathExp.append(curr);

                    //recurse
                    recursebacktrack(num, i+1, pathExp, curr, curr, target);

                    //backtrack
                    pathExp.setLength(pl);
                }

                else{

                    //+
                    //action
                    pathExp.append("+");
                    pathExp.append(curr);

                    //
                    recursebacktrack(num, i+1, pathExp, cal + curr, curr, target);

                    //backtrack
                    pathExp.setLength(pl);

                    //-
                    //action
                    pathExp.append("-");
                    pathExp.append(curr);

                    //
                    recursebacktrack(num, i+1, pathExp, cal - curr, -curr, target);

                    //backtrack
                    pathExp.setLength(pl);

                    //*
                    //action
                    pathExp.append("*");
                    pathExp.append(curr);

                    //
                    recursebacktrack(num, i+1, pathExp, cal - tail + tail*curr, tail*curr, target);

                    //backtrack
                    pathExp.setLength(pl);

                }
            }


        }

}

/*
TIME COMPLEXITY = O(N*4^N)

N = length of num,
4 choices at each level: -, +, *, no operator

O(4^N) = tree nodes

SPACE COMPLEXITY = O(N)

recursive stack - O(N)
String Builder - O(N) - one String Builder for all nodes with backtracking
 */
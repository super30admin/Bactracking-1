//TC: O(N ^ (T/M + 1)) N - num of candidates, T - target, M - minimal value among candidates
//SC: O(T/M) 

/*

1. We find the sum by adding element at index to the path. The path with sum == target is added to result.
2. For loop is maintained to consider duplicate elements in the candidate.

*/

import java.util.*;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> comboSum(int[] candidates, int target){
        bt(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    private static void bt(int[] candidates, int target, int index, int sum, List<Integer> path){

        System.out.println(sum+" "+path);
        if(sum > target) return;
        else if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }else if(index > candidates.length) return;

        for(int i = index; i < candidates.length; i++){

            //add to path
            path.add(candidates[i]);

            //recursive call
            bt(candidates, target, i, sum + candidates[i], path);

            //removal
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,3,7};
        System.out.println(comboSum(arr, 7));

    }
}

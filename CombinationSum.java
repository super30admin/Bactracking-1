package s30.backTracking.b1;

import java.util.ArrayList;
import java.util.List;

//Algo- Similar to coin change except the output
// Every index we have choose a number and do not choose a number



// TC : O(2^x)       here, x = target / (minNumber in the array) ==> at worst case x = target
// SC: O(n)  n being the size of the array

public class CombinationSum {

    private List<List<Integer>> res;
    private List<Integer> curRes;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList();
        curRes = new ArrayList();

        combinationSum(candidates, 0, target);


        return res;
    }


    private void combinationSum(int[] candidates, int index, int target){
        //base
        if(target == 0){
            res.add(new ArrayList(curRes));
            return;
        }
        if(index == candidates.length || target < 0) return;

        //recurse
        //select
        int tempRem = target;
        int count =0;
        while(tempRem >= 0){
            curRes.add(candidates[index]);
            tempRem -= candidates[index];
            count++;
            combinationSum(candidates, index + 1,tempRem);
        }

        while(count >0){
            curRes.remove(curRes.size()-1);
            count--;
        }


        //notSelect
        combinationSum(candidates, index+1, target);
    }
}

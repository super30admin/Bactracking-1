//Time Complexity: O(2^(target/minimum Amount coin))
//Space Complexity: O(n)
//runs successfully
//didn't face any problems


import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    //Approach 3
    List<List<Integer>> result;                                                 //creating result array
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
        combinations(candidates, target, 0, new ArrayList<>());             //calling function
        return result;

    }

    private void combinations(int[] candidates, int target, int index, List<Integer> list){


        //base
        if(target == 0){                                                //if target value becomes zero means we reach the target, so add the list into result list
            result.add(new ArrayList<>(list));
            return;
        }

        if(index == candidates.length || target <0){                //it means that, we can't get the target using this path, so return
            return;
        }


        for(int i = index; i<candidates.length; i++){              //iterating through candidates array

            list.add(candidates[i]);                            //add one element at a time
            combinations(candidates, target - candidates[i], i, list);  //calling recursive function to check if we can get the target using this many coing and path
            list.remove(list.size()-1);                         //backtracking our previous step

        }

    }


    //Approach 2
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {

//         result = new ArrayList<>();
//         combinations(candidates, target, 0, new ArrayList<>());
//         return result;

//     }

//     private void combinations(int[] candidates, int target, int index, List<Integer> list){

//         //base
//         if(target == 0){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         if(index == candidates.length || target < 0){
//             return;
//         }


//         combinations(candidates, target, index+1, list);

//         //recurse
//         int size = list.size();
//         while(target>0){
//             target = target - candidates[index];
//             list.add(candidates[index]);
//             combinations(candidates, target, index+1, list);

//         }

//         while(list.size() != size){
//             list.remove(list.size()-1);
//         }

//     }



    //Approach 1
//     private List<List<Integer>> result;

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {

//         result = new ArrayList<>();
//         combinations(candidates, 0, target, new ArrayList<>());
//         return result;

//     }

//     private void combinations(int[] candidates, int index, int target, List<Integer> list){

//         //base
//         if(target == 0){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         if(index == candidates.length || target < 0){
//             return;
//         }

//         //notChoose
//         combinations(candidates, index+1, target, list);

//         //choose
//         list.add(candidates[index]);
//         combinations(candidates, index, target-candidates[index], list);
//         list.remove(list.size()-1);

//     }

}
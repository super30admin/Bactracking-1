import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/combination-sum/
/* Normal recursion +
Create a recursion based tree
Formulate all combinations
Keep maintaining the combination list till the target>0
once target =0 add the combination list to result.
At the end after the all combinations are iterated over return the result list.
// Backtracking
For BT only remove the element that gets to the list of elements
*/
/* For Loop Based recursion
* Similar to normal based recursion, but more intuitive
*
* //Backtracking
* For BT only remove the element that gets to the list of elements
 * */
////Time Complexity O(2^n) where n equals number of candidates
//Space Complexity - O(number of times we copy the elements in the list that is number of
// elements till target is not exceeded)
public class CombinationSum {
    public static void main(String[] args) {
        int[] canditdates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(canditdates,target));
    }
//For loop based backtracking
static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates, target,0,new ArrayList<>());
        return result;

    }
    private static void helper(int[] candidates,int target, int index,List<Integer> path) {
        //base
        if(target<0) return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = index; i < candidates.length; i++) {

            path.add(candidates[i]);
            helper(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }

//For loop based Recursion
    /*
    static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates, target,0,new ArrayList<>());
        return result;

    }
    private static void helper(int[] candidates,int target, int index,List<Integer> path) {
    //base
if(target<0) return;

        if (target == 0) {
            result.add(path);
            return;
        }
        // logic
        for (int i = index; i < candidates.length; i++) {
            List<Integer>newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            helper(candidates,target-candidates[i],i,newList);
        }
    }
*/
//BackTracking
    // Follow the template Action recurse backtrack
/*static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates, target,0,new ArrayList<>());
        return result;

    }
    private static void helper(int[] candidates,int target, int index,List<Integer> path){
        //base
        if(index == candidates.length  || target<0 ) return;
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        helper(candidates, target, index+1,path);
        path.add(candidates[index]);
        helper(candidates, target-candidates[index],index,path);
        path.remove(path.size()-1);
    }
*/
    // Recursive based approach
    /*static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates, target,0,new ArrayList<>());
        return result;

    }
    private static void helper(int[] candidates,int target, int index,List<Integer> path){
        //base
        if(index == candidates.length  || target<0 ) return;
        if(target==0){
            result.add(path);
            return;
        }

        helper(candidates, target, index+1,new ArrayList<>(path));
        path.add(candidates[index]);
        helper(candidates, target-candidates[index],index,new ArrayList<>(path));

    }
*/


  /*  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
List<Integer> preRecordedList;
List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int sum = 0;
            preRecordedList =new ArrayList<>();
            for (int j = 0; j < candidates.length; j++) {

                if( sum+ candidates[j]<target){
                    sum = sum + candidates[j];
                    preRecordedList.add(candidates[j]);
                }
                if(sum == target){
                    result.add(preRecordedList);
                }

            }
        }
        return result;

    }*/

}

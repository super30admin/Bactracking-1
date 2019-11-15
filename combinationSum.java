/* 39. Combination Sum
Time Complexity: 2^n (Exponential time complexity)
Space Complexity: 

Pick a element and choose it multiple time until the target is less than 0. if target == 0 pick this conbination and add to the result list.
Here candidates array does not have a duplicate element. if it has, sort the array, check  if the particular number has been taken or not and try to make a sum of it.
Optimisations to be done- add the candidate to the list only if it is candidate[i] <= target
[2,3,6,7] target = 7
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0);
        // 0 is the index, new ArrayList<>() to store each level
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> temp, int index){
        //Base case
        if(index >= candidates.length || target < 0)
            return;

        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        // i=index is important, if i=0, it gave the duplicate results like [2,2,3] and [2,3,2]
        for(int i=index; i<candidates.length; i++){

            if(candidates[i] <= target){
                temp.add(candidates[i]);
                // index = i, coz we are taking the same element again and again
                backtrack(candidates, target - candidates[i], temp, i);

                //target is not equal to 0, by choosing this element, hence backtrack that is remove the last element that was added
                temp.remove(temp.size() - 1);
            }

        }
    }
}

/* 39. Combination Sum
Time Complexity: 2^n (Exponential time complexity)
Space Complexity: 2^n

Pick a element and choose it multiple time until the sum reaches the target value. if sum == target, pick this value
recursively either choose or dont choose the element to get to the sum.
*/

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> temp, int sum, int index){
        if(sum > target) return;
        if(sum == target)
            result.add(new ArrayList<>(temp));
        else{
            for(int i=index; i<candidates.length; i++){
                if(candidates[i] <= target){
                    temp.add(candidates[i]);
                    backtrack(candidates, target, temp, sum + candidates[i], i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}




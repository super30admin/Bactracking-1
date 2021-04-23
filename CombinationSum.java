//Backtracking
//Time Complexity - O(N^M+1) where N is number of candidates, M is the minimum value in candidates
//Space Complexity - O(T/M) - T is the target - for the recursive call stack

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    backtrack(candidates, tempList, result, target, 0);
    return result;
  }



  public void backtrack(int[] candidates, List<Integer> tempList, List<List<Integer>>  result, int remain, int index){

    if(remain < 0){
      return;
    }
    else if(remain == 0){
      result.add( new ArrayList<>(tempList));
    }else{

      for(int i=index; i<candidates.length; i++){

        tempList.add(candidates[i]);
        backtrack(candidates, tempList, result, remain-candidates[i], i);
        tempList.remove(tempList.size()-1);
      }
    }
  }
}
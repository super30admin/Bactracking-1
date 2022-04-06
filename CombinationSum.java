class CombinationSum {
  /**
   *  Approach - 2
   *     Backtracking
   * 
   * Time Complexity: O(2 ^ ((T/ M) + n ))
   *    T -> target
   *    M -> Minimum element in the input numbers
   *    n -> number of elements in the input.
   * 
   * Space Complexity: 
   */

  List<List<Integer>> result;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      result = new ArrayList<>();
      
      helper(candidates, target, new ArrayList<>(), 0);
      return result;
  }
  
  void helper(int[] candidates, int target, List<Integer> list, int index){
      // base cases
      if( target == 0){
          // save to result
          result.add(new ArrayList<>(list));
          return;
      }
      
      if(target < 0 || index == candidates.length){
          return;
      }
      
      // logic
      
      // pick the element
      list.add(candidates[index]);
      helper(candidates, target - candidates[index], list, index);
      
      list.remove(list.size() - 1);
      
      // do not pick the element
      helper(candidates, target, list, index+1);
  }


  /**
   * Approach - 1:
   * 
   *    For loop based recursion and backtracking.
   * 
   * Time Complexity: O(2 ^ ((T/ M) + n ))
   *    T -> target
   *    M -> Minimum element in the input numbers
   *    n -> number of elements in the input.
   * 
   * Space Complexity: 
   */

  List<List<Integer>> result;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      result = new ArrayList<>();
      
      helper(candidates, target, new ArrayList<>(), 0);
      return result;
  }
  
  void helper(int[] candidates, int target, List<Integer> list, int index){
      // base cases
      if( target == 0){
          // save to result
          result.add(new ArrayList<>(list));
      }
      
      if(target < 0 || index == candidates.length){
          return;
      }
      
      // logic
      for(int i = index; i < candidates.length; i++) {
          // add the current
          list.add(candidates[i]);
          
          // recurse
          helper(candidates, target - candidates[i], list, i);
          
          // backtrack
          list.remove(list.size()-1);
      }
  }
}
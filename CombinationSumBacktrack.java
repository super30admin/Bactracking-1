//Time Complexity - O(n*2^n)
//Space Complexity - O(n)


class Solution {
   List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
      //null case 
      if(candidates == null || candidates.length == 0) {
        return result;
      }
      
      //call recursive function
     helper(candidates, target, 0, new ArrayList<>());
      return result;
    }
  private void helper(int[] candidates, int target, int index, List<Integer> path) {
    //base case
    if(target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }
    if(index == candidates.length || target < 0) {
      return;
    }
    
    //logic
   //not choose 
    helper(candidates, target, index+1, path);
    
    //choose the element
    //add element to the path 
    path.add(candidates[index]);
    helper(candidates, target-candidates[index], index, path);
    path.remove(path.size()-1);
   
  }
}
//Time complexity : Exponential : O(2^n), n is number of candidates
  // Space Complexity : recursive stack space=O(h) where h is height of the recursive tree  

// iterating over the array till the time the remaining target 
//with us is not less than 0 and once we will be having remaining target equal to 0 
// that means we are at a case where we have found the target sum...
//also we will backtrack to find all the possible combinations  
//and again find if there are some other combinations possible such that they sum to the target or not.

 

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        // Arrays.sort(candidates);

        backtrack(candidates,list,new ArrayList<>(),target,0);

        return list;

    }

    public void backtrack(int[] candidates,List<List<Integer>> list,List<Integer> tempList,int remain,int start)

    {
         // exceed the scope, stop exploration.
        if(remain<0) return;
         // if target found and nothing to add remaining, create a copy of the list
        else if(remain==0) list.add(new ArrayList(tempList));
         // logic
        else{

            for(int i=start;i<candidates.length;i++){
                  // add the number to the combination
                tempList.add(candidates[i]);
                  // backtrack
                backtrack(candidates,list,tempList,remain-candidates[i],i);
            
            // remove the number from the combination
               tempList.remove(tempList.size()-1);

            }

        }

    }

}




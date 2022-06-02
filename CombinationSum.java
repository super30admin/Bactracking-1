// O(n*M) time and o(n) space 
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        // Arrays.sort(candidates);

        backtrack(candidates,list,new ArrayList<>(),target,0);

        return list;

    }

    public void backtrack(int[] candidates,List<List<Integer>> list,List<Integer> tempList,int remain,int start)

    {

        if(remain<0) return;

        else if(remain==0) list.add(new ArrayList(tempList));

        else{

            for(int i=start;i<candidates.length;i++){

                tempList.add(candidates[i]);

                backtrack(candidates,list,tempList,remain-candidates[i],i);

                tempList.remove(tempList.size()-1);

            }

        }

    }

}

/*
The time complexity of the problem is O(2^n) and the space complexity is O(n)
The intuition here is to make a choice whether to take a number or not. If taken how many times can we take it to get our required sum

Yes, the solution passed all the test cases in leet code.
First, it did not include the start variable in combinationCheck method and iterated from 0 to candidates.length every time. In this case
for the required sum=6, we produce duplicate combintions. Then I realized we can actually use start which will eleminate our problem
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        if(candidates.length==0){return ret;}
        combinationCheck(candidates,ret,new ArrayList<>(),target,0);
        return ret;

    }

    public void combinationCheck(int[] candidates,List<List<Integer>> retList, List<Integer> list,int remaining, int start){

        if(remaining<0){return;}
        if(remaining==0){
            retList.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>remaining){continue;}
            else{
                list.add(candidates[i]);
                combinationCheck(candidates,retList,list,remaining-candidates[i],i);
                int listLength = list.size();
                list.remove(listLength-1);
            }
        }
    }
}
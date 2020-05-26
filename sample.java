Problem-1: Combination sum
TC= O(2^n) where n is the num of elements in the array
SC= O(2^h)
/** Recursive solution: Where we can make two choices on the cur element in the candidate array. Either we choose it or pass it. If chosen, add the candidate number to the current sum and continue to choose it again if the sum is less target. If not choosing, skip the element and move to other elements in the candidate array. Once, the current sum of the candidate number reaches the target or we have iterated all the elements, recursion is stopped. 
*/
class Solution {
    List<List<Integer>> result;
    int targetToReach;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> curListOfCandidates = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        targetToReach = target;
        
        result = new ArrayList<>();
        recurseOnCandidates(candidates, curListOfCandidates, 0, 0); 
        
        return result;
        
    }
    
    private void recurseOnCandidates(int[] candidates, List<Integer> curListOfCandidates, int curSum, int curCandidateIndex){
        //base
        if(curCandidateIndex == candidates.length) return;
        if(curSum > targetToReach ) return;
        //logic
        if(curSum == targetToReach){
            result.add(curListOfCandidates);
            return;
        }
        //recurse
        //not choosing a candidate
        recurseOnCandidates(candidates, new ArrayList<>(curListOfCandidates),curSum, curCandidateIndex+1);
        //choosing a candidate
        curListOfCandidates.add(candidates[curCandidateIndex]);
        recurseOnCandidates(candidates, new ArrayList<>(curListOfCandidates), curSum+candidates[curCandidateIndex],curCandidateIndex);
    }
}
// converted previous recursive solution to backtrack
Problem-1: Combination sum
TC= O(2^n)  where n is the number of elements
SC=O(target/min(n) n is the smallest number in the array
/** Recursive solution: Where we can make two choices on the cur element in the candidate array. Either we choose it or pass it. If chosen, add the candidate number to the current sum and continue to choose it again if the sum is less target. If not choosing, skip the element and move to other elements in the candidate array. Once, the current sum of the candidate number reaches the target or we have iterated all the elements, recursion is stopped. 
*/
class Solution {
    List<List<Integer>> result;
    int targetToReach;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> curListOfCandidates = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        targetToReach = target;
        
        result = new ArrayList<>();
        recurseOnCandidates(candidates, curListOfCandidates, 0, 0); 
        
        return result;
        
    }
    
    private void recurseOnCandidates(int[] candidates, List<Integer> curListOfCandidates, int curSum, int curCandidateIndex){
        //base
        if(curCandidateIndex == candidates.length) return;
        if(curSum > targetToReach ) return;
        //logic
        if(curSum == targetToReach){
            result.add(new ArrayList<>(curListOfCandidates));
            return;
        }
        //recurse
        //not choosing a candidate
        recurseOnCandidates(candidates, curListOfCandidates,curSum, curCandidateIndex+1);
        //choosing a candidate
        curListOfCandidates.add(candidates[curCandidateIndex]);
        recurseOnCandidates(candidates, curListOfCandidates, curSum+candidates[curCandidateIndex],curCandidateIndex);
        
        curListOfCandidates.remove(curListOfCandidates.size()-1);
        
        
    }
}
Problem-1: Combination sum
TC= O(2^n)  where n is the number of elements
SC=O(target/min(n) n is the smallest number in the array
// Backtracking solution using for loop pattern.
class Solution {
    List<List<Integer>> result;
    int targetToReach;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> listOfCandidates = new ArrayList<>();
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        targetToReach=target;
        int curSUm = 0;
        int curCandidateIndex=0;
        
        backtrackOnCandidates(candidates,curSUm,listOfCandidates,curCandidateIndex);
        
        return result;
    }
    
    private void backtrackOnCandidates(int[] candidates, int curSum, List<Integer> listOfCandidates,int curCandidateIndex){
        
        //base
        if(curSum == targetToReach){
            result.add(new ArrayList<>(listOfCandidates));
            return;
        }
        if(curSum > targetToReach) return;
        //recurse & logic
            for( int i=curCandidateIndex; i<candidates.length; i++){
                
                listOfCandidates.add(candidates[i]);
                backtrackOnCandidates(candidates,curSum+candidates[i],listOfCandidates,i);
                //backtrack: undoing the last decision
                listOfCandidates.remove(listOfCandidates.size()-1);
            }

        
    }
}
Problem-2: Expression Add operators
TC= O(4^n)
SC= O(4^n)
class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ=target;
        if(num == null || num.length() == 0) return result;
        
        helper(num,"",0,0,0); // num string, cur Opertor+path, current sum, tail of the last calculation, and current index
        
        return result;
        
    }
    
    
    private void helper(String num, String path, long curCalculation, long tail, int index){
        //base
        if(index == num.length()){
            if(curCalculation==targ){
                result.add(path);
                return;
            }
        }

        
        
        //logic & recurse
        
        for(int i=index; i<num.length(); i++){
            if(index != i && num.charAt(index) == '0') break; // when it is not the first index and 0 is encountered
            long cur = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(num, path+cur,cur,cur,i+1);
            }else{
                helper(num, path+"+"+cur,curCalculation+cur,cur,i+1);
                helper(num, path+"-"+cur,curCalculation-cur,-cur,i+1);
                helper(num, path+"*"+cur,curCalculation-tail+tail*cur,tail*cur,i+1);
            }
            
            
        }
        
    }
}

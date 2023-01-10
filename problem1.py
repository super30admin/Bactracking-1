#time complexity: O(N^target/min(candidates))
#space complexity: O(target/min(candidates))
#ran on leetcode: Yes
#Do a DFS backtracking. Lopp through all elements in candidate. Add each element to a intermediate list that is passed thorughn recursion parameters and perform a recusrsion. Now remove this element from the list and perform a recusrion. Inbase condition, if there are no more elements to pick then check if the sum that is obtained so far is equal to target. If it is, then add that intermediate list to final result(as a deep copy). return.
class Solution:
    def recurse(self,candidates,s,result,target,index):
        if(s==target):
            #print(result)
            self.ans.append(result[:])
            return
        if(s>target):
            return
        for i in range(index,len(candidates)):
            result.append(candidates[i])
            self.recurse(candidates,s+candidates[i],result,target,i)
            del(result[-1])
            #target-=i

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans=[]
        self.recurse(candidates,0,[],target,0)
        return self.ans

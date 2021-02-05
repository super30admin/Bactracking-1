#Time complexity:Exponential
#Space complexity:Exponential

class Solution:
    global result																				#declaring a result array that is global
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]																			#initialize result to be empty
        if len(candidates)==0:																	#if the candidates is empty return result
            return self.result
        self.helper(candidates,0,[],target)														#call recursive function
        return self.result																		#return the result array
    
    def helper(self,candidates: List[int], i:int ,path:List[int], target: int)->None:
        if i==len(candidates) or target<0:														#if the target is lower than 0 or i is greater than length of candidates return
            return
        if target==0:																			#when target is reached append the path to result array and return
            self.result.append(path.copy())
            return
        self.helper(candidates,i+1,path,target)													#call rescursive function when element not chosen
        path.append(candidates[i])																#add element i to path (choosing)
        self.helper(candidates,i,path,target-candidates[i])										#call recursuive function when element is chosen
        path.pop()	                                                                            #backtrack by removing last element

#approach 2

class Solution:
    global result
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        if len(candidates)==0:
            return self.result
        self.helper(candidates,0,[],target)
        return self.result
    
    def helper(self,candidates: List[int], index:int ,path:List[int], target: int)->None:
        if target<0:
            return
        if target==0:
            self.result.append(path.copy())
            return
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,i,path,target-candidates[i])
            path.pop()																		
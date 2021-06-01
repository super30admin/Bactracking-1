from typing import  List


class Solution:
   #Space:- o(h)
   #Time:-2N

   def combinationSum_NON_back(self, candidates: List[int], target: int) -> List[List[int]]:
       self.result = []
       if not candidates or len(candidates) == 0: return self.result

       def backtrack(target: int, index: int, path: List[int]) -> None:
           # base
           if target == 0:
               temp = path.copy()
               self.result.append(path)
               return
           if index == len(candidates) or target < 0:
               return
               # not choose
           backtrack(target=target, index=index + 1, path=path.copy())
           # choose
           path.append(candidates[index])
           backtrack(target=target - candidates[index], index=index, path=path.copy())
           # path.pop()

       backtrack(target=target, index=0, path=[])
       return self.result

   def combinationSum_NFor(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        if not candidates or len(candidates) == 0: return self.result
        def backtrack( target: int, index: int, path: List[int]) -> None:
            # base
            if target==0:
                temp=path.copy()
                self.result.append(temp)
                return
            if index>= len(candidates) or target< 0:
                return
            # not choose
            backtrack(target=target,index=index+1,path=path)
            # choose
            path.append(candidates[index])
            backtrack(target=target-candidates[index],index=index,path=path)
            path.pop()


        backtrack(target=target,index=0,path=[])
        return self.result

   def combinationSumwfor(self, candidates: List[int], target: int) -> List[List[int]]:
       self.result = []
       if not candidates or len(candidates) == 0: return self.result

       def backtrack(target: int, index: int, path: List[int]) -> None:
        
           if target == 0:
               temp = path.copy()
               self.result.append(temp)
               return
           if target < 0:
               return
           for idx in range(index, len(candidates)):
               path.append(candidates[idx])
               backtrack(target=target - candidates[idx], index=idx, path=path)
               path.pop()

       backtrack(target=target, index=0, path=[])
       return self.result




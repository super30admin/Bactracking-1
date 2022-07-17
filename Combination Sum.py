# time complexity is o(2^(target/min + n)), where n size of the input, min is the minimum element in the input
# space complexity is o(2^(target/min + n)), where n size of the input, min is the minimum element in the input, (Recursive stack space)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = list()
        sums = 0 
        self.helper(candidates, target, [], 0, sums, result)
        return result
    def helper(self, candidates, target, temp, index, sums, result):
        if(sums == target):
            result.append(temp.copy())
            return
        if(sums > target):
            return
        for i in range(index, len(candidates)):
            temp.append(candidates[i])
            self.helper(candidates, target, temp, i, sums + candidates[i], result)
            temp.pop()
            
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
#         result = set()
#         pq = list()
#         d = dict()
#         for i in candidates:
#             if(i not in d):
#                 d[i] = True
        
#         for i in candidates:
#             ll = list()
            
#             if(target < i):
#                 continue
#             if(target == i):
#                 pq.append(i)
#                 print(pq)
#                 continue
#             else:
#                 j = 0
#                 k = target // i
#                 kk = k
#                 m = target % i
#                 while(k > 0):
#                     l = list()
#                     j += i
#                     if(target- j in d):
#                         n = j
#                         while(n):
#                             l.append(i)
#                             n -= i
#                         l.append(target - j)
#                         l.sort()
#                         result.add(tuple(l))
#                     # del d[target - j]
                    
#                     if(m==0):
#                         ll.append(i)
#                     k -= 1
#                 if(len(ll)!=0):
#                     result.add(tuple(ll))
                    
#         fr = list(result)
#         # ÷\print('pq len is',len(pq))
#         if(len(pq)>0):
#             fr.append(pq)
#             print(fr)
              
#         return fr
                    
                


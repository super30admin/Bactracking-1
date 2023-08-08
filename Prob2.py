class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]
        
        #Method 1 - 0/1 recrusion using deepcopy - TC -2^(m*n), 
        #if deep copy not done, same reference be used and in the end path will have 0 element and so will res array. So, make a deepcopy whenever making a decision.

        def helper(candidates,i,target,path):
            #base
            if target<0 or i==len(candidates): return 
            if target==0:
                res.append(path)
                return
            #logic
            #notchoose
            helper(candidates,i+1,target,copy.deepcopy(path)) 

            #choose
            path.append(candidates[i])
            helper(candidates,i,target-candidates[i],copy.deepcopy(path))
        helper(candidates,0,target,[])
        return res

        #Above, if you want to do choose first and then not choose, you can't do it directly, cause path would have been updated and deepcopy of the same path will be passed. So, need to deepcopy path and name it as li and add cadidates[i] to li and send li in the choose fucntion call. Below, is how it should look.
            # #choose
            # li=copy.deepcopy(path)
            # li.append(candidates[i])
            # helper(candidates,i,target-candidates[i],li)
            # #not choose        
            # helper(candidates,i+1,target,copy.deepcopy(path)) 

        #Method 2 - 0/1 recrusion using backtrack - TC -2^(m*n)

        # def helper(candidates,i,target,path):
        #     #base
        #     if target<0 or i==len(candidates): return 
        #     if target==0:
        #         res.append(copy.deepcopy(path)) #need to make a deepcopy and then add else in the end path will be empty and so will res.
        #         return
        #     #logic
        #     #notchoose
        #     helper(candidates,i+1,target,path)

        #     #choose
        #     #ACTION
        #     path.append(candidates[i])
        #     #RECURSE
        #     helper(candidates,i,target-candidates[i],path)
        #     #BACKTRACK
        #     path.pop()

        # helper(candidates,0,target,[])
        # return res

        #Method 3 - For loop recursion with backtracking
        # def helper(candidates,pivot,target,path):
        #     #base
        #     if target<0 or pivot==len(candidates): return 
        #     if target==0:
        #         res.append(copy.deepcopy(path))

        #     #logic
        #     for i in range(pivot,len(candidates)):
        #         #action
        #         path.append(candidates[i])
        #         #recruse
        #         helper(candidates,i,target-candidates[i],path)
        #         #backtrack
        #         path.pop()
        # helper(candidates,0,target,[])
        # return res
    
        #Method 4 - For loop recursion with deepcopy
        # def helper(candidates,pivot,target,path):
        #     #base
        #     if target<0 or pivot==len(candidates): return 
        #     if target==0:
        #         res.append(path)

        #     #logic
        #     for i in range(pivot,len(candidates)):
        #         li=copy.deepcopy(path)
        #         li.append(candidates[i])
        #         helper(candidates,i,target-candidates[i],li)
                
        # helper(candidates,0,target,[])
        # return res

        #If asked for permutation -> all possible combination here order doesn't matter.
        
        #Method 1 - Using For loop recrusion
        #Here, run for loop from 0 to n each time -> remove pivot everywhere
        # def helper(candidates,target,path):
        #     #base
        #     if target<0: return 
        #     if target==0:
        #         res.append(copy.deepcopy(path))

        #     #logic
        #     for i in range(len(candidates)):
        #         #action
        #         path.append(candidates[i])
        #         #recruse
        #         helper(candidates,target-candidates[i],path)
        #         #backtrack
        #         path.pop()
        # helper(candidates,target,[])
        # return res
        
        #Method 2 - Using 0/1 recrusion
        #Here, run for loop from 0 to n each time in choose situation
        # def helper(candidates,i,target,path):
        #     #base
        #     if target<0 or i==len(candidates): return 
        #     if target==0:
        #         res.append(copy.deepcopy(path)) #need to make a deepcopy and then add else in the end path will be empty and so will res.
        #         return
        #     #logic
        #     #notchoose
        #     helper(candidates,i+1,target,path)

        #     #choose
        #     #ACTION
        #     path.append(candidates[i])
        #     #RECURSE
        #     helper(candidates,0,target-candidates[i],path)
        #     #BACKTRACK
        #     path.pop()

        helper(candidates,0,target,[])
        return res

        
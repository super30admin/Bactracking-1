#code using for loop based recursion and backtracking
#TC:O(2^(m-1))
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return result
        def helper(candidates,target,idx,path):
            #base
            if target==0: 
                res.append(path[:])
                return
            if target<0: return
            #logic
            for i in range(idx,len(candidates)):
                #action
                path.append(candidates[i])
                
                #recursion
                helper(candidates,target-candidates[i],i,path)
                #backtrack
                path.pop() 
        
        helper(candidates,target,0,[])
        return res
'''
#code using for loop based recursion
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return result
        def helper(candidates,target,idx,path):
            #base
            if target==0: 
                res.append(path)
                return
            if target<0: return
            #logic
            for i in range(idx,len(candidates)):
                #action
                li=path[:]
                li.append(candidates[i])
                #recursion
                helper(candidates,target-candidates[i],i,li)
              
        
        helper(candidates,target,0,[])
        return res

'''


#TC:2^(target divided my min number + n)
#SC:O()
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return
        def helper(candidates,target,i,path):
            #base
            if target==0: 
                res.append(path[:])
                return
            if i==len(candidates) or target<0: return
            #logic
            
            #choose
            path.append(candidates[i])
            helper(candidates,target-candidates[i],i,path)
            path.pop()
            #no choose
            helper(candidates,target,i+1,path)
        
        helper(candidates,target,0,[])
        return res

#code for taking nochoose case first.
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return
        def helper(candidates,target,i,path):
            #base
            if target==0: 
                res.append(path[:])
                return
            if i==len(candidates) or target<0: return
            #logic
            #no choose
            helper(candidates,target,i+1,path)
            #choose
            path.append(candidates[i])
            helper(candidates,target-candidates[i],i,path)
            path.pop()
        
        helper(candidates,target,0,[])
        return res
    
'''
#brutforce meathod with out using the backtracking.
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return
        def helper(candidates,target,i,path):
            #base
            if target==0: 
                res.append(path)
                return
            if i==len(candidates) or target<0: return
            #logic
            #no choose
            helper(candidates,target,i+1,path[:])
            #choose
            path.append(candidates[i])
            helper(candidates,target-candidates[i],i,path[:])
            
        
        helper(candidates,target,0,[])
        return res
'''
#brutforce meathod with out using the backtracking with choose as first case
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        if candidates==None or len(candidates)==0: return
        def helper(candidates,target,i,path):
            #base
            if target==0: 
                res.append(path)
                return
            if i==len(candidates) or target<0: return
            #logic
            
            #choose
            li=path[:]
            li.append(candidates[i])
            helper(candidates,target-candidates[i],i,li)
            #no choose
            helper(candidates,target,i+1,path[:])
            
        
        helper(candidates,target,0,[])
        return res
'''
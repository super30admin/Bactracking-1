
# Solution

# // Time Complexity : Exhaustive Approach - O(p*(2^(m+n))), m is target/minCandidate, n is size of candidates. 2^(m+n)Since just 
#                                            like coin change, for each candidate we can decide if we need to consider that 
#                                            candidate or not. And since we need to save all paths, for each path we will have to 
#                                            copy the list into result causing the p* for 2^(m+n), p will be number of paths
# // Space Complexity : O(2^(m+n)) for both exhaustive and for loop based recursion. Since that is the max height we go and there
#                       will be implicit stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Exhaustive Approach - We have two paths, one is to choose a candidate or we do not choose a candidate. If we choose a
#                       candidate then reduce that value from target and make one of the choices again, if we do not choose
#                       a candidate then increase the index and make one of the choices for next candidate. Use recursion to explore
#                       both choices and in the end of any choice if we get target = 0 then add that path to result. If we get
#                       target<0 then ignore that path.
# 
# For Loop based recursion Approach - In overall sense this exactly mimics the exhaustive recursion, only difference is we are using 
#                                     for loop to achieve part of the requirement. Also the way it traverses is bit different,
#                                     this is more close to DFS and complete recursion solution is more close to BFS/DFS based on
#                                     whether we called he chose recursion first or not chose recursion first. Basically here,
#                                     always choose is done for each element first, and once choose is done, not choose gets handled
#                                     by moving for loop by an index

def combinationSum(candidates,target):
# For loop based recursion solution
        result = []    
        def helper(candidates,target,path,pivot,result):
            if target<0:
                return None
            if target == 0:
                result.append(path.copy())
                return
            
            for j in range(pivot,len(candidates)):
                path.append(candidates[j])
                helper(candidates,target-candidates[j],path,j,result)
                path.pop()
            
            return None
        
        helper(candidates,target,[],0,result)

        return result       
    # Exhaustive recursive solution
    # def helper(candidates,index,target,path,result):
    #     if index>=len(candidates) or target<0:
    #         return
        
    #     if target == 0:
    #         result.append(path.copy())
    #         return

    #     path.append(candidates[index])
    #     helper(candidates,index,target-candidates[index],path,result)
    #     path.pop()
    #     helper(candidates,index+1,target,path,result)
    
    # result = []
    # helper(candidates,0,target,[],result)

    # return result

if __name__ == "__main__":
     candidates = [2,3,6,7]
     target = 7
     print(combinationSum(candidates,target))
# Time Complexity : O(4^n), 
# Space Complexity : o(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
	
        res = []
		
        def backtrack(num, path, trace):
            nonlocal res
			
            if not num:
                if sum(trace) == target: res.append(path)
                return
			
            curr, i, rlim = 0, 0, len(num) if num[0] != '0' else 1
			
            while i < rlim:
			
                curr = curr*10 + int(num[i])
                i += 1
				
                if trace:
                    backtrack(num[i:], path+'+'+num[:i], trace+[curr])
                    backtrack(num[i:], path+'-'+num[:i], trace+[-curr])
                    backtrack(num[i:], path+'*'+num[:i], trace[:-1]+[curr*trace[-1]])
					
                else:
                    backtrack(num[i:], num[:i], [curr])
					
        backtrack(num, '', [])
        return res
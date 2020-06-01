#Time Complexity: O(N2^N) where N is number of elements in staring 
# Space Complexity : O(N) where N is number of elemtns stored in stack
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result = []
        if len(s) == None:
            return result
        
        def backtrack(s,temp ,start):
            def palindrome(s,l,r):
                if l ==r:
                    return True
                while l<r:
                    if s[l]!=s[r]:
                        return False
                    l+=1 
                    r-=1
                return True
            
            if start == len(s):
                result.append(temp[:])
               
            for i in range(start,len(s)):
                if (palindrome(s,start,i)) == True:
                    temp.append(s[start:i+1])
                    backtrack(s,temp,i+1)
                    temp.pop()
        temp = []        
        backtrack(s,temp,0)
        return result

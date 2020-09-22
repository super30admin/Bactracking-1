
# Time Complexity : O(n*(3^n))
# Space Complexity : O(n)  recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        #"1+2-1+2*4*5"
        #1. total = 1
        # total += 2 = 3
        # total -= 1 = 2
        # total += 2 = 4
        # total = total - 2(prev) + 2(prev) * 4  store prev_add for multiplaction
        #total = total - 2*4 + 2*4*5 
        
        #2. handle the base case where no operator is present
        
        #3. handle 00 case (no significance of 00)
        
        #4. handle concatenation using for loop
        
        
        
        output = []
        
        def dfs(expr, index, total, prev_add):
            #print expr
            if index == len(num) and total == target:
                output.append(expr)
            
            #step 4
            for j in range(index+1, len(num)+1):
                strr = num[index:j]
                #print 'here', expr
                #print index, j , strr, expr
                number = int(strr)
                #print strr, index, j
                # step 3 strr should have 0 in front else if 0 is coming between like 1*05 don't execute
                if num[index] == '0' and strr != '0':
                    continue
                #print 'here'
                
                #strp 2
                if not expr:
                    dfs(strr, j, number, number)
                else:
                    #step1 for +
                    dfs(expr + '+' + strr, j, total + number, number)
                    #step1 for - 
                    dfs(expr + '-' + strr, j, total - number, -number)
                    #step1 for *
                    dfs(expr + '*' + strr, j, total - prev_add + prev_add * number, prev_add * number)
        
        
        
        dfs('', 0, 0, 0)
        return output
        
#Time Complexity - O(2^n)
#Space Complexity - O(n)
class Solution:
    def addOperators(self, nums: str, t: int) -> List[str]:
        result = []

        def explore(prev, index, target, string):
            nonlocal result
            if target == t and index == len(nums):
                s = ''
                for x in string:
                    s += str(x)
                result.append(s)
                return 
            
            if index == len(nums):
                return 

            #recursion
            curr = 0
            for i in range(index, len(nums)):
                curr = (curr * 10) + int(nums[i])
                if string == []:
                    string.append(curr)
                    explore(curr, i + 1, curr, string)
                    string.pop()
                    
                else:
                    #add
                    string.append("+")
                    string.append(curr)
                    explore(curr, i + 1, int(target) + curr, string)
                    string.pop()
                    string.pop()
                    #sub
                    string.append("-")
                    string.append(curr)
                    explore(-1 * curr, i + 1, int(target) - curr, string)
                    string.pop()
                    string.pop()
                    #mul
                    string.append("*") 
                    string.append(curr)
                    explore(prev * curr ,i + 1, target - prev + prev * curr, string)
                    string.pop()
                    string.pop()

                if curr == 0:
                    break
        
        explore(0, 0, 0, [])
        return result
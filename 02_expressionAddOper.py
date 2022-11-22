#TC: 4 ^ n where n is the number of digits and since we allow 4 possible combinations for each digit ie +, -, * and None
#SC: 4 ^ n

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:

        n = len(num)
        answer = set()

        def dfs(index,total, path, tail):
            if index == n and total == target:
                answer.add(path)

            if index >= n:
                return
            
            for i in range(index, len(num)):
                #2nd condition checks if there is leading 0 ie 05
                if len(num[index:i+1]) > 1 and num[index:i+1][0] == "0":
                    continue
                    
                curr = num[index:i+1]
                
                if tail == "":
                    dfs(i + 1, int(curr), curr, curr)
                else:
                    # addition
                    dfs(i + 1,total + int(curr), path + "+" + curr, curr)
                    
                    # subtraction
                    dfs(i + 1,total - int(curr), path + "-" + curr, "-" + curr)
                    
                    # multiplication
                    dfs(i + 1, total-int(tail) + (int(tail) * int(curr)), path + "*" + curr, str(int(curr) * int(tail)))

        dfs(0,-1,"", "")
        
        return answer
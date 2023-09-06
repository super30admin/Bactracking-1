class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        # need to traverse through s
        # backtrack each case of  start index and then +,*,-
        # need empty array ofcourse
        # need curidx = i
        # need the str path to append to the arr if my --> cur_num == target
        # need the prevNum access for multiplication
        # 1 2 3 4 5 --> 1 + 2 + 3 + 4 * 5
        #               ^ ^ ^ ^ ^ ^ ^ == 10 but we wanna do 4*5 so ---
        # just do 1 + 2 + 3 + 4 + (- 4) + (4 * 5)
        # return ans
        
        res = []

        def dfs(i, path, cur_num, prevNum):
            if i == len(num):
                if cur_num == target:
                    res.append(path)
                return
            
            for j in range(i, len(num)):
                # starting with zero?
                if j > i and num[i] == '0':
                    break
                n = int(num[i:j+1])

                # if cur index is 0 then simple add that number
                if i == 0:
                    dfs(j + 1, path + str(n), cur_num + n, n)
                else:
                    dfs(j + 1, path + "+" + str(n), cur_num + n, n)
                    dfs(j + 1, path + "-" + str(n), cur_num - n, -n)
                    dfs(j + 1, path + "*" + str(n), cur_num - prevNum + prevNum * n, prevNum * n)
        
        dfs(0, "", 0, 0)
        return res
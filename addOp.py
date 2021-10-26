class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        if num is None or len(num ) ==0:
            return result
        def helper(num, ind, calc,tail,path):
            #base
            if ind == len(num):
                if calc == target:
                    print(path)
                    result.append(path)
                
            #logic
            for i in range( ind, len(num)):
                
                # for case 105, avoid forming 05 as 1 * 05 -> 1 * 5, which is incorrect
                if num[ind] == "0" and ind != i:
                    continue
                
                # form substring
                cur = int(num[ind: i +1 ])
                if ind == 0:
                    helper(num, i + 1,cur,cur, path + str(cur))
                else:
                    # +
                    # calc = calc + cur
                    # tail = cur
                    helper(num, i + 1,calc +  cur,cur, path + "+" + str(cur))
                    
                    # -
                    helper(num, i + 1,calc - cur,-cur, path + "-" + str(cur))
                    
                    # *
                    helper(num, i + 1,(calc - tail) + (tail * cur)  ,tail * cur, path + "*" + str(cur))
                    
        helper(num, 0,0,0, "")
        return result

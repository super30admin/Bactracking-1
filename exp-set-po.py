class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []

        # for i in num:
        #     lis.append()
        def recc(num, cal, tail, i, path):
            # print(num,cal,tail,i,path)
            if i == len(num):
                if cal == target:
                    result.append(path)
                    # print(result)
            for index in range(i, len(num)):
                # print(index)
                # print(i)
                # print('va',num[index:i+1])
                # if num[index:i+1]=='':
                #     continue

                curr = int(num[i:index + 1])
                if i != index and num[i] == '0':
                    continue
                # print(curr)
                if i == 0:
                    recc(num, curr, curr, index + 1, path + str(curr))
                else:
                    recc(num, cal + curr, +curr, index + 1, path + '+' + str(curr))
                    # -
                    recc(num, cal - curr, -curr, index + 1, path + '-' + str(curr))
                    # *
                    recc(num, cal - tail + (tail * curr), tail * curr, index + 1, path + '*' + str(curr))

        recc(num, 0, 0, 0, '')
        return result
    # recc-time,space-4**n
    # in bac-time-4**n but one one -O(N)
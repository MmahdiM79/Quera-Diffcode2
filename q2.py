# by Sevda Imany




def goodnum(num: int):
    goodnumber = 0;
    for i in range(1,num + 1):
        goodnumber += i

    return goodnumber

    

def maghsumHa(num: int):
    count = 0
    for i in range(1,num+1):
        if num % i == 0:
            count += 1

    return count


def findGoodNum(num):
    i = 1;
    while(True):
        goodnumber = goodnum(i)
        ans = maghsumHa(goodnumber)
        if ans >= num:
            return goodnumber 
        i +=1
        


num = input()
num = int(num)


print(findGoodNum(num))

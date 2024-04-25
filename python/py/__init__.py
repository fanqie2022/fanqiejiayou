import math as m
a = int(input(1))
b = int(input(2))
c = int(input(3))
ac = 1/2*(a+b+c)
print("此三角形面积为:",m.sqrt(ac*(ac-a)*(ac-b)*(ac-c)))   #sqrt开方函数

for x in range(1,10):
    for y in range(1,x+1):
        print(y,"*",x,"=",x*y,"",end="")
    print("")
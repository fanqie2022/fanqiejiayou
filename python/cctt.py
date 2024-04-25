from math import sqrt
#取2的n次方，n由用户输入
n = int(input('n = '))
x = 1
while x <= n:
    x *= 2
    print(x)
    #如�态
    if x > sqrt(n):
        break

#如����
print('Done')




#求圆周率到小数点后100位
pi = 0
N = 100
for k in range(N):
    pi += 1/pow(16,k)*(4/(8*k+1)-2/(8*k+4)-1/(8*k+5)-1/(8*k+6))
    print('k = {}, pi = {}'.format(k,pi))

#如����
print('Done')


#求圆周率到小数点后1000位
pi = 0
N = 1000
for k in range(N):
    pi += 1/pow(16,k)*(4/(8*k+1)-2/(8*k+4)-1/(8*k+5)-1/(8*k+6))
    print('k = {}, pi = {}'.format(k,pi))
    #如����
    print('Done')

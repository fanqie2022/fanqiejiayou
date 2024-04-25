m = input()
n = input()
if len(m) > len(n):
    i = len(m)
else :
    i = len(n)
print(i)
s1 = list(m)
s2 = list(n)
while i > 0:
    #print(s1[1])
    if s1 != s2:
        print(ord(s1[i]))
        print(ord(s2[i]))
        #c = s2[j] - s1[j]

    i = i - 1
#print(c)
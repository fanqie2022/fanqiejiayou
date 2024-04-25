import random
def c(y):

    for i in range(y):
        x = random.uniform(35.5,36.5)
        print(round(x, 1))
    print("\n")
q = int(input("需填写体温人数："))
y = int(input("填写数量："))
for j in range(q):
    c(y)
print("请复制后到excel转置，谢谢")
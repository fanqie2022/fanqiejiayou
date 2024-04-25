t = 0
for x in range(1,9):
    for y in range(1,11):
        for z in range(1,13):
            if 50 - (x * 6 + y * 5 + z * 4) == 0:
                t = t + 1
                print("第",t,"种组合:分别为",x,y,z)
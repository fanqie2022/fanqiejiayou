import turtle as t
import math as m
import random as r
import pygame as p

#背景音乐
file = r'D:/ppp/Face recognition to make small games/Music/奔赴星空_尹昔眠_小田音乐社__高音质在线试听_奔赴星空歌词-歌曲下载_酷狗音乐.mp3'
p.mixer.init()
sf = p.mixer.music.load(file)
p.mixer.music.play()

def drawX(a, i):
    angle = m.radians(i)
    return a * m.cos(angle)

def drawY(b, i):
    angle = m.radians(i)
    return b * m.sin(angle)


# 设置背景颜色，窗口位置以及大小
t.bgcolor("#d3dae8")
t.setup(1000, 800)
t.penup()
t.goto(150, 0)
t.pendown()
# 1
t.pencolor("white")
t.begin_fill()
for i in range(360):
    x = drawX(150, i)
    y = drawY(60, i)
    t.goto(x, y)
t.fillcolor("#fef5f7")
t.end_fill()
# 2
t.begin_fill()
for i in range(180):
    x = drawX(150, -i)
    y = drawY(70, -i)
    t.goto(x, y)
for i in range(180, 360):
    x = drawX(150, i)
    y = drawY(60, i)
    t.goto(x, y)
t.fillcolor("#f2d7dd")
t.end_fill()
# 3
t.pu()
t.goto(120, 0)
t.pd()
t.begin_fill()
for i in range(360):
    x = drawX(120, i)
    y = drawY(48, i)
    t.goto(x, y)
t.fillcolor("#cbd9f9")
t.end_fill()
# 4
t.begin_fill()
t.pencolor("#fee48c")
for i in range(540):
    x = drawX(120, i)
    y = drawY(48, i) + 70
    t.goto(x, y)
t.goto(-120, 0)
t.fillcolor("#cbd9f9")
t.end_fill()
# 5
t.pu()
t.goto(120, 70)
t.pd()
t.pencolor("#fff0f3")
t.begin_fill()
for i in range(360):
    x = drawX(120, i)
    y = drawY(48, i) + 70
    t.goto(x, y)
t.fillcolor("#fff0f3")
t.end_fill()
# 6
t.pu()
t.goto(110, 70)
t.pd()
t.pencolor("#fff9fb")
t.begin_fill()
for i in range(360):
    x = drawX(110, i)
    y = drawY(44, i) + 70
    t.goto(x, y)
t.fillcolor("#fff9fb")
t.end_fill()
# 7
t.pu()
t.goto(120, 0)
t.pd()
t.begin_fill()
t.pencolor("#ffa79d")
for i in range(180):
    x = drawX(120, -i)
    y = drawY(48, -i) + 10
    t.goto(x, y)
t.goto(-120, 0)
for i in range(180, 360):
    x = drawX(120, i)
    y = drawY(48, i)
    t.goto(x, y)
t.fillcolor("#ffa79d")
t.end_fill()
# 8
t.pu()
t.goto(120, 70)
t.pd()
t.begin_fill()
t.pensize(4)
t.pencolor("#fff0f3")
for i in range(1800):
    x = drawX(120, 0.1 * i)
    y = drawY(-18, i) + 10
    t.goto(x, y)
t.goto(-120, 70)
t.pensize(1)
for i in range(180, 360):
    x = drawX(120, i)
    y = drawY(48, i) + 70
    t.goto(x, y)
t.fillcolor("#fff0f3")
t.end_fill()
# 9
t.pu()
t.goto(80, 70)
t.pd()
t.begin_fill()
t.pencolor("#6f3732")
t.goto(80, 120)
for i in range(180):
    x = drawX(80, i)
    y = drawY(32, i) + 120
    t.goto(x, y)
t.goto(-80, 70)
for i in range(180, 360):
    x = drawX(80, i)
    y = drawY(32, i) + 70
    t.goto(x, y)
t.fillcolor("#6f3732")
t.end_fill()
# 10
t.pu()
t.goto(80, 120)
t.pd()
t.pencolor("#ffaaa0")
t.begin_fill()
for i in range(360):
    x = drawX(80, i)
    y = drawY(32, i) + 120
    t.goto(x, y)
t.fillcolor("#ffaaa0")
t.end_fill()
# 11
t.pu()
t.goto(70, 120)
t.pd()
t.pencolor("#ffc3be")
t.begin_fill()
for i in range(360):
    x = drawX(70, i)
    y = drawY(28, i) + 120
    t.goto(x, y)
t.fillcolor("#ffc3be")
t.end_fill()
# 12
t.pu()
t.goto(80, 120)
t.pd()
t.begin_fill()
t.pensize(3)
t.pencolor("#ffaaa0")
for i in range(1800):
    x = drawX(80, 0.1 * i)
    y = drawY(-12, i) + 80
    t.goto(x, y)
t.goto(-80, 120)
t.pensize(1)
for i in range(180, 360):
    x = drawX(80, i)
    y = drawY(32, i) + 120
    t.goto(x, y)
t.fillcolor("#ffaaa0")
t.end_fill()
# 13
t.pu()
t.goto(64, 120)
t.pd()
t.pencolor("#b1c9e9")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) + 60
    y = drawY(1, i) + 120
    t.goto(x, y)
t.goto(64, 170)
for i in range(540):
    x = drawX(4, i) + 60
    y = drawY(1, i) + 170
    t.goto(x, y)
t.goto(56, 120)
t.fillcolor("#b1c9e9")
t.end_fill()
t.pencolor("white")
t.pensize(2)
for i in range(1, 6):
    t.goto(64, 120 + 10 * i)
    t.pu()
    t.goto(56, 120 + 10 * i)
    t.pd()
t.pu()
t.goto(60, 170)
t.pd()
t.goto(60, 180)
t.pensize(1)
#
t.pu()
t.goto(64, 190)
t.pd()
t.pencolor("#f1add1")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) + 60
    y = drawY(10, i) + 190
    t.goto(x, y)
t.fillcolor("#f1add1")
t.end_fill()

# 14
t.pu()
t.goto(-56, 120)
t.pd()
t.pencolor("#b1c9e9")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) - 60
    y = drawY(1, i) + 120
    t.goto(x, y)
t.goto(-56, 170)
for i in range(540):
    x = drawX(4, i) - 60
    y = drawY(1, i) + 170
    t.goto(x, y)
t.goto(-64, 120)
t.fillcolor("#b1c9e9")
t.end_fill()
t.pencolor("white")
t.pensize(2)
for i in range(1, 6):
    t.goto(-56, 120 + 10 * i)
    t.pu()
    t.goto(-64, 120 + 10 * i)
    t.pd()
t.pu()
t.goto(-60, 170)
t.pd()
t.goto(-60, 180)
t.pensize(1)
#
t.pu()
t.goto(-56, 190)
t.pd()
t.pencolor("#f1add1")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) - 60
    y = drawY(10, i) + 190
    t.goto(x, y)
t.fillcolor("#f1add1")
t.end_fill()
# 15
t.pu()
t.goto(0, 130)
t.pd()
t.pencolor("#b1c9e9")
t.begin_fill()
for i in range(360):
    x = drawX(4, i)
    y = drawY(1, i) + 130
    t.goto(x, y)
t.goto(4, 180)
for i in range(540):
    x = drawX(4, i)
    y = drawY(1, i) + 180
    t.goto(x, y)
t.goto(-4, 130)
t.fillcolor("#b1c9e9")
t.end_fill()
t.pencolor("white")
t.pensize(2)

f = p.mixer.music.load(file)
p.mixer.music.play()

for i in range(1, 6):
    t.goto(4, 130 + 10 * i)
    t.pu()
    t.goto(-4, 130 + 10 * i)
    t.pd()
t.pu()
t.goto(0, 180)
t.pd()
t.goto(0, 190)
t.pensize(1)
#
t.pu()
t.goto(4, 200)
t.pd()
t.pencolor("#f1add1")
t.begin_fill()
for i in range(360):
    x = drawX(4, i)
    y = drawY(10, i) + 200
    t.goto(x, y)
t.fillcolor("#f1add1")
t.end_fill()
# 16
t.pu()
t.goto(30, 110)
t.pd()
t.pencolor("#b1c9e9")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) + 30
    y = drawY(1, i) + 110
    t.goto(x, y)
t.goto(34, 160)
for i in range(540):
    x = drawX(4, i) + 30
    y = drawY(1, i) + 160
    t.goto(x, y)
t.goto(26, 110)
t.fillcolor("#b1c9e9")
t.end_fill()
t.pencolor("white")
t.pensize(2)
for i in range(1, 6):
    t.goto(34, 110 + 10 * i)
    t.pu()
    t.goto(26, 110 + 10 * i)
    t.pd()
t.pu()
t.goto(30, 160)
t.pd()
t.goto(30, 170)
t.pensize(1)
#
t.pu()
t.goto(34, 180)
t.pd()
t.pencolor("#f1add1")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) + 30
    y = drawY(10, i) + 180
    t.goto(x, y)
t.fillcolor("#f1add1")
t.end_fill()
# 17
t.pu()
t.goto(-30, 110)
t.pd()
t.pencolor("#b1c9e9")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) - 30
    y = drawY(1, i) + 110
    t.goto(x, y)
t.goto(-26, 160)
for i in range(540):
    x = drawX(4, i) - 30
    y = drawY(1, i) + 160
    t.goto(x, y)
t.goto(-34, 110)
t.fillcolor("#b1c9e9")
t.end_fill()
t.pencolor("white")
t.pensize(2)
for i in range(1, 6):
    t.goto(-26, 110 + 10 * i)
    t.pu()
    t.goto(-34, 110 + 10 * i)
    t.pd()
t.pu()
t.goto(-30, 160)
t.pd()
t.goto(-30, 170)
t.pensize(1)
#
t.pu()
t.goto(-26, 180)
t.pd()
t.pencolor("#f1add1")
t.begin_fill()
for i in range(360):
    x = drawX(4, i) - 30
    y = drawY(10, i) + 180
    t.goto(x, y)
t.fillcolor("#f1add1")
t.end_fill()
###随机
color = ["#e28cb9", "#805a8c", "#eaa989", "#6e90b7", "#b8b68f", "#e174b5", "#cf737c", "#7c8782"]
for i in range(80):
    t.pu()
    x = r.randint(-120, 120)
    y = r.randint(-25, 30)
    t.goto(x, y)
    t.pd()
    t.dot(r.randint(2, 5), color[r.randint(0, 7)])
for i in range(40):
    t.pu()
    x = r.randint(-90, 90)
    y = r.randint(-35, 10)
    t.goto(x, y)
    t.pd()
    t.dot(r.randint(2, 5), color[r.randint(0, 7)])

for i in range(40):
    t.pu()
    x = r.randint(-80, 80)
    y = r.randint(60, 90)
    t.goto(x, y)
    t.pd()
    t.dot(r.randint(2, 5), color[r.randint(0, 7)])
for i in range(30):
    t.pu()
    x = r.randint(-50, 50)
    y = r.randint(45, 70)
    t.goto(x, y)
    t.pd()
    t.dot(r.randint(2, 5), color[r.randint(0, 7)])
for i in range(50):
    t.pu()
    x = r.randint(-500, 500)
    y = r.randint(120, 300)
    t.goto(x, y)
    t.pd()
    t.dot(r.randint(3, 5), color[r.randint(0, 7)])
t.seth(90)
t.pu()
t.goto(0, 0)
t.fd(210)
t.left(90)
t.fd(170)
t.pd()
t.write("Happy Birthday", font=("Curlz MT", 50))

#小爱心

# 画爱心的顶部
def LittleHeart():
    for i in range(200):
        t.right(1)
        t.forward(0.2)
# 窗口大小
#t.setup(width=800, height=500)
# 颜色
t.color('pink', 'pink')
# 笔粗细
t.pensize(5)
# 速度
t.speed(1)
# 提笔
t.up()
# 隐藏笔
t.hideturtle()
# 去到的坐标,窗口中心为0,0
t.goto(-350, 0)
t.showturtle()
t.right(180)
# 画上线
t.down()
t.speed(1)
t.begin_fill()
t.left(140)
t.forward(22)
# 调用画爱心左边的顶部
LittleHeart()
# 调用画爱右边的顶部
t.left(120)
LittleHeart()
# 画下线
t.forward(22)
t.end_fill()
t.pensize(5)
t.up()
t.hideturtle()


# 画爱心的顶部
def LittleHeart():
    for i in range(200):
        t.right(1)
        t.forward(0.2)
# 窗口大小
#t.setup(width=800, height=500)
# 颜色
t.color('pink', 'pink')
# 笔粗细
t.pensize(5)
# 速度
t.speed(1)
# 提笔
t.up()
# 隐藏笔
t.hideturtle()
# 去到的坐标,窗口中心为0,0
t.goto(350,0)
t.showturtle()
t.left(135)
# 画上线
t.down()
t.speed(1)
t.begin_fill()
t.left(140)
t.forward(22)
# 调用画爱心左边的顶部
LittleHeart()
# 调用画爱右边的顶部
t.left(120)
LittleHeart()
# 画下线
t.forward(22)
t.end_fill()
t.pensize(5)
t.up()
t.hideturtle()

t.done()
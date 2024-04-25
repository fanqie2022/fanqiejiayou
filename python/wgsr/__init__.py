import tkinter as tk
from PIL import Image, ImageTk
from time import time, sleep
from random import choice, uniform, randint
from math import sin, cos, radians
import turtle as t
import math as m
import random as r


# 模拟重力
GRAVITY = 0.05
# 颜色选项（随机或者按顺序）
colors = ['red', 'blue', 'yellow', 'white', 'green', 'orange', 'purple', 'seagreen', 'indigo', 'cornflowerblue']

'''
particles 类

粒子在空中随机生成随机，变成一个圈、下坠、消失

属性:
    - id: 粒子的id
    - x, y: 粒子的坐标
    - vx, vy: 在坐标的变化速度
    - total: 总数
    - age: 粒子存在的时长
    - color: 颜色
    - cv: 画布
    - lifespan: 最高存在时长

'''


class Particle:

    def __init__(self, cv, idx, total, explosion_speed, x=0., y=0., vx=0., vy=0., size=2., color='red', lifespan=2,
                 **kwargs):
        self.id = idx
        self.x = x
        self.y = y
        self.initial_speed = explosion_speed
        self.vx = vx
        self.vy = vy
        self.total = total
        self.age = 0
        self.color = color
        self.cv = cv
        self.cid = self.cv.create_oval(
            x - size, y - size, x + size,
            y + size, fill=self.color)
        self.lifespan = lifespan

    def update(self, dt):
        self.age += dt

        # 粒子范围扩大
        if self.alive() and self.expand():
            move_x = cos(radians(self.id * 360 / self.total)) * self.initial_speed
            move_y = sin(radians(self.id * 360 / self.total)) * self.initial_speed
            self.cv.move(self.cid, move_x, move_y)
            self.vx = move_x / (float(dt) * 1000)

        # 以自由落体坠落
        elif self.alive():
            move_x = cos(radians(self.id * 360 / self.total))
            # we technically don't need to update x, y because move will do the job
            self.cv.move(self.cid, self.vx + move_x, self.vy + GRAVITY * dt)
            self.vy += GRAVITY * dt

        # 移除超过最高时长的粒子
        elif self.cid is not None:
            cv.delete(self.cid)
            self.cid = None

    # 扩大的时间
    def expand (self):
        return self.age <= 1.2

    # 粒子是否在最高存在时长内
    def alive(self):
        return self.age <= self.lifespan

'''
循环调用保持不停
'''
def simulate(cv):
    t = time()
    explode_points = []
    wait_time = randint(10, 100)
    numb_explode = randint(6, 10)
    # 创建一个所有粒子同时扩大的二维列表
    for point in range(numb_explode):
        objects = []
        x_cordi = randint(50, 550)
        y_cordi = randint(50, 150)
        speed = uniform(0.5, 1.5)
        size = uniform(0.5, 3)
        color = choice(colors)
        explosion_speed = uniform(0.2, 1)
        total_particles = randint(10, 50)
        for i in range(1, total_particles):
            r = Particle(cv, idx=i, total=total_particles, explosion_speed=explosion_speed, x=x_cordi, y=y_cordi,
                         vx=speed, vy=speed, color=color, size=size, lifespan=uniform(0.6, 1.75))
            objects.append(r)
        explode_points.append(objects)

    total_time = .0
    # 1.8s内一直扩大
    while total_time < 1.8:
        sleep(0.01)
        tnew = time()
        t, dt = tnew, tnew - t
        for point in explode_points:
            for item in point:
                item.update(dt)
        cv.update()
        total_time += dt
    # 循环调用
    root.after(wait_time, simulate, cv)


def close(*ignore):
    """退出程序、关闭窗口"""
    global root
    root.quit()

def bc():
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
    t.write("祝外公生日快乐", font=("Curlz MT", 50))
    t.done()

if __name__ == '__main__':
    bc()
    root = tk.Tk()
    cv = tk.Canvas(root, height=400, width=600)
    # 选一个好看的背景会让效果更惊艳！
    image = Image.open("./image.jpg")#这里自己选择好背景图片哦
    photo = ImageTk.PhotoImage(image)

    #bc()

    cv.create_image(0, 0, image=photo, anchor='nw')
    cv.pack()

    root.protocol("WM_DELETE_WINDOW", close)
    root.after(100, simulate, cv)
    root.mainloop()
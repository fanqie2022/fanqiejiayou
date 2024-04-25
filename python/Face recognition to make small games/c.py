import sys

import pygame
# 使用前先需要初始化，初始化所有被导入的pygame子模块，固定用法
pygame.init()                       # 初始化pygame
# 游戏肯定是在一个窗口中，那我们先来创建一个窗口
size = width, height = 800, 533     # 设置窗口大小

screen = pygame.display.set_mode(size)  # 显示窗
background_img = pygame.image.load('image/img.png')#设置背景图
red = (255,0,0) # 设置rgb值，这里是红色
while True:  # 死循环确保窗口一直显示
    for event in pygame.event.get():  # 遍历所有事件
        if event.type == pygame.QUIT:  # 如果单击关闭窗口，则退出
            sys.exit()

    screen.fill(red) #填充背景
    screen.blit(background_img, [0, 0])   # 绘制沙滩
    pygame.display.flip() # 更新

pygame.quit()  # 退出pygame
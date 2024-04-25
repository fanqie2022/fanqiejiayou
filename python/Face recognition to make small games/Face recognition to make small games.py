import copy
import os
import random
import re
import sys
import threading
import time
import tkinter
from cgitb import handler
from tkinter import Button
from tkinter import Entry
from tkinter import Label
from tkinter import Message
from tkinter import Scale
from tkinter import StringVar
from tkinter import Toplevel
from tkinter.filedialog import askopenfilename
import cv2
import pygame
import pygame as p
import requests
from PIL import Image, ImageTk
from baidubce import bce_base_client, bce_client_configuration
from baidubce.auth import bce_v1_signer, bce_credentials
from baidubce.http import bce_http_client, http_methods
from pymediainfo import MediaInfo

'''
                       _oo0oo_
                      o8888888o
                      88" . "88
                      (| -_- |)
                      0\  =  /0
                    ___/`---'\___
                  .' \\|     |// '.
                 / \\|||  :  |||// \
                / _||||| -:- |||||- \
               |   | \\\  - /// |   |
               | \_|  ''\---/''  |_/ |
               \  .-\__  '-'  ___/-. /2
             ___'. .'  /--.--\  `. .'___
          ."" '<  `.___\_<|>_/___.' >' "".
         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
         \  \ `_.   \_ __\ /__ _/   .-` /  /
     =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---='


     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

           佛祖保佑     永不宕机     永无BUG

       佛曰:  
               写字楼里写字间，写字间里程序员；  
               程序人员写程序，又拿程序换酒钱。  
               酒醒只在网上坐，酒醉还来网下眠；  
               酒醉酒醒日复日，网上网下年复年。  
               但愿老死电脑间，不愿鞠躬老板前；  
               奔驰宝马贵者趣，公交自行程序员。  
               别人笑我忒疯癫，我笑自己命太贱；  
               不见满街漂亮妹，哪个归得程序员？
'''
#APPID AK SK
APP_ID = '25906857'
API_KEY = 'BGoozYsEooOwXICD4n2KW24p'
SECRET_KEY = 'CcX4NEADpjFD1tG3Bf9DqdBjnK1Zo0yQ'
""""""
def s():
    # 人脸检测 Python示例代码
    class ApiCenterClient(bce_base_client.BceBaseClient):

        def __init__(self, config=None):
            self.service_id = 'apiexplorer'
            self.region_supported = True
            self.config = copy.deepcopy(bce_client_configuration.DEFAULT_CONFIG)

            if config is not None:
                self.config.merge_non_none_values(config)

        def _merge_config(self, config=None):
            if config is None:
                return self.config
            else:
                new_config = copy.copy(self.config)
                new_config.merge_non_none_values(config)
                return new_config

        def _send_request(self, http_method, path,
                          body=None, headers=None, params=None,
                          config=None, body_parser=None):
            config = self._merge_config(config)
            if body_parser is None:
                body_parser = handler.parse_json

            return bce_http_client.send_request(
                config, bce_v1_signer.sign, [handler.parse_error, body_parser],
                http_method, path, body, headers, params)

        def demo(self):
            path = b'/rest/2.0/face/v3/detect'
            headers = {}
            headers[b'Content-Type'] = 'application/json;charset=UTF-8'

            params = {}

            body = '{\"image\":\"https:\/\/baidu-ai.bj.bcebos.com\/face\/faces.jpg\",\"image_type\":\"URL\"}'
            return self._send_request(http_methods.POST, path, body, headers, params)

    if __name__ == '__main__':
        endpoint = 'https://aip.baidubce.com'
        ak = ''
        sk = ''
        config = bce_client_configuration.BceClientConfiguration(credentials=bce_credentials.BceCredentials(ak, sk),
                                                                 endpoint=endpoint)
        client = ApiCenterClient(config)
        res = client.demo()
        print(res.__dict__['raw_data'])


def AipFace(APP_ID, API_KEY, SECRET_KEY):
    pass


client = AipFace('25906857','BGoozYsEooOwXICD4n2KW24p','Sl8aFNe1h90N9dAftcIu0GvGdMsEKvTf')

def en():#人脸
    # client_id 为官网获取的AK， client_secret 为官网获取的SK
    host = 'https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=BGoozYsEooOwXICD4n2KW24p&client_secret=CcX4NEADpjFD1tG3Bf9DqdBjnK1Zo0yQ'
    response = requests.get(host)
    if response:
        print(response.json())

def cd():#c组图片导入
    c1 = "image/c/c1 (1).png"
    c2 = "image/c/c1 (2).png"
    c3 = "image/c/c1 (3).png"
    c4 = "image/c/c1 (4).png"

def xfjd():#小飞机组图片导入
    xfj1 = "image/xiaofeiji/xiaofeiji (1).png"
    xfj2 = "image/xiaofeiji/xiaofeiji (2).png"
    xfj3 = "image/xiaofeiji/xiaofeiji (3).png"
    xfj4 = "image/xiaofeiji/xiaofeiji (4).png"

def zfjd():#中飞机组图片导入
    zfj1 = "image/zhongfeiji/zhongfeiji  (1).png"
    zfj2 = "image/zhongfeiji/zhongfeiji  (2).png"
    zfj3 = "image/zhongfeiji/zhongfeiji  (3).png"
    zfj4 = "image/zhongfeiji/zhongfeiji  (4).png"

#def

def csh():#pygame初始化ag
    p.init()  # 初始化pygame
    size = width, height = 480, 700  # 设置窗口大小
    screen = p.display.set_mode(size)  # 显示窗口
    background_img = p.image.load('image/img.png')  # 设置背景图
    red = (255, 0, 0)  # 设置rgb值，这里是红色
    while True:  # 死循环确保窗口一直显示
        for event in p.event.get():  # 遍历所有事件
            if event.type == p.QUIT:  # 如果单击关闭窗口，则退出
                sys.exit()
        screen.fill(red)  # 填充背景
        screen.blit(background_img, [0, 0])  # 绘制背景
        p.display.flip()  # 更新背景

def music():
    file = r'Music/QQ音乐-千万正版音乐海量无损曲库新歌热歌天天畅听的高品质音乐平台！ (V0).mp3'  # 导入背景音乐
    p.mixer.init()
    p.mixer.music.load(file)
    p.mixer.music.play()

def sxt():
    def video_demo():
        capture = cv2.VideoCapture(0)  # 0为电脑内置摄像头
        while (1):
            ret, frame = capture.read()  # 摄像头读取,ret为是否成功打开摄像头,true,false。 frame为视频的每一帧图像
            frame = cv2.flip(frame, 1)  # 摄像头是和人对立的，将图像左右调换回来正常显示。
            cv2.imshow("video", frame)
            c = cv2.waitKey(50)
            if c == 27:
                break

    video_demo()
    cv2.destroyAllWindows()

def yy():
    top = tkinter.Tk()
    top.geometry("800x400")
    top.title("音乐播放器")

    def printsrceen(texts):
        t = int(texts)
        top.attributes("-alpha", t / 100)

    screenwidth = top.winfo_screenwidth()
    screenheight = top.winfo_screenheight() - 100

    pygame.init()
    path = StringVar()
    paths = StringVar()
    patht = StringVar()
    v = StringVar()
    v1 = StringVar()

    def callback():  # 搜索本地文件
        path_ = askopenfilename()
        return path_

    def selectPath():  # 随机播放
        folder_path = "D:/ppp/Music/"
        folder_list = os.listdir(folder_path)  # 遍历文件夹里面每个文件
        list = []
        count = 0
        for i in folder_list:  # 将文件夹里的文件按顺序传提给变量i  此处区别os.walk()
            if os.path.splitext(i)[1] == '.flac':  # 提取特定后缀文件'.***'
                list.append(i)
                # print(type(list))
                count = count + 1
        # print(count)

        s = random.randint(0, (count - 1))  # 获取随机数
        file = list[s]
        fil = folder_path + "\\" + file

        pygame.mixer.music.load(fil)
        pygame.mixer.music.play(1, 0)
        media_info = MediaInfo.parse(fil)
        data = media_info.to_json()  # medio到json()这两行是获取文件的所有属性
        rst = re.search('other_duration.*?(.*?)min(.*?)s.*?', data)
        t = int(rst.group(0)[19:20])
        r = int(rst.group(0)[-4:-2])
        m = (t * 60 + r) * 1000

        musictime = str(t) + ':' + str(r)
        l2.config(text=file)
        l3.config(text=musictime)
        lbTime = tkinter.Label(top, anchor='w')
        lbTime.place(x=25, y=150)

        def autoclose():
            for i in range(m // 1000):
                lbTime['text'] = '-{} /'.format((m // 1000) - i)
                time.sleep(1)

        t = threading.Thread(target=autoclose)
        t.start()
        loopl = top.after(m, selectPath)

    def printScale(text):
        t = int(text)
        pygame.mixer.music.set_volume(t / 100)

    def update_timeText():
        # Get the current time, note you can change the format as you wish
        current = time.strftime("%H:%M:%S")  # 获取当前时间

        # Update the timeText Label box with the current time
        timeText.configure(text=current)

        # Call the update_timeText() function after 1 second
        top.after(1000, update_timeText)

    def remind():
        top = Toplevel()  # 新建一个tkinter窗口
        top.title('使用提示')
        top.geometry("200x200")
        t = "半分钟后开始播放音乐"
        msg = Message(top, text=t)
        msg.config(font=('times', 18, 'italic'))
        msg.place(x=0, y=0)
        lbTime = tkinter.Label(top, fg="red", anchor='w')
        lbTime.place(x=100, y=45)

        def autoclose():
            for i in range(30):
                lbTime['text'] = '距离窗口关闭还有{}秒'.format(30 - i)
                time.sleep(1)
            top.destroy()

        t = threading.Thread(target=autoclose)
        t.start()
        loopl = top.after(60 * 59500, remind)

    def reminds():
        top = Toplevel()
        top.title('使用提示')
        top.geometry("200x200")
        t = "宝贝可以休息一会啦"
        msg = Message(top, text=t)
        msg.config(font=('times', 24, 'italic'))
        msg.place(x=0, y=0)
        folder_path = "D:/音乐"
        folder_list = os.listdir(folder_path)  # 遍历文件夹里面每个文件
        list = []
        count = 0
        for i in folder_list:  # 将文件夹里的文件按顺序传提给变量i  此处区别os.walk()
            if os.path.splitext(i)[1] == '.flac':  # 提取特定后缀文件'.***'
                list.append(i)
                # print(type(list))
                count = count + 1
            # print(count)
        s = random.randint(0, (count - 1))
        file = list[s]
        fil = folder_path + "\\" + file
        pygame.mixer.music.load(fil)
        pygame.mixer.music.play(1, 0)
        lbTime = tkinter.Label(top, fg="red", anchor='w')
        lbTime.place(x=100, y=45)

        def autoclose():
            for i in range(300):
                lbTime['text'] = '距离窗口关闭还有{}秒'.format(300 - i)
                time.sleep(1)
            top.destroy()

        t = threading.Thread(target=autoclose)
        t.start()
        loopl = top.after(60 * 60000, reminds)

    def play():  # 播放音乐
        f = callback()  # 选择制定文件
        pygame.mixer.music.load(f)
        pygame.mixer.music.play()
        path.set(f)
        media_info = MediaInfo.parse(f)
        data = media_info.to_json()  # medio到json()这两行是获取文件的所有属性
        rst = re.search('other_duration.*?(.*?)min(.*?)s.*?', data)
        t = int(rst.group(0)[19:20])
        r = int(rst.group(0)[-4:-2])
        m = (t * 60 + r) * 1000
        musictime = str(t) + ':' + str(r)
        l2.config(text=f)
        l3.config(text=musictime)
        lbTime = tkinter.Label(top, anchor='w')
        lbTime.place(x=25, y=150)

        def autoclose():
            for i in range(m // 1000):
                lbTime['text'] = '-{} /'.format((m // 1000) - i)
                time.sleep(1)

        t = threading.Thread(target=autoclose)
        t.start()
        loopl = top.after(m, selectPath)

    def stop(loopl=None):
        pygame.mixer.music.stop()  # 停止播放
        top.after_cancel(loopl)

    def pause():
        pygame.mixer.music.pause()  # 暂停

    def unpause():
        pygame.mixer.music.unpause()  # 继续播放

    def choosepic():  # 保存的路径不能有中文，若需要中文则吧/换成\
        path_s = askopenfilename()
        paths.set(path_s)
        img_open = Image.open(e1.get())
        img = ImageTk.PhotoImage(img_open)
        l1.config(image=img)
        l1.image = img

    def create():
        top = Toplevel()
        top.title('使用提示')
        top.geometry("400x400")
        t = "关于音乐: 新建一个名字叫音乐的文件，把自己喜欢的歌曲添加到该文件夹。"
        msg = Message(top, text=t)
        msg.config(font=('times', 24, 'italic'))
        msg.place(x=0, y=0)

    def loop():
        top.after(60 * 60000, reminds)
        top.after(60 * 59500, remind)

    def loops():
        selectPath()

    def gettime():
        t = time.strftime('%H%M%S')
        s = int(t[0:2])
        d = int(t[2:4])
        f = int(t[4:6])
        g = s * 60 * 60 + d * 60 + f
        return g

    errmsg = 'Error!'
    # 时间
    timeText = Label(top, text="", font=("Helvetica", 15))
    timeText.place(x=180, y=370)
    update_timeText()
    # 选择文件
    Button(top, text="选择文件/播放", command=play, width=10, bg="sky blue").place(x=20, y=20)
    Entry(top, text=path, width=25, state='readonly').place(x=120, y=20)

    # 选择图片
    Button(top, text='选择图片', command=choosepic, width=10, bg="sky blue").place(x=20, y=55)
    e1 = Entry(top, text=paths, state='readonly', width=25)
    e1.place(x=120, y=55)
    l1 = Label(top)  # 图片放置位置
    l1.place(x=320, y=0)

    # 随机播放
    Button(top, text="随机播放", command=selectPath, width=7, bg="sky blue").place(x=20, y=225)
    l2 = Label(top, text='', width=25, font=("Helvetica", 16))  # 音乐名
    l2.place(x=0, y=100)
    Button(top, text="下一首", command=loops, width=5, bg="sky blue").place(x=100, y=225)
    l3 = Label(top, text='', width=15)  # 音乐时长
    l3.place(x=24, y=150)
    # 暂停，继续播放，结束播放
    Button(top, text="暂停", command=pause, width=7, bg="sky blue").place(x=170, y=245)
    Button(top, text="继续播放", command=unpause, width=7, bg="sky blue").place(x=170, y=205)
    Button(top, text="结束播放", command=stop, width=7, bg="sky blue").place(x=240, y=225)

    # 提醒功能
    Button(top, text='提醒功能', command=loop, width=10, bg="sky blue").place(x=20, y=325)
    # 使用说明
    Button(top, text="使用说明", command=create, width=10, bg="sky blue").place(x=20, y=370)
    # 音量
    w1 = Scale(top, from_=0, to=100, orient="horizontal", length=75, variable=v, command=printScale, label="音量")
    w1.place(x=240, y=145)

    w2 = Scale(top, from_=30, to=100, orient="horizontal", length=100, variable=v1, command=printsrceen, label="透明度")
    w2.place(x=150, y=290)

    top.mainloop()


if __name__ == '__main__':
    #music()  # 背景音乐
    yy()
    csh()  # 初始化pygame窗口
    #sxt()
    p.quit()  # 退出pygame

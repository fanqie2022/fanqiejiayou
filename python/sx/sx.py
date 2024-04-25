import os
from aip import AipOcr
import re
from pandas import DataFrame
from easygui import diropenbox
from tqdm import tqdm

print('初始化完成！')
print('请正确选择截图所在的文件夹...')
""" 我的 APPID AK SK """
APP_ID = '27110354'  # 申请百度OCR创建应用获取的 ID
API_KEY = 'EhMavEuDkP5S11tghyuyRgQQ'
SECRET_KEY = 'mGL8TY0chtKI5XKW2PxkDjo3DQ4GyhD0'
# 初始化AipFace对象
client = AipOcr(APP_ID, API_KEY, SECRET_KEY)

""" 读取图片 """
def get_file_content(filePath):
    with open(filePath, 'rb') as fp:
        return fp.read()

path = diropenbox('请选择需要处理的文件夹') # 设定图片目录路径
filelist = os.listdir(path)  #该方法列出path路径下的文件和文件夹列表
# file = [os.path.abspath(os.path.join(r, f)) for r, _, fs in os.walk(path) for f in fs]
result = []
print('正在识别，进度如下(若软件中途出错闪退，请重新运行)：')

try:
    for file in tqdm(filelist): #tqdm为进度
        a = {}
        file_path = f'{path}\\{file}' #图片文件绝对路径
        img = get_file_content(file_path)
        message = client.basicAccurate(img)['words_result']   #basicAccurate 高精度版识别
        x = [list(i.values())[0] for i in message]
        x_str = ','.join(x)
        t = re.findall("名：(.*)",x_str, re.S)  #截取有效部分
        t2 = re.findall(r"(\d{4}-\d{2}-\d{2})", t[0], re.S)  # 对日期的正则匹配
        k = t[0].split(",")
        time = k[3][0:10]+' '+k[3][10:18]
        name = k[0]
        status = k[2]
        if len(t2)>1:
            time2 = t2[1]
            check = k[6]
        else:
            time2='无'
            check='无'

        a['截图时间'] = time
        a['姓名'] = name
        a['状态'] = status
        a['核酸结果'] = check
        a['检测时间'] = time2
        a['图片路径'] ='=HYPERLINK("'+file_path+'","点击查看文件")'
        result.append(a)
        # print(result)

except BaseException as e:
    print('OCR识别异常中断，请重试! Error:',e)

else:
    result=DataFrame(result).to_excel('健康码统计结果.xlsx')
    os.startfile('健康码统计结果.xlsx')
    print('程序运行完成')
    print('已在本软件所在目录生成excel统计表')
finally:
    input('按任意键退出程序...')
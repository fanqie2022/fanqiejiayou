from aip import AipFace
import base64

APP_ID = '25906857'
API_KEY = 'BGoozYsEooOwXICD4n2KW24p'
SECRET_KEY = 'CcX4NEADpjFD1tG3Bf9DqdBjnK1Zo0yQ'
client = AipFace(APP_ID, API_KEY, SECRET_KEY)
pic1 = "test11.jpg"
pic2 = "test1.jpg"


# 封装成函数，返回获取的client对象
def get_client(APP_ID, API_KEY, SECRET_KEY):
    """
    返回client对象
    :param APP_ID:
    :param API_KEY:
    :param SECRET_KEY:
    :return:
    """
    return AipFace(APP_ID, API_KEY, SECRET_KEY)


client = get_client(APP_ID, API_KEY, SECRET_KEY)
result = client.match([
    {
        'image': str(base64.b64encode(open(pic1, 'rb').read()), 'utf-8'),
        'image_type': 'BASE64',
    },
    {
        'image': str(base64.b64encode(open(pic2, 'rb').read()), 'utf-8'),
        'image_type': 'BASE64',
    }
])
print(result)

if result['error_msg'] == 'SUCCESS':
    score = result['result']['score']
    print('两张图片相似度：', score)
else:
    print('错误信息：', result['error_msg'])

import matplotlib.pyplot as plt

pc1 = plt.imread(pic1)
pc2 = plt.imread(pic2)
plt.imshow(pc1)
plt.show()
plt.imshow(pc2)
plt.show()
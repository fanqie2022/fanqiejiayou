import requests
import bs4
import re
kuaidi = []
url='http://m.46644.com/express/result.php?typetxt=%D6%D0%CD%A8&type=zto&number=你的单号'
response = requests.get(url)
response.encoding = 'gb18030'
response = response.text
soup = bs4.BeautifulSoup(response,'html.parser',from_encoding="utf8")
for i in soup.findAll(name='div',attrs = {'class':'icontent'}):
    kuaidi.append(i.get_text())
    print(i.get_text())
import json

import item as item
import requests as r
g = r.get("https://club.jd.com/comment/productPageCom]ments.action?callback=fetchJSON_comment98&productId=10335871600&score=0&sortType=5&page=0&pageSize=10&isShadowSku=0&fold=1")
c = g.text
rest = c.replace('fetchJSON_comment98(",").replace(');",")
json_data = json.loads(rest)
comments = json_ndata[ 'comments']
for item in comments:
    color = item['productColor']
    size = item['productSize']
    print(color)
print(size)




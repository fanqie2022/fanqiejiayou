import requests as r
g = r.get("https://www.jd.com/")
print(g.text)
# coding=utf-8
import json
import time
import EpicGamesBot
from pathlib import Path
from playwright.sync_api import sync_playwright
def Run(Playwright, username, password):
    cookies_path = Path("cookies.json")
    browser = None
    print("初始化完成")
    try:
        browser = Playwright.firefox.launch()
        page = browser.new_page()
        bot = EpicGamesBot(page)
        print("正在登录。。。")
        bot.log_in(None, username, password)
        print("登录成功！")
        purchased_offer_urls = bot.purchase_free_promotional_offers()
        [print(url) for url in purchased_offer_urls]
        cookies_path.write_text(json.dumps(bot.cookies))
        print("{name} 领取完成".format(name=username))
        browser.close()
    except Exception:
        if browser:
            browser.close()
            print("发生错误,领取失败")
        raise
if __name__ == '__main__':
    CA = EpicGamesBot.list_free_promotional_offers()  # 免费游戏列表
    print(CA)
    # 用户列表
    userList = [
        {
            'username': '3143291731@qq.com',
            'password': 'fanqie2021'
        }
    ]
    for val in userList:
        with sync_playwright() as playwright:
            Run(playwright, val['username'], val['password'])
        # 休息20秒再登录下一个账号 防止被K
        time.sleep(20)
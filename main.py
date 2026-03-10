class Animation:
    # 构造函数：Python 不用重复写类型，self 相当于 Java 的 this
    def __init__(self, name, love_point):
        self.name = name
        self.love_point = love_point

    # 相当于 Java 的 toString()
    def __str__(self):
        return f"名称: {self.name}, 好感度: {self.love_point}"

# Python 的 List 就是 ArrayList，不需要导入 java.util
anime_list = []

print("你喜欢的动漫有什么？你分别为他们打多少分？")
print("请输入指令：new, end, remove")

# Python 没有 Labelled break，我们通常用标志位或 return 来处理
running = True

while running:
    command = input("请输入指令: ") # Python 的 input 直接读取字符串

    if command == "new":
        print("动漫名？你打多少分？")
        try:
            name = input("名: ")
            # Python 的强制转换：int() 相当于 Java 的 Integer.parseInt()
            love_point = int(input("分: "))
            anime_list.append(Animation(name, love_point)) # list.add -> list.append
        except ValueError: # 相当于 ArithmeticException 或转换错误
            print("捕获错误：请输入正确的数字！")
        except Exception as e: # 相当于 catch (Exception e)
            print(f"捕获错误：发生了意外 {e}")
        finally:
            print("下一个指令")

    elif command == "remove":
        try:
            print("以下是已有动漫:")
            for a in anime_list: # 增强 for 循环
                print(a.name)

            target = input("输入想删的: ")
            # Python 删除更简单：可以用 equals (==)，也可以用列表推导式
            # 这里模仿你的 for 循环逻辑
            for i in range(len(anime_list)):
                if anime_list[i].name == target: # Python 的 == 比较的就是内容！
                    anime_list.pop(i) # list.remove(i) -> list.pop(i)
                    print("已经删除")
                    break
        except Exception:
            print("删除时发生错误")
        finally:
            print("下一个指令")

    elif command == "end":
        running = False # 结束循环

    else:
        print("请重新输入指令")
        continue

# 排序逻辑：Lambda 表达式在 Python 里更简洁
# reverse=True 就是你费劲写的 .reversed()
anime_list.sort(key=lambda x: x.love_point, reverse=True)

print("\n--- 最终排名 ---")
for a in anime_list:
    print(a)
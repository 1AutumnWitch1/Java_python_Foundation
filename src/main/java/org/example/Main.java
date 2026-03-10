package org.example;
//今回のプロジェクトはJavaの基本です
//java基本用法
// 1：for (数据类型 变量名 : 数组或集合)
// 2：Labelled break
// 3：if, whiel ,do while, for, switch，Try-Catch-Finally等
// 4：Java 有个很爽的语法糖，允许你传入任意数量的参数 eg：public static void printAll(String... names)
//
//


import java.util.*;

class Animanation{
 String name;
 int lovepoint;
 public Animanation(String name,int lovepoint)
 {
     this.name=name;
     this.lovepoint = lovepoint;

 }
    @Override

    public String toString() {

     return  "名称: " + name + ", 好感度: " + lovepoint;

    }
}


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Animanation> list = new ArrayList<Animanation>();
        System.out.println("你喜欢的动漫有什么？你分别为他们打多少分？");
        System.out.println("请输入指令：new，end，remove");
        label:
        while (true) {
            String commend = input.next();
           switch (commend)
           {
               case "new":
                   System.out.println("动漫名？你打多少分？");
                   try {
                       String name;
                       int loveponit;
                       name=input.next();
                       loveponit = input.nextInt();
                      list.add(new Animanation(name,loveponit));
                   } catch (ArithmeticException e) {
                       // 捕获特定错误并处理
                       System.out.println("捕获错误：数学运算异常！");
                   } catch (Exception e) {
                       // 捕获其他所有错误
                       System.out.println("捕获错误：发生了意外。");
                   } finally {
                       // 无论是否报错，这部分代码必跑
                       System.out.println("下一个指令");
                   }
                   break ;
               case "remove":
                   try {
                       System.out.println("以下是已有动漫");
                       for(Animanation a: list){
                           System.out.println(a.name);
                       }
                       System.out.println("输入想删的");
                       String name = input.next();
                       for(int i = 0;i< list.size();i++)
                       {
//                           在java中字符对比是equals不是==，==是指针的对比
                           if(name.equals(list.get(i).name) ){
                           list.remove(i);
                           break;
                           }
                       }
                       System.out.println("已经删除");
                   } catch (ArithmeticException e) {
                       // 捕获特定错误并处理
                       System.out.println("捕获错误：数学运算异常！");
                   } catch (Exception e) {
                       // 捕获其他所有错误
                       System.out.println("捕获错误：发生了意外。");
                   } finally {
                       // 无论是否报错，这部分代码必跑
                       System.out.println("下一个指令");
                   }
                 break  ;
               case "end":
                   break label;
               default:
                   System.out.println("请重新输入指令");
                   continue label
                   ;

           }
                System.out.println("已录入");
        }
        list.sort((Comparator.comparingInt((Animanation a) -> a.lovepoint)).reversed());
      for(Animanation a: list)
      {
          System.out.println(a);
      }

    }
}

package org.example;

import java.util.*;

public class Animeaction {
    private class Animenation {
        private String name;
        private int lovepoint;

        // 构造函数可以设为 private（如果是单例）或包访问权限
        Animenation(String name, int lovepoint) {
            this.name = name;
            this.lovepoint = lovepoint;
        }

        // 2. 提供公共的读取方法（即使是 private 类，好的习惯也是通过方法访问）
        public String getName() {
            return name;
        }

        public int getLovepoint() {
            return lovepoint;
        }

        @Override
        public String toString() {
            return "名称: " + name + ", 好感度: " + lovepoint;
        }
    }
    private List<Animenation> list = new ArrayList<>();
    private Scanner input = new Scanner(System.in);


    public void start() {
        System.out.println("你喜欢的动漫有什么？你分别为他们打多少分？");
        System.out.println("请输入指令：new，end，remove");

        label:
        while (true) {
            String commend = input.next();
            switch (commend) {
                case "new":
                    System.out.println("动漫名？你打多少分？");
                    try {
                        String name = input.next();
                        int loveponit = input.nextInt();
                        list.add(new Animenation(name, loveponit));
                    } catch (Exception e) {
                        System.out.println("捕获错误：发生了意外。");
                        input.nextLine();
                    } finally {
                        System.out.println("下一个指令");
                    }
                    break;
                case "remove":
                    try {
                        System.out.println("以下是已有动漫");
                        for (Animenation a : list) {
                            System.out.println(a.getName());
                        }
                        System.out.println("输入想删的");
                        String name = input.next();
                        for (int i = 0; i < list.size(); i++) {
                            if (name.equals(list.get(i).name)) {
                                list.remove(i);
                                break;
                            }
                        }
                        System.out.println("已经删除");
                    } catch (Exception e) {
                        System.out.println("捕获错误：发生了意外。");
                    } finally {
                        System.out.println("下一个指令");
                    }
                    break;
                case "end":
                    break label;
                default:
                    System.out.println("请重新输入指令");
                    continue label;
            }
            System.out.println("已录入");
        }


        list.sort((Comparator.comparingInt((Animenation a) -> a.lovepoint)).reversed());
        for (Animenation a : list) {
            System.out.println(a);
        }
    }
}

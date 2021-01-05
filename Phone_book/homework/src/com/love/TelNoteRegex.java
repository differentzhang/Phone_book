package com.love;

import java.util.Scanner;

//用户输入验证类
public class TelNoteRegex {



    //写一个判断字符串都是字母的方法
    public static boolean isLetter(String str){
        boolean flag = true;

        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char s =chs[i];
            if (!Character.isLetter(s)){
                flag = false;
            }
        }
        return flag;
    }
    //写一个判断字符串都是数字的方法
    public static boolean isNum(String str){
        boolean flag = true;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char s =chs[i];
            if (!Character.isDigit(s)){
                flag = false;
            }
        }
        return flag;
    }

    //对菜单输入选项的验证
    public void menuRegex (int min, int max ){

    }

    //对用户输入姓名的验证  我感觉设置成一个静态的比较好点
    public static String nameRegex (String name){
        //这里想用正则表达式弄，
        // 先用普通思路弄，优化的时候用正则表达式弄

        while (true){
            if (name.length()>=1 && name.length()<=10){ //1-10位
                if (isLetter(name)){ //是否都是字母
                    break;
                }
            }
            System.out.println("姓名不合法,请重新输入。");
            Scanner sc = new Scanner(System.in);
            name = sc.next();

        }
        return name;
    }

    //对用户输入年龄的验证
    public static String ageRegex (String age){
        //这里面如果一直输入不对呢，所以得while循环

        while (true){
            if (isNum(age) && Integer.parseInt(age)>=1 && Integer.parseInt(age)<=130){
                break;
            }
            System.out.println("年龄不合法,请重新输入。");
            Scanner sc = new Scanner(System.in);
            age = sc.next();
        }
        return age;
    }

    //对用户输入性别的验证
    public static String sexRegex (String sex){

        while (true){
            if ("m".equals(sex) || "f".equals(sex) || "M".equals(sex) || "F".equals(sex)){
                break;
            }
            System.out.println("性别不合法,请重新输入。");
            Scanner sc = new Scanner(System.in);
            sex = sc.next();
        }
        return sex;
    }

    //对用户输入电话号码的验证
    public static String telNumRegex (String telNum){
        while (true){
            if (isNum(telNum) && telNum.length()>=6 && telNum.length()<=10){
                break;
            }
            System.out.println("电话号码不合法,请重新输入。");
            Scanner sc = new Scanner(System.in);
            telNum = sc.next();
        }
        return telNum;
    }

    //对用户输入地址的验证
    public static String addressRegex (String address){
        while (true){
            if (address.length()>=1 && address.length()<=50){
                //1-50位字母或数字
                if (isNum(address) || isLetter(address)){
                    break;
                }
            }
            System.out.println("地址不合法,请重新输入。");
            Scanner sc = new Scanner(System.in);
            address = sc.next();
        }
        return address;
    }
}

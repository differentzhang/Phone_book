package com.love;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//用户输入验证类
public class TelNoteRegex {

    //写一个判断字符串都是数字的方法
    public static boolean isNum(String str){
        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        //表达式对象
        p = Pattern.compile("\\d+");
        //匹配一个数字
        //创建Matcher对象
        m = p.matcher(str);
        flag = m.matches();

        return flag;
    }

    //对用户输入姓名的验证  我感觉设置成一个静态的比较好点
    public static String nameRegex (String name){
        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        while (true){
            //表达式对象
            p = Pattern.compile("[a-zA-Z]{1,10}?");
            //1-10个字母
            //创建Matcher对象
            m = p.matcher(name);
            flag = m.matches();
            if (flag == false){
                System.out.println("姓名不合法,请重新输入。");
                Scanner sc = new Scanner(System.in);
                name = sc.next();
            } else {
                break;
            }
        }
        return name;
    }

    //对用户输入年龄的验证
    public static String ageRegex (String age){

        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        while (true){
            //表达式对象
            p = Pattern.compile("^(?:[1-9][0-9]?|1[01][0-9]|120)$");
            //1-120岁
            //创建Matcher对象
            m = p.matcher(age);
            flag = m.matches();
            if (flag == false){
                System.out.println("年龄不合法,请重新输入。");
                Scanner sc = new Scanner(System.in);
                age = sc.next();
            } else {
                break;
            }
        }
        return age;
    }

    //对用户输入性别的验证
    public static String sexRegex (String sex){
        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        while (true){
            //表达式对象
            p = Pattern.compile("m|f");

            //创建Matcher对象
            m = p.matcher(sex);
            flag = m.matches();
            if (flag == false){
                System.out.println("性别不合法,请重新输入。");
                Scanner sc = new Scanner(System.in);
                sex = sc.next();
            } else {
                break;
            }
        }
        return sex;
    }

    //对用户输入电话号码的验证
    public static String telNumRegex (String telNum){
        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        while (true){
            //表达式对象
            p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
            //1开头,第二位是3或4或5或7或8,第三位到第11位(9个数)是0-9任意一个数字
            //创建Matcher对象
            m = p.matcher(telNum);
            flag = m.matches();
            if (flag == false){
                System.out.println("电话号码不合法,请重新输入。");
                Scanner sc = new Scanner(System.in);
                telNum = sc.next();
            } else {
                break;
            }
        }
        return telNum;
    }

    //对用户输入地址的验证
    public static String addressRegex (String address){
        boolean flag = false;
        Pattern p = null;
        Matcher m = null;
        while (true){
            //表达式对象
            p = Pattern.compile("[a-zA-Z]{1,50}|[0-9]{1,50}");
            //1-50位字母或数字
            //创建Matcher对象
            m = p.matcher(address);
            flag = m.matches();
            if (flag == false){
                System.out.println("地址不合法,请重新输入。");
                Scanner sc = new Scanner(System.in);
                address = sc.next();
            } else {
                break;
            }
        }
        return address;
    }
}

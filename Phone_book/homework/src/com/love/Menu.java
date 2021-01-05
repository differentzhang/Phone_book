package com.love;

import java.util.ArrayList;
import java.util.Scanner;

//菜单类
public class Menu {


    Operate o = new Operate();

    Scanner sc = new Scanner(System.in);

    //主菜单
    public  void mainMenu() {

        while (true){
            //显示菜单
            System.out.println("*********************");
            System.out.println("**    1　添加纪录   　**");
            System.out.println("**    2　查找纪录   　**");
            System.out.println("**    3　修改纪录   　**");
            System.out.println("**    4　删除纪录   　**");
            System.out.println("**    5　排序纪录  　 **");
            System.out.println("**    6　退出系统  　 **");
            System.out.println("**    7　存档      　**");
            System.out.println("**    8　读档  　    **");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:6");

            String select = sc.nextLine();

            switch (select){
                case "1":
                    //添加纪录
                    addMenu();

                    break;
                case "2":
                    //查找记录
                    searchMenu();
                    break;
                case "3":
                    //修改记录
                    modifyMenu(); //修改的主菜单
                    break;
                case "4":
                    //删除记录
                    deleteMenu();
                    break;
                case "5":
                    //排序记录
                    orderMenu();
                    break;
                case "6":
                    //退出系统
                    System.exit(0);
                    break;
                case "7":
                    //存档
                    o.saveFile();
                    break;
                case "8":
                    //读档
                    o.readFile();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    //添加纪录子菜单
    public void addMenu (){
        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**    1　添加新纪录  　**");
            System.out.println("**    2　查看全纪录　**");
            System.out.println("**    3　返回上一级　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:3");
            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    o.addLogic();
                    System.out.println("添加成功!");
                    break;
                case "2":
                    //查看全记录
                    o.showAll();
                    break; //这个break只能跳出switch循环
                case "3":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }
    }

    //查找纪录子菜单
    public void searchMenu (){
        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**  1　按姓名查找  　**");
            System.out.println("**  2　按年龄查找  　**");
            System.out.println("**  3　按性别查找  　**");
            System.out.println("**  4　按号码查找  　**");
            System.out.println("**  5　按住址查找  　**");
            System.out.println("**  6　查看全记录  　**");
            System.out.println("**  7　返回上一级  　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:7");

            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    //按姓名查找
                    System.out.println("输入姓名,1-10位字母");
                    String name = sc.nextLine();
                    o.searchByName(name);
                    break;
                case "2":
                   //按年龄查找
                    System.out.println("输入年龄,1-100+");
                    String age = sc.nextLine();
                    o.searchByAge(age);
                    break;
                case "3":
                   //按性别查找
                    System.out.println("输入性别,(男 m or M)(女 f or F)");
                    String sex = sc.nextLine();
                    o.searchBySex(sex);
                    break;
                case "4":
                    //按号码查找
                    System.out.println("输入电话号码,6-10位数字");
                    String telNum = sc.nextLine();
                    o.searchByTelNum(telNum);
                    break;
                case "5":
                    //按住址查找
                    System.out.println("输入地址,1-50位字母或数字");
                    String address = sc.nextLine();
                    o.searchByAdd(address);
                    break;
                case "6":
                    //查看全记录
                    o.showAll();
                    break;
                case "7":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }

    }
    //修改用户信息主菜单
    public void modifyMenu (){

        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**   1　查看全纪录  　**");
            System.out.println("**   2　修改指定纪录  **");
            System.out.println("**   3　返回上一级  　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:3");

            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    //查看全记录
                    o.showAll();
                    break;
                case "2":
                    //修改指定记录
                    o.modify();
                    break;
                case "3":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }


    }
    //修改用户信息子菜单
    public void subModifyMenu (String ID){
        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**    1　修改姓名  　**");
            System.out.println("**    2　修改年龄  　**");
            System.out.println("**    3　修改性别  　**");
            System.out.println("**    4　修改号码  　**");
            System.out.println("**    5　修改住址  　**");
            System.out.println("**    6　返回上一级  　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:6");
            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    //修改姓名
                    o.editName(ID);
                    break;
                case "2":
                    o.editAge(ID);
                    break;
                case "3":
                    o.editSex(ID);
                    break;
                case "4":
                    o.editTelNum(ID);
                    break;
                case "5":
                    o.editAdd(ID);
                    break;
                case "6":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }

    }
    //删除用户信息菜单
    public void deleteMenu (){

        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**   1　查看全记录  　**");
            System.out.println("**   2　删除指定纪录　**");
            System.out.println("**   3　删除全部纪录  **");
            System.out.println("**   4　返回上一级  　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:4");

            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    //查看全记录
                    o.showAll();
                    break;
                case "2":
                    //删除指定记录
                    o.delete();
                    break;
                case "3":
                    //删除全部记录
                    o.deleteAll();
                    break;
                case "4":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }

    }
    //排序用户信息菜单
    public void orderMenu (){

        boolean flag = true;
        while (flag){
            System.out.println("*********************");
            System.out.println("**   1　按姓名排序  　**");
            System.out.println("**   2　按年龄排序  　**");
            System.out.println("**   3　按性别排序  　**");
            System.out.println("**   4　查看全部纪录  **");
            System.out.println("**   5　返回上一级  　**");
            System.out.println("*********************");
            System.out.println("请输入正确的数字，最小是:1　最大是:5");

            String select = sc.nextLine(); //没想到nextLine能把回车问题解决
            switch (select){
                case "1":
                    //按姓名排序
                    o.orderName();
                    break;
                case "2":
                    o.orderAge();
                    break;
                case "3":
                    o.orderSex();
                    break;
                case "4":
                    o.showAll();
                    break;
                case "5":
                    //返回上一级,
                    flag=false;
                    break;
                default:
                    System.out.println("您输入的数字有误,请重新输入.");
                    break;
            }
        }
    }


}

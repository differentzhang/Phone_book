package com.love;

import java.io.*;
import java.util.*;

//业务处理类
public class Operate {

    private static ArrayList<Person> list = new ArrayList<>();
    static Menu menu = new Menu();


    Scanner sc = new Scanner(System.in);

    //用户添加信息业务逻辑控制
    public void addLogic(){
        //输入姓名
        System.out.println("输入姓名,1-10位字母");
        String name = sc.nextLine();
        //对用户输入姓名的验证
        String new_name = TelNoteRegex.nameRegex(name);


        //输入年龄
        System.out.println("输入年龄,1-120");
        String age = sc.nextLine();
        String new_age = TelNoteRegex.ageRegex(age);


        //输入性别
        System.out.println("输入性别,(男 m)(女 f)");
        String sex = sc.nextLine();
        String new_sex = TelNoteRegex.sexRegex(sex);


        //输入电话号码
        System.out.println("输入电话号码,11位数字,国内手机号");
        String telNum = sc.nextLine();
        String new_telNum = TelNoteRegex.telNumRegex(telNum);


        //输入地址
        System.out.println("输入地址,1-50位字母或数字");
        String address = sc.nextLine();
        String new_address = TelNoteRegex.addressRegex(address);
        Person p1 = new Person(new_name,new_age,new_sex,new_telNum,new_address);

        //判断添加重复人
        boolean isContains = false;
        for (Person person : list){
            if (person.getName().equals(new_name) || person.getAge().equals(new_age) || person.getSex().equals(new_sex)
                 || person.getTelNum().equals(new_telNum) || person.getAddress().equals(new_address)){
                isContains = true;
                break;
            }
        }
        if (isContains){
            System.out.println("添加失败,您本次添加的新用户已经添加过了.");
        } else {
            list.add(p1);
            System.out.println("添加成功!");
        }

    }

    //查询全部用户信息
    public void showAll(){
        if (list.isEmpty()){
            System.out.println("无记录!");
            return;
        }
        Iterator<Person> it = list.iterator();
        int id=0;
        while (it.hasNext()){
            Person person = it.next();
            id++;
            System.out.println("序号 "+id+"#"+person);
        }
    }

    //按姓名查询用户信息
    public void searchByName(String name){
        boolean flag = false;
        Person cur = null;
        int i;
        for ( i=0 ; i < list.size(); i++) {
            cur = list.get(i);
            if (cur.getName().equals(name)){
                System.out.println("序号 "+(i+1)+"#"+cur);
                flag = true;
            }
        }
        if (!flag){
            //没找到
            System.out.println("很抱歉,没有找到!");
        }
    }

    //按年龄查询用户信息
    public void searchByAge(String age){
        boolean flag = false;
        Person cur = null;
        int i;
        for ( i=0 ; i < list.size(); i++) {
            cur = list.get(i);
            if (cur.getAge().equals(age)){
                System.out.println("序号 "+(i+1)+"#"+cur);
                flag = true;
            }
        }
        if (!flag){
            //没找到
            System.out.println("很抱歉,没有找到!");
        }
    }

    //按性别查询用户信息
    public void searchBySex(String sex){
        boolean flag = false;
        Person cur = null;
        int i;
        for ( i=0 ; i < list.size(); i++) {
            cur = list.get(i);
            if (cur.getSex().equals(sex)){
                System.out.println("序号 "+(i+1)+"#"+cur);
                flag = true;
            }
        }
        if (!flag){
            //没找到
            System.out.println("很抱歉,没有找到!");
        }
    }

    //按电话号码查询用户信息
    public void searchByTelNum(String telNum){
        boolean flag = false;
        Person cur = null;
        int i;
        for ( i=0 ; i < list.size(); i++) {
            cur = list.get(i);
            if (cur.getTelNum().equals(telNum)){
                System.out.println("序号 "+(i+1)+"#"+cur);
                flag = true;
            }
        }
        if (!flag){
            //没找到
            System.out.println("很抱歉,没有找到!");
        }
    }

    //按地址查询用户信息
    public void searchByAdd(String address){
        boolean flag = false;
        Person cur = null;
        int i;
        for ( i=0 ; i < list.size(); i++) {
            cur = list.get(i);
            if (cur.getAddress().equals(address)){
                System.out.println("序号 "+(i+1)+"#"+cur);
                flag = true;
            }
        }
        if (!flag){
            //没找到
            System.out.println("很抱歉,没有找到!");
        }
    }

    //修改指定记录信息
    public void modify(){
        if (list.isEmpty()){
            System.out.println("无记录");
            return;
        }
        System.out.println("请输入记录序号");
        System.out.println("请输入正确的数字,"+"最小是:1 最大是:"+list.size());

        String ID = sc.nextLine();

        while (true){
            if (TelNoteRegex.isNum(ID) && Integer.parseInt(ID)>=1 && Integer.parseInt(ID)<= list.size()){
                break;
            }
            System.out.println("输入数字有误,请重新输入。");
            System.out.println("请输入正确的数字,"+"最小是:1 最大是:"+list.size());
            ID = sc.nextLine();
        }

        menu.subModifyMenu(ID);



    }

    //修改姓名
    public void editName(String ID){
        System.out.println("请输入新的姓名.");
        String new_name = sc.nextLine();
        String new_name1 = TelNoteRegex.nameRegex(new_name);

        Person person = list.get(Integer.parseInt(ID) - 1);
        person.setName(new_name1);
        list.set(Integer.parseInt(ID) - 1,person);
        System.out.println("修改成功!");
    }

    public void editAge(String ID){
        System.out.println("请输入新的年龄.");
        String new_age = sc.nextLine();
        String new_age1 = TelNoteRegex.ageRegex(new_age);

        Person person = list.get(Integer.parseInt(ID) - 1);
        person.setAge(new_age1);
        list.set(Integer.parseInt(ID) - 1,person);
        System.out.println("修改成功!");
    }
    public void editSex(String ID){
        System.out.println("请输入新的性别.");
        String new_sex = sc.nextLine();
        String new_sex1 = TelNoteRegex.nameRegex(new_sex);

        Person person = list.get(Integer.parseInt(ID) - 1);
        person.setSex(new_sex1);
        list.set(Integer.parseInt(ID) - 1,person);
        System.out.println("修改成功!");
    }
    public void editTelNum(String ID){
        System.out.println("请输入新的电话号.");
        String new_telNum = sc.nextLine();
        String new_telNum1 = TelNoteRegex.nameRegex(new_telNum);

        Person person = list.get(Integer.parseInt(ID) - 1);
        person.setTelNum(new_telNum1);
        list.set(Integer.parseInt(ID) - 1,person);
        System.out.println("修改成功!");
    }
    public void editAdd(String ID){
        System.out.println("请输入新的地址.");
        String new_address = sc.nextLine();
        String new_address1 = TelNoteRegex.nameRegex(new_address);

        Person person = list.get(Integer.parseInt(ID) - 1);
        person.setAddress(new_address1);
        list.set(Integer.parseInt(ID) - 1,person);
        System.out.println("修改成功!");
    }
    //删除指定用户信息
    public void delete(){
        if (list.isEmpty()){
            System.out.println("无记录");
            return;
        }
        System.out.println("请输入记录序号");
        System.out.println("请输入正确的数字,"+"最小是:1 最大是:"+list.size());

        String ID = sc.nextLine();

        while (true){
            if (TelNoteRegex.isNum(ID) && Integer.parseInt(ID)>=1 && Integer.parseInt(ID)<= list.size()){
                break;
            }
            System.out.println("输入数字有误,请重新输入。");
            System.out.println("请输入正确的数字,"+"最小是:1 最大是:"+list.size());
            ID = sc.nextLine();
        }

        list.remove(Integer.parseInt(ID)-1);
        System.out.println("删除成功!");

    }

    //删除全部用户信息
    public void deleteAll(){
        list.clear();
        System.out.println("成功删除全部记录!");
    }

    //IO 写入文件 全覆盖
    public  void saveFile(){

        FileWriter fw =null;
        try {
            fw = new FileWriter("homework/src/com/love/file1");
            for (Person p : list){
                fw.append(p.getName() + " ");
                fw.append(p.getAge() + " ");
                fw.append(p.getSex() + " ");
                fw.append(p.getTelNum() + " ");
                fw.append(p.getAddress() + " " + "\n");
            }
            fw.flush();
        }catch (Exception e){
            System.out.println("保存失败！异常信息："+e.getMessage());
        }finally {
            try {
                if (fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //IO 读取文件 全覆盖
    public  void readFile(){

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("homework/src/com/love/file1"));
            String len;
            while ((len=br.readLine())!=null){
                String[] len1 = len.trim().split(" ");
                Person p = new Person(len1[0],len1[1],len1[2],len1[3],len1[4]);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    //按用户姓名排序信息
    public void orderName(){
        Collections.sort(list,new NameComparator());
        System.out.println("排序成功! ");
    }

    //按用户年龄排序信息
    public void orderAge(){
        Collections.sort(list,new AgeComparator());
        System.out.println("排序成功! ");
    }

    //按用户性别排序信息
    public void orderSex(){
        Collections.sort(list,new SexComparator());
        System.out.println("排序成功! ");
    }

}

//自定义姓名排序类
class NameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        //String已经实现了compareTo比较器
        return o1.getName().compareTo(o2.getName());
    }
}

//自定义性别排序类
class SexComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        //String已经实现了compareTo比较器
        return o1.getSex().compareTo(o2.getSex());
    }
}

//自定义年龄排序类
class AgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        //String已经实现了compareTo比较器
        //age我感觉有点问题，应该是int类型的，但是这里是String的
        //这个问题写会再说
        //他这都用String类了,应该是防止类型报错

        //包装成Integer对象
        return Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
    }
}
package com.love;

//实体类
public class Person {
    //private int id; //用户ID 属性 这个去掉,用ArrayList自带的下标
    private String name; //用户姓名属性
    private String age; //用户年龄属性
    private String sex; //用户性别属性
    private String telNum; //用户电话号码属性
    private String address; //用户地址属性

    //无参数构造方法
    public Person() {
    }

    //有参数构造方法
    public Person(String name, String age, String sex, String telNum, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  ", 姓名'" + name + '\'' +
                ", 年龄'" + age + '\'' +
                ", 性别'" + sex + '\'' +
                ", 电话号码'" + telNum + '\'' +
                ", 住址'" + address + '\'';
    }
}

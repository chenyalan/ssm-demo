package com.zoe.demo.entity;

public class Order {
    private static int index;
    {
        System.out.println("{}调用一次Order"+index);
    }
    public Order(){
        System.out.println("无参构造器"+index);
    }

    static {
         index=100;
        System.out.println("测试静态代码块"+index);
    }
    public  Order(String orderName){
        this.orderName=orderName;
        System.out.println("调用有参构造函数"+orderName);
    }
    public Order(Integer id,String name){
        this(name);
        System.out.println("this()调用构造函数");
        this.id=id;
    }
    public static Order getInstance(){
        index++;
        return new Order();
    }
    private Integer id;

    private String orderName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }
}
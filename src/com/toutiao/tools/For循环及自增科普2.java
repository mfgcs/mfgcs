package com.toutiao.tools;

/**
 * JEP 358: Helpful NullPointerExceptions
 *
 */
public class JDK14新特性之NPE演示 {
    private  String name;
    public static void main(String[] args) {
        JDK14新特性之NPE演示 jdk=new JDK14新特性之NPE演示();
        jdk.getName().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

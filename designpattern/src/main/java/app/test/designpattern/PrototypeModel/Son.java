package app.test.designpattern.PrototypeModel;

import java.util.ArrayList;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.PrototypeModel
 * @class describe : 原型模式
 * @time 2018-02-08 10:23
 */
public class Son implements Cloneable {
    private String name;
    private int age;
    private double height;
    private double weight;
    private ArrayList<String> hobbies = new ArrayList<String>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Son() {

    }

    public Son(Son son) {
        super();
        this.name = son.name;
        this.age = son.age;
        this.height = son.height;
        this.weight = son.weight;
        this.hobbies = new ArrayList<String>(son.hobbies);
    }

    @Override
    public Object clone() {

        return new Son(this);
    }


/*
    @Override
    public Object clone() {

        Son son = null;
        try {
            son = (Son) super.clone();
            son.name = this.name;
            son.age = this.age;
            son.height = this.height;
            son.weight = this.weight;
            son.hobbies = (ArrayList<String>) this.hobbies.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return son;
    }
*/

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", hobbies=" + hobbies +
                '}';
    }
}

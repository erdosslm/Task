package kz.aitu.project.entity;

public class Student {
    public int id;
    public String name;
    public String phone;
    public int groupId;
    public Student (int id, String name, String phone, int groupId){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.groupId=groupId;

    }
    public String toString(){
        return this.id + " " + this.name + " " + this.phone + " " + this.groupId;
    }
}

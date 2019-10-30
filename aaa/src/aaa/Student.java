package aaa;

import java.io.Serializable;

public class Student implements Serializable {
    private String sid;
    private String sname;
    private String sword;
    private int isTrue;//1.被点 0 没有点过
 public Student(String sid){
	 this.sid=sid;
 }
    public Student(String sid, String sname, String sword, int isTrue) {
    	
    	this("xxx");
        this.sname = sname;
        this.sword = sword;
        this.isTrue = isTrue;
        
    }
    public Student(){
    	
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSword() {
        return sword;
    }

    public void setSword(String sword) {
        this.sword = sword;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }
    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sword='" + sword + '\'' +
                ", isTrue='" + isTrue + '\'' +
                '}';
    }
    
    
    public static void main(String[] args) {
		Student s= new Student();
		s.setSname("aaa");
		System.out.println(s.getSid()+""+s.getSname()+""+s.getSword());
    	
	}
}

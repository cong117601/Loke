package aaa;

class Person{
	private String name;//成员变量
	private int age;
	Person(){}
	Person(String name){//局部变量
		this.name=name;//1.用"this.成员变量名称"和重名的局部变量区分开来
	}
	Person(String name,int age){
		this(name);
//		this.name=name;
		this.age=age;
	}
	String getInfo(){//成员方法
		return "姓名：" + name + "\n年龄：" + age;
	}
	void print(){
		System.out.println(this.getInfo());//2.用"this.成员方法名"访问成员方法。
		System.out.println(getInfo());//这种情况this关键字一般不写，让编译器自动添加。
	}
}
public class  aa{
	public static void main(String[] args){
		Person p=new Person("张三",33);
		p.print();
	}
}

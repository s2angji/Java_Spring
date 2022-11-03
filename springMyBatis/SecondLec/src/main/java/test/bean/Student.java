package test.bean;

public class Student {
	String name;
	int age;
	MyData myData;
	public Student() {
		this.name = "";
		this.age = 0;
		this.myData = null;
	}
	public Student(String name, int age, MyData myData) {
		super();
		this.name = name;
		this.age = age;
		this.myData = myData;
	}
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
	public MyData getMyData() {
		return myData;
	}
	public void setMyData(MyData myData) {
		this.myData = myData;
	}
}

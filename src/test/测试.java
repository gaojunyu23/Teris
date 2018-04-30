package test;
class 动物{
	protected String 动物的属性;
	protected void 动物的方法(){
		System.out.println("我是动物，我不能写代码！");
	}
}
class 人类  extends 动物{
	private String   人特有的属性;
	private 动物     一种动物;
	public  人类(动物     一种动物){
		this.一种动物 = 一种动物;
		System.out.println("我是人，我可以写代码- -！");
	}
}
public class 测试{
	public static void main(String[] args) {
		动物  我是动物 = new 动物();
		人类  程序员 = new 人类(我是动物);
		程序员.动物的方法();
	}
}
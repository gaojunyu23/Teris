package test;
class ����{
	protected String ���������;
	protected void ����ķ���(){
		System.out.println("���Ƕ���Ҳ���д���룡");
	}
}
class ����  extends ����{
	private String   �����е�����;
	private ����     һ�ֶ���;
	public  ����(����     һ�ֶ���){
		this.һ�ֶ��� = һ�ֶ���;
		System.out.println("�����ˣ��ҿ���д����- -��");
	}
}
public class ����{
	public static void main(String[] args) {
		����  ���Ƕ��� = new ����();
		����  ����Ա = new ����(���Ƕ���);
		����Ա.����ķ���();
	}
}
package pojo;

public class Test_GetterAndSetter
{
	String name;
	Integer age;

	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public int getage()
	{
		return age;
	}
	public void setage(Integer age)
	{
		this.age=age;
	}

	public static void main(String[] args)
	{
		Test_GetterAndSetter ts = new Test_GetterAndSetter();

		ts.setname("Eder");
		String getnamevalue = ts.getname();
		System.out.println(getnamevalue);
	}

}

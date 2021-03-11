public class my_module{
	public void add(int a,int b){
	   System.out.println(a+b);
	}

	public void sub(int a,int b){
	   System.out.println(a-b);
	}

	public void mul(int a, int b){
	   System.out.println(a*b);
	}

	public void div(int a, int b){
	   System.out.println(a/b);
	}
	public static void main(String[] args){
	     my_module m = new my_module();
	     m.add(10,5);
	     m.sub(17,3);
	     m.mul(3,5);
	     m.div(8,2);
	     //주석
	}

}
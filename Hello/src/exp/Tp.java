package exp;


class Par{
	void method() {
		System.out.println("parent");
	}
}

class Child1 extends Par{
	void method() {
		System.out.println("child 1");
		
	}
}

class Child2 extends Par{
	void method() {
		System.out.println("child 2");
	}
}


public class Tp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Par par = new Child2(); 
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		
		par.method();
		child1.method();
		child2.method();

	}

}

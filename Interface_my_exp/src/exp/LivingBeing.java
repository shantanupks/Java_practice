package exp;

interface Human{
	public void height();
	public void weight();
	public void breath();
	void eats();
}

abstract class AbstractClass implements Human{
	public void breath() {
		
		System.out.println("Breathing");
		
	}
	public void eats() {
		System.out.println("eating");
		
	}
}


class Male extends AbstractClass implements Human{
	
	@Override
	public void breath() {
		// TODO Auto-generated method stub
		super.breath();
	}
	
	public void height() {
		System.out.println("More height");
		//..
	}
	
	@Override
	public void weight() {
		// TODO Auto-generated method stub
		System.out.println("More Weight");
	}
}

class Female extends AbstractClass implements Human{
	@Override
	public void breath() {
		// TODO Auto-generated method stub
		super.breath();
		//.............
	}
	
	
	
	@Override
	public void height() {
		// TODO Auto-generated method stub
	//........	
		System.out.println("less height");
	}
	
	@Override
	public void weight() {
		// TODO Auto-generated method stub
	//........	
	}
}

public class LivingBeing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human human = new Male();
		human.breath();
		human.height();
		
		System.out.println();
		
		human = new Female();
		human.breath();
		human.height();
		

	}

}

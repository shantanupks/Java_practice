package exp_v2;

public class LivingBeing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human human = new Male();
		human.breath();
		human.height();
		
		human = new Female();
		human.breath();
		human.height();

	}

}

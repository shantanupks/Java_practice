import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class FuncWrapper<T, R> implements Function<T, R>{

	private Function<T, R> functn;
	
	FuncWrapper(Function<T,R> function){
		this.functn = function;
	}
	
	FuncWrapper(Predicate<T> predicate){
		this.functn = (T t)-> {
			
			if( predicate.test(t) )
				return (R)t;
			else
				return null;
		};
	}
	
	FuncWrapper(Consumer<T> consumer){
		this.functn = (T t)->{
			consumer.accept(t);
			return null;
		};
	}
	@Override
	public R apply(T t) {
		return this.functn.apply(t);
	}
	
}


class FunctionCombiner<T, R>{

	private FuncWrapper<T, R> nextFunc;
	private FunctionCombiner nextCombiner;
	
	public FunctionCombiner map(Function<T, R> mapper) {
		nextFunc = new FuncWrapper(mapper);
		this.nextCombiner = new FunctionCombiner();
		return this.nextCombiner;
	}

	public FunctionCombiner filter(Predicate<T> pred) {
		nextFunc = new FuncWrapper(pred);
		this.nextCombiner = new FunctionCombiner();
		return this.nextCombiner;
	}
	
	public FunctionCombiner forEach(Consumer<T> consumer) {
		nextFunc = new FuncWrapper(consumer);
		this.nextCombiner = new FunctionCombiner();
		return this.nextCombiner;
	}
	
	public void start(List<T> data) {
		for(T t : data) {
			this.apply(t);
		}
	}
	
	public void apply(T t) {
		R r = nextFunc.apply(t);
		if( r != null && nextCombiner!= null)
			nextCombiner.apply(r);		
	}
}

public class Lib<T> {

	
	public static <T> List<T> filter(List<T> data, Predicate<T> pred) {
		List<T> resultList = new LinkedList<T>();
		for(T t : data) {
			if( pred.test(t) )
				resultList.add(t);
		}
		return resultList;
	}
	
	public static void main(String[] args) {

		Predicate<Product> pred = prod -> prod.getPrice() > 3000;

		Function<Product, String> mapper = Product::getName;

		Consumer<String> printer = System.out::println;

		FunctionCombiner functionCombiner = new FunctionCombiner();
		functionCombiner.filter(pred)
						.map(mapper)
						.forEach(printer);
		
		List<Product> data = Arrays.asList(
					new Product(234, "item-1", 8323.233),
					new Product(322, "item-2", 585.23)
				);
		functionCombiner.start(data );
	}
}

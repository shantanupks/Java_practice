import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

class WriteToFile{

	public static void writeToFile(String str) {
		File file = new File("file.txt");
		FileWriter writer=null;
		
		try {
			writer = new FileWriter(file);
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

public class Ex {
	public static void main(String[] args) {
		
		Consumer<String> fileWriter = s->System.out.println("file written");
		Consumer<String> logWriter = s->System.out.println("Log written");
		
		Consumer<String> composer = logWriter.andThen(fileWriter);
		
		composer.accept("dddd");
	}

}

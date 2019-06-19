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
		
		Consumer<String> consoleWriter = s->System.out.println(s);
		Consumer<String> fileWriter = s->WriteToFile.writeToFile(s);
		
		Consumer<String> composer = consoleWriter.andThen(fileWriter);
		
		composer.accept("dddd");
	}

}

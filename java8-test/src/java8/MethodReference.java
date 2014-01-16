package java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

	public static void main(String[] args) {
		File directory = new File("/home/ms/Entwicklung");
		
		
		//1) anonymous class
		List<File> resultAnonymous = Arrays.asList(directory.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile();
			}
		}));
		resultAnonymous.stream().forEach(new Consumer<File>() {
			@Override
			public void accept(File file) {
				System.out.println(file);
			}
		});
		
		
		//2) lambda
		List<File> resultLambda = Arrays.asList(directory.listFiles(file -> file.isFile()));
        resultLambda.stream().forEach(file -> System.out.println(file));
		
        
		//3) method reference
		List<File> resultMethodReference = Arrays.asList(directory.listFiles(File::isFile));
		resultMethodReference.stream().forEach(System.out::println);
	}
	
}

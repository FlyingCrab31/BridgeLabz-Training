package com.practice.junit.fileprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {
	
	public void writeToFile(String fileName,String content) throws IOException{
		Files.write(Path.of(fileName),content.getBytes());
	}
	
	public String readFromFile(String fileName) throws IOException{
		return Files.readString(Path.of(fileName));
	}
	
	

}

package com.practice.junit.fileprocessor;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

	private FileProcessor fileprocessor;
	private Path testFile;
	
	
	@BeforeEach
	
	void setUp() {
		fileprocessor=new FileProcessor();
		testFile=Path.of("testFile.txt");
	}
	
	@AfterEach
	
	void cleanUp() throws IOException{
		Files.deleteIfExists(testFile);
	}
	
	@Test
	
	void testWriteAndReadFiles() throws IOException{
		String content="Hello guys this is Rishabh";
		
		fileprocessor.writeToFile(testFile.toString(),content);
		String result=fileprocessor.readFromFile(testFile.toString());
		
		
	}
	
	
	@Test
	
	void testFileExistsAfterWrite() throws IOException{
		fileprocessor.writeToFile(testFile.toString(),"Some content" );
		assertTrue(Files.exists(testFile));
	}
	
	
	@Test
	
	void testReadNonExistingFileThrowsException() {
		assertThrows(IOException.class,()->{
			fileprocessor.readFromFile("no such file exists");
		});
	}
}

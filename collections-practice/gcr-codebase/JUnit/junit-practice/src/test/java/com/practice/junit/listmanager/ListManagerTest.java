package com.practice.junit.listmanager;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
	
	ListManager manager=new ListManager();
	
	@Test
	
	void testAddElement() {
		List<Integer> list=new ArrayList<>();
		manager.addElement(list, 5);
		manager.addElement(list, 10);
		assertEquals(2,list.size());
		assertTrue(list.contains(5));
		assertTrue(list.contains(10));
		
		
	}
	
	
	@Test
	
	void testRemoveElement() {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		manager.removeElement(list, 2);
		assertEquals(2,list.size());
		assertFalse(list.contains(2));
		
	}
	
	@Test
	
	void testGetSize() {
		
		List<Integer> list=new ArrayList<>();
		assertEquals(0,manager.getSize(list));
		list.add(1);
		list.add(2);
		assertEquals(2,manager.getSize(list));
	}
	
	
	


	

}

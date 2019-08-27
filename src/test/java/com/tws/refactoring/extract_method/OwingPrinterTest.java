package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
    	OwingPrinter owingPrinter = new OwingPrinter();
    	Order order1 = new Order(2);
    	Order order2 = new Order(3);
    	List<Order> orders = new List();
    	orders.add(order1);
    	orders.add(order2);
    	
    	
    	double outstanding = owingPrinter.printOwing(orders);
    	//owingPrinter.printString("order", outstanding);
        
        assertEquals("5", outstanding);
    }
   
}
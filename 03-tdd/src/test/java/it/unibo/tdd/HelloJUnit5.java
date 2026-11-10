package it.unibo.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

public class HelloJUnit5 {
    @BeforeEach
    public void setUp() { 
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void tearDown() { 
        System.out.println("@AfterEach");
    }

    @Test
    public void helloJunit5() {
        Multipli num = new Multipli();
        Assertions.assertEquals("1", num.fizzBuzz(1));
        Assertions.assertEquals("Fizz", num.fizzBuzz(3));
        Assertions.assertEquals("Buzz", num.fizzBuzz(5));
        Assertions.assertEquals("FizzBuzz", num.fizzBuzz(15));
        
        //New requirements  
        Assertions.assertEquals("Fizz", num.fizzBuzz(13));
        Assertions.assertEquals("Buzz", num.fizzBuzz(1547));
        Assertions.assertEquals("FizzBuzz", num.fizzBuzz(1534));
    }    
}

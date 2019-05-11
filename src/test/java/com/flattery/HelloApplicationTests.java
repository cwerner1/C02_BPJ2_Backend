package com.flattery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {


    private HelloController object;
    private BindingAwareModelMap model;

    @Before
    public void setUp() throws Exception {
        this.object = new HelloController();
        this.model = new BindingAwareModelMap();

    }

    @Test
    public void indexTest() throws Exception {
        assertEquals("Greetings from Spring Boot!", this.object.index());
    }

    @Test
    public void helloTest() throws Exception {
        assertEquals("TestPage", this.object.test());
    }

    @Test
    public void tobiasTest() throws Exception {
        assertEquals("Tobias!", this.object.tobias());
    }
}


package com.flattery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient


public class ZGreetingControllerTest {

    private Z_GreetingController object;
    private BindingAwareModelMap model;

    @Before
    public void setUp() throws Exception {
        this.object = new Z_GreetingController();
        this.model = new BindingAwareModelMap();

    }

    @Test
    public void exampleTest() throws Exception {
        assertEquals("greeting", this.object.greeting("name", this.model));
    }
}
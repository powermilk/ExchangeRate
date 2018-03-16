package com.powermilk;

import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing ExchangeRate class")
@SelectPackages("com.powermilk")
class ExchangeRateTest {
    private static final Logger log = LoggerFactory.getLogger(ExchangeRateTest.class);

    private ExchangeRate exchangeRate;
    private FileReader fileReader;
    private String path = "exchangeRate.json";

    @Rule
    public ExpectedException expectedThrown = ExpectedException.none();

    @BeforeEach
    public void init() throws Exception {
        File file = new File(this.getClass().getResource("/" + path).getFile());
        fileReader = new FileReader(file);
        exchangeRate = new ExchangeRate(fileReader);
        log.info("Test started!");
    }

    @AfterEach
    public void tearDown() {
        exchangeRate = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Should throws MalformedURLException")
    void shouldThrowMalformedURLException() {
        String badUrl = "htp://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json";
        expectedThrown.expect(MalformedURLException.class);
        exchangeRate = new ExchangeRate(badUrl);
    }

    @Test
    @DisplayName("Should throws NullPointerException")
    void shouldThrowNullPointerException()  {
        String badPath = "exchangeRate.jon";
        URL resource = this.getClass().getResource(badPath);
        try {
            String fileName = resource.getFile();
            File file = new File(fileName);
            fileReader = new FileReader(file);
            exchangeRate = new ExchangeRate(fileReader);
        } catch (NullPointerException | FileNotFoundException e) {
            expectedThrown.expect(NullPointerException.class);
            log.error(e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throws FileNotFoundException")
    void shouldThrowFileNotFoundException()  {
        String badPath = "NonExist.json";
        try {
            fileReader = new FileReader(badPath);
            exchangeRate = new ExchangeRate(fileReader);
        } catch (FileNotFoundException e) {
            expectedThrown.expect(FileNotFoundException.class);
            log.error(e.getMessage());
        }
    }

    @Test
    @DisplayName("Getting max value")
    void shouldReturnMaxValue() {
        double max = exchangeRate.getMax();
        assertEquals(4.7387D, max);
        log.info("Test passed!");
    }

    @Test
    @DisplayName("Getting min value")
    void shouldReturnMinValue() {
        double min = exchangeRate.getMin();
        assertEquals(4.6663D, min);
        log.info("Test passed!");
    }
}
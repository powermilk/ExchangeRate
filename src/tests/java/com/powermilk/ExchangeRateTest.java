package com.powermilk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing ExchangeRate class")
@SelectPackages("com.powermilk")
class ExchangeRateTest {
    private static final Logger log = LoggerFactory.getLogger(ExchangeRateTest.class);

    private ExchangeRate exchangeRate;
    private FileReader fileReader;
    private String path = "exchangeRate.json";

    @BeforeEach
    void init() throws Exception {
        File file = new File(this.getClass().getResource("/" + path).getFile());
        fileReader = new FileReader(file);
        exchangeRate = new ExchangeRate(fileReader);
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        exchangeRate = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Should throws MalformedURLException")
    void shouldThrowMalformedURLException() {
        String badUrl = "htp://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json";

        Throwable exception = assertThrows(MalformedURLException.class,
                () -> new ExchangeRate(badUrl));

        assertEquals(exception.getMessage(), "unknown protocol: htp");
        log.info("Test checking MalformedURLException was thrown passed!");
    }

    @Test
    @DisplayName("Should throws NullPointerException")
    void shouldThrowNullPointerException()  {
        String badPath = "exchangeRate.jon";
        URL resource = this.getClass().getResource(badPath);
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            String fileName = resource.getFile();
            File file = new File(fileName);
            fileReader = new FileReader(file);
            exchangeRate = new ExchangeRate(fileReader);
        });

        assertNull(exception.getMessage());
        log.info("Test checking NullPointerException was thrown passed!");
    }

    @Test
    @DisplayName("Should throws FileNotFoundException")
    void shouldThrowFileNotFoundException()  {
        String badPath = "NonExist.json";
        Throwable exception = assertThrows(FileNotFoundException.class, () -> {
            fileReader = new FileReader(badPath);
            exchangeRate = new ExchangeRate(fileReader);
        });

        assertEquals(exception.getMessage(), "NonExist.json (Nie ma takiego pliku ani katalogu)");
        log.info("Test checking FileNotFoundException was thrown passed!");
    }

    @Test
    @DisplayName("Getting maximum value")
    void shouldReturnMaxValue() throws Exception {
        double max = exchangeRate.getMax();
        assertEquals(4.7387D, max);
        log.info("Test checking that maximum value was got passed!");
    }

    @Test
    @DisplayName("Getting minimum value")
    void shouldReturnMinValue() throws Exception {
        double min = exchangeRate.getMin();
        assertEquals(4.6663D, min);
        log.info("Test checking that minimum value was got passed!");
    }
}
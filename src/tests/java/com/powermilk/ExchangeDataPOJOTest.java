package com.powermilk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing RatePOJOTest class")
@SelectPackages("com.powermilk")
class ExchangeDataPOJOTest {
    private static final Logger log = LoggerFactory.getLogger(RatePOJOTest.class);
    private static RatePOJO ratePOJO1;
    private static RatePOJO ratePOJO2;
    private static List<RatePOJO> ratePOJOList;
    private static ExchangeDataPOJO exchangeDataPOJO;

    @BeforeEach
    void setUp() {
        ratePOJO1 = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);
        ratePOJO2 = new RatePOJO("248/A/NBP/2017", "2017-12-22", 4.7387d);
        ratePOJOList = Arrays.asList(ratePOJO1, ratePOJO2);
        exchangeDataPOJO = new ExchangeDataPOJO("C", "funt szterling", "GBP", ratePOJOList);

        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        ratePOJO1 = null;
        ratePOJO2 = null;
        ratePOJOList = null;
        exchangeDataPOJO = null;

        log.info("Test finished!");
    }

    @Test
    @DisplayName("Test that equals() is reflexive")
    void shouldReturnTrueForReflexive() {
        assertEquals(exchangeDataPOJO, exchangeDataPOJO);
        assertSame(exchangeDataPOJO, exchangeDataPOJO);

        log.info("Test for checking that equals() is reflexive!");
    }

    @Test
    @DisplayName("Test that equals() is symmetric")
    void shouldReturnTrueForSymmetric() {
        ExchangeDataPOJO newData = new ExchangeDataPOJO("C", "funt szterling", "GBP", ratePOJOList);

        assertEquals(exchangeDataPOJO, newData);
        assertEquals(newData, exchangeDataPOJO);

        assertTrue(exchangeDataPOJO.equals(newData) && newData.equals(exchangeDataPOJO));

        assertNotSame(exchangeDataPOJO, newData);

        log.info("Test for checking that equals() is symmetric!");
    }

    @Test
    @DisplayName("Test that equals() is transitive")
    void shouldReturnTrueForTransitive() {
        ExchangeDataPOJO newData1 = new ExchangeDataPOJO("C", "funt szterling", "GBP", ratePOJOList);
        ExchangeDataPOJO newData2 = new ExchangeDataPOJO("C", "funt szterling", "GBP", ratePOJOList);

        assertEquals(exchangeDataPOJO, newData1);
        assertEquals(newData1, newData2);
        assertEquals(exchangeDataPOJO, newData2);

        assertTrue(exchangeDataPOJO.equals(newData1) && newData1.equals(newData2) &&
                exchangeDataPOJO.equals(newData2));

        assertNotSame(exchangeDataPOJO, newData1);
        assertNotSame(newData1, newData2);
        assertNotSame(exchangeDataPOJO, newData2);

        log.info("Test for checking that equals() is transitive!");
    }

    @Test
    @DisplayName("Test that equals() returns false for null")
    void shouldReturnFalseForNull() {
        assertNotEquals(exchangeDataPOJO, null);

        log.info("Test for checking that equals() returns false for null!");
    }

    @Test
    @DisplayName("Test that equals() returns false for two different")
    void shouldReturnFalseForTwoDifferentObject() {
        ExchangeDataPOJO newData = new ExchangeDataPOJO("A", "funt szterling", "GBP", ratePOJOList);

        assertNotEquals(exchangeDataPOJO, newData);

        log.info("Test for checking that equals() returns false for two different!");
    }

    @Test
    @DisplayName("Test that hashcode() returns true for self")
    void shouldHashcodeReturnsTrueForSelf() {
        assertEquals(exchangeDataPOJO.hashCode(), exchangeDataPOJO.hashCode());

        assertSame(exchangeDataPOJO, exchangeDataPOJO);

        log.info("Test for checking that hashcode() returns true for self passed!");

    }

    @Test
    @DisplayName("Test that hashcode() returns true for two same objects")
    void shouldHashcodeReturnsTrueForTwoSameObjects() {
        ExchangeDataPOJO newData = new ExchangeDataPOJO("C", "funt szterling", "GBP", ratePOJOList);

        assertNotSame(exchangeDataPOJO, newData);

        assertEquals(exchangeDataPOJO.hashCode(), newData.hashCode());

        log.info("Test for checking that hashcode() returns true for two same objects passed!");
    }

    @Test
    @DisplayName("Test contract equals-hashcode")
    void shouldContractPass() {
        EqualsVerifier.forClass(ExchangeDataPOJO.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .usingGetClass()
                .verify();
        log.info("Test for contract equals-hashcode passed!");
    }

    @Test
    @DisplayName("Test that toString() is generating empty string")
    void shouldGenerateEmptyString() {
        ExchangeDataPOJO newData = new ExchangeDataPOJO();
        String actual = newData.toString();

        final String regex = "^com\\.powermilk\\.ExchangeDataPOJO@\\w+\\[\\n\\s+table=<null>\\n\\s+currency=<null>" +
                "\\n\\s+code=<null>\\n\\s+rates=<null>\\n]$";

        assertTrue(actual.matches(regex));

        log.info("Test for checking that toString() is generating empty string!");
    }

    @Test
    @DisplayName("Test that toString() is generating properly")
    void shouldGenerateValidString() {
        String actual = exchangeDataPOJO.toString();

        final String regex = "^com\\.powermilk\\.ExchangeDataPOJO@\\w+\\[\\n\\s+table=C\\n\\s+currency=funt " +
                "szterling\\n\\s+code=GBP\\n\\s+rates=\\[com\\.powermilk\\.RatePOJO@\\w+\\[\\n\\s+no=247/A/NBP/2017" +
                "\\n\\s+effectiveDate=2017-12-21\\n\\s+mid=4\\.7318\\n], com\\.powermilk\\.RatePOJO@\\w+\\[\\n\\s+" +
                "no=248/A/NBP/2017\\n\\s+effectiveDate=2017-12-22\\n\\s+mid=4\\.7387\\n]]\\n]$";

        assertTrue(actual.matches(regex));
        log.info("Test for checking that toString() is generating properly!");
    }

}
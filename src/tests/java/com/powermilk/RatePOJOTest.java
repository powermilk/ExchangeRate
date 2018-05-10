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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing RatePOJOTest class")
@SelectPackages("com.powermilk")
class RatePOJOTest {
    private static final Logger log = LoggerFactory.getLogger(RatePOJOTest.class);
    private static RatePOJO ratePOJO;

    @BeforeEach
    void init() {
        ratePOJO = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        ratePOJO = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Test that equals() is reflexive")
    void shouldReturnTrueForReflexive() {
        assertEquals(ratePOJO, ratePOJO);
        assertSame(ratePOJO, ratePOJO);

        log.info("Test for checking that equals() is reflexive!");
    }

    @Test
    @DisplayName("Test that equals() is symmetric")
    void shouldReturnTrueForSymmetric() {
        RatePOJO newRatePOJO = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);
        
        assertEquals(newRatePOJO, ratePOJO);
        assertEquals(ratePOJO, newRatePOJO);

        assertTrue(ratePOJO.equals(newRatePOJO) && newRatePOJO.equals(ratePOJO));

        assertNotSame(ratePOJO, newRatePOJO);

        log.info("Test for checking that equals() is symmetric!");
    }

    @Test
    @DisplayName("Test that equals() is transitive")
    void shouldReturnTrueForTransitive() {
        RatePOJO newRatePOJO1 = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);
        RatePOJO newRatePOJO2 = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);

        assertEquals(ratePOJO, newRatePOJO1);
        assertEquals(newRatePOJO1, newRatePOJO2);
        assertEquals(ratePOJO, newRatePOJO2);

        assertTrue(ratePOJO.equals(newRatePOJO1) && newRatePOJO1.equals(newRatePOJO2) && ratePOJO.equals(newRatePOJO2));

        assertNotSame(ratePOJO, newRatePOJO1);
        assertNotSame(newRatePOJO1, newRatePOJO2);
        assertNotSame(ratePOJO, newRatePOJO2);

        log.info("Test for checking that equals() is transitive!");
    }

    @Test
    @DisplayName("Test that equals() returns false for null")
    void shouldReturnFalseForNull() {
        assertNotEquals(ratePOJO, null);

        log.info("Test for checking that equals() returns false for null!");
    }

    @Test
    @DisplayName("Test that equals() returns false for two different")
    void shouldReturnFalseForTwoDifferentObject() {
        RatePOJO newRatePOJO = new RatePOJO("248/A/NBP/2017", "2017-12-22", 4.7387d);

        assertNotEquals(ratePOJO, newRatePOJO);

        log.info("Test for checking that equals() returns false for two different!");
    }

    @Test
    @DisplayName("Test that hashcode() returns true for self")
    void shouldHashcodeReturnsTrueForSelf() {
        assertEquals(ratePOJO.hashCode(), ratePOJO.hashCode());

        assertSame(ratePOJO, ratePOJO);

        log.info("Test for checking that hashcode() returns true for self passed!");

    }

    @Test
    @DisplayName("Test that hashcode() returns true for two same objects")
    void shouldHashcodeReturnsTrueForTwoSameObjects() {
        RatePOJO newRatePOJO1 = new RatePOJO("247/A/NBP/2017", "2017-12-21", 4.7318d);

        assertNotSame(ratePOJO, newRatePOJO1);

        assertEquals(ratePOJO.hashCode(), newRatePOJO1.hashCode());

        log.info("Test for checking that hashcode() returns true for two same objects passed!");
    }

    @Test
    @DisplayName("Test contract equals-hashcode")
    void shouldContractPass() {
        EqualsVerifier.forClass(RatePOJO.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .usingGetClass()
                .verify();
        log.info("Test for contract equals-hashcode passed!");
    }

    @Test
    @DisplayName("Test that toString() is generating empty string")
    void shouldGenerateEmptyString() {
        RatePOJO newRatePOJO = new RatePOJO();

        String actual = newRatePOJO.toString();
        String expected = "^com\\.powermilk\\.RatePOJO@\\w+\\[no=<null>,effectiveDate=<null>,mid=0.0]$";

        assertTrue(actual.matches(expected));

        log.info("Test for checking that toString() is generating empty string!");
    }

    @Test
    @DisplayName("Test that toString() is generating properly")
    void shouldGenerateValidString() {
        String actual = ratePOJO.toString();
        String expected = "^com\\.powermilk\\.RatePOJO@\\w+\\[no=247/A/NBP/2017,effectiveDate=2017-12-21,mid=" +
                "4.7318]$";

        assertTrue(actual.matches(expected));

        log.info("Test for checking that toString() is generating properly!");
    }
}
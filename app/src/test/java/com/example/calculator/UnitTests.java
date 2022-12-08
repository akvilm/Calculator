package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTests {
    @Test
    public void Given_StringValue_When_removeLastCharacterIsCalled_Then_StringWithoutLastCharacterIsReturned() {
        final String givenString = "11+";

        final String expectedResult = "11";
        final String actualResult = MainActivity.removeLastCharacter(givenString);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void Given_EmptyString_When_removeLastCharacterIsCalled_Then_EmptyStringIsReturned() {
        final String givenString = "";

        final String expectedResult = "";
        final String actualResult = MainActivity.removeLastCharacter(givenString);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void Given_NullString_When_removeLastCharacterIsCalled_Then_EmptyStringIsReturned(){
        final String givenString = null;

        final String expectedResult = "";
        final String actualResult = MainActivity.removeLastCharacter(givenString);

        assertEquals(expectedResult,actualResult);
    }

}
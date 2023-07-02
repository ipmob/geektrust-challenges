package com.example.geektrust;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testMain() throws IOException {
        // Arrange
        // Arrange
        String input = "2\n0 0 N\n0 0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);

        // Act
        Main.main(new String[]{"sample_input/input1.txt"}); // Provide a dummy filename here

        // Assert
        String expectedOutput = "POWER 145\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
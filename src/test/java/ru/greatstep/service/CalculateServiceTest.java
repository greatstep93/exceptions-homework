package ru.greatstep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.greatstep.service.CalculateService.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.greatstep.exceptions.BadFormatException;
import ru.greatstep.exceptions.NotNumberException;

class CalculateServiceTest {

    @Test
    @DisplayName("Ожидается успешное сложение")
    void When_CalculateSum_Expect_Success() {
        assertEquals(20, calculate("10 + 10"), "при вводе 10 + 10 ожидается ответ 20");
        assertEquals(30, calculate("10 + 20"), "при вводе 10 + 20 ожидается ответ 30");
        assertEquals(5, calculate("-5 + 10"), "при вводе -5 + 10 ожидается ответ 5");
    }

    @Test
    @DisplayName("Ожидается успешное вычитаение")
    void When_CalculateDifferent_Expect_Success() {
        assertEquals(5, calculate("10 - 5"), "при вводе 10 - 5 ожидается ответ 5");
        assertEquals(-5, calculate("10 - 15"), "при вводе 10 - 15 ожидается ответ -5");
        assertEquals(50, calculate("100 - 50"), "при вводе 100 - 50 ожидается 50");
    }

    @Test
    @DisplayName("Ожидается успешное умножение")
    void When_CalculateMultiply_Expect_Success() {
        assertEquals(50, calculate("10 * 5"), "при вводе 10 * 5 ожидается ответ 50");
        assertEquals(-25, calculate("-5 * 5"), "при вводе -5 * 5 ожидается ответ -25");
        assertEquals(25, calculate("-5 * -5"), "при вводе -5 * -5 ожидается ответ 25");
    }

    @Test
    @DisplayName("Ожидается успешное деление")
    void When_CalculateDivision_Expect_Success() {
        assertEquals(2, calculate("10 / 5"), "при вводе 10 / 5 ожидается ответ 2");
        assertEquals(3, calculate("10 / 3"), "при вводе 10 / 3 ожидается ответ 3");
        assertEquals(-2, calculate("-10 / 5"), "при вводе -10 / 5 ожидается ответ -2");
    }

    @Test
    @DisplayName("Ожидается ошибка BadFormatException")
    void When_Calculate_Expect_BadFormatException() {
        assertThrows(BadFormatException.class,
                () -> calculate("1+1"), "при вводе 1+1 ожидается исключение BadFormatException");
        assertThrows(BadFormatException.class,
                () -> calculate("-1+-1"), "при вводе 1+1 ожидается исключение BadFormatException");
        assertThrows(BadFormatException.class,
                () -> calculate("1-+1"), "при вводе 1+1 ожидается исключение BadFormatException");
    }

    @Test
    @DisplayName("Ожидается ошибка NotNumberException")
    void When_Calculate_Expect_NotNumberException() {
        assertThrows(NotNumberException.class,
                () -> calculate("a + 1"), "при вводе a + 1 ожидается исключение NotNumberException");
        assertThrows(NotNumberException.class,
                () -> calculate("1 + d"), "при вводе 1 + d ожидается исключение NotNumberException");
        assertThrows(NotNumberException.class,
                () -> calculate("b + b"), "при вводе b + b ожидается исключение NotNumberException");
    }

}
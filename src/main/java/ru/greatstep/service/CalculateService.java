package ru.greatstep.service;

import ru.greatstep.exceptions.BadFormatException;
import ru.greatstep.exceptions.NotNumberException;

public class CalculateService {


    public static int calculate(String inputLine) throws BadFormatException {
        String[] string = inputLine.split(" ");
        if (string.length != 3){
            throw new BadFormatException("Вы ввели не тот формат");
        }
        try {
            int a = Integer.parseInt(string[0]);
            int b = Integer.parseInt(string[2]);
            String operation = string[1];


            return switch (operation) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;

                default -> throw new BadFormatException("Вы ввели неверный формат ");
            };
        } catch (NumberFormatException e){
            throw new NotNumberException("Вы ввели не число");
        }
    }
}

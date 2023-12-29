package ru.greatstep;

import static ru.greatstep.util.Constants.HELLO;

import java.util.Scanner;

import ru.greatstep.exceptions.BadFormatException;
import ru.greatstep.service.CalculateService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(HELLO);
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("exit")) {

            var result = CalculateService.calculate(inputLine);
            System.out.println(result);

            System.out.println(HELLO);
            inputLine = scanner.nextLine();

        }
    }

}

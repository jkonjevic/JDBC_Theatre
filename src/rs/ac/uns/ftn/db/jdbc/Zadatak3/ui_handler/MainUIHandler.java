package rs.ac.uns.ftn.db.jdbc.Zadatak3.ui_handler;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.service.AkcijaService;

import java.sql.SQLException;
import java.util.Scanner;

public class MainUIHandler {
    public static Scanner sc = new Scanner(System.in);
    private final ComplexQueryUIHandler complexQueryUIHandler = new ComplexQueryUIHandler();
    private final AkcijeUIHandler akcijeUIHandler = new AkcijeUIHandler();

    public void handleMainMenu() throws SQLException {

        String answer;
        do {
            System.out.println("\nOdaberite opciju:");
            System.out.println("1 - Rukovanje Akcijama");
            System.out.println("2 - Kompleksni upiti");
            System.out.println("X - Izlazak iz programa");

            answer = sc.nextLine();

            switch (answer) {
                case "1":
                    akcijeUIHandler.handleAkcijeMenu();
                    break;
                case "2":
                    complexQueryUIHandler.handleComplexQueryMenu();
                    break;
                case "3":
                    complexQueryUIHandler.handleComplexQueryMenu();
                    break;
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}


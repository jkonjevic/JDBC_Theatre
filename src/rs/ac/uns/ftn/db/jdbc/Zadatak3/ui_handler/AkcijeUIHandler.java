package rs.ac.uns.ftn.db.jdbc.Zadatak3.ui_handler;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.service.AkcijaService;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.service.KomponentaService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AkcijeUIHandler {
    private static final AkcijaService akcijaService = new AkcijaService();
    private static final KomponentaService komponentaService = new KomponentaService();

    public void  handleAkcijeMenu() throws SQLException {
        String answer;
        do {
            System.out.println("\nOdaberite opciju za rad nad Akcijama:");
            System.out.println("1 - Prikaz svih");
            System.out.println("2 - Prikaz po identifikatoru");
            System.out.println("3 - Unos jedne Akcije");
            System.out.println("4 - Unos vise Akcija");
            System.out.println("5 - Izmena po identifikatoru");
            System.out.println("6 - Brisanje po identifikatoru i skidanje komponenti sa akcija (5)");
            System.out.println("X - Izlazak iz rukovanja Akcijama");

            answer = MainUIHandler.sc.nextLine();

            switch (answer) {
                case "1":
                    showAll();
                    break;
                case "2":
                    showById();
                    break;
                case "3":
                    handleSingleInsert();
                    break;
                case "4":
                    handleMultipleInserts();
                    break;
                case "5":
                    handleUpdate();
                    break;
                case "6":
                    handleDelete();
                    break;
            }

        } while (!answer.equalsIgnoreCase("X"));
    }

    private void showAll() throws SQLException {
        System.out.println(Akcija.getFormattedHeader());

        try {
            for (Akcija a1 : akcijaService.getAll()) {
                System.out.println(a1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void showById() throws SQLException{
        System.out.println("ID Akcije: ");
        int id = Integer.parseInt(MainUIHandler.sc.nextLine());

        try {
            Akcija akcija = akcijaService.getById(id);
            System.out.println(Akcija.getFormattedHeader());
            System.out.println(akcija);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleSingleInsert()throws SQLException {
        System.out.println("IDA: ");
        int ida = Integer.parseInt(MainUIHandler.sc.nextLine());

        System.out.println("Naziv: ");
        String naziva = MainUIHandler.sc.nextLine();

        System.out.println("Popust: ");
        int popust = Integer.parseInt(MainUIHandler.sc.nextLine());


        try {
            akcijaService.save(new Akcija(ida, naziva, popust));
            System.out.println("Dodavanje uspesno.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleUpdate()throws SQLException {
        System.out.println("ID akcije: ");
        int ida = Integer.parseInt(MainUIHandler.sc.nextLine());

        try {
            if (!akcijaService.existsById(ida)) {
                System.out.println("Uneta vrednost ne postoji!");
                return;
            }

            System.out.println("Naziv: ");
            String naziva = MainUIHandler.sc.nextLine();

            System.out.println("popust: ");
            int popust = Integer.parseInt(MainUIHandler.sc.nextLine());


            boolean success = akcijaService.save(new Akcija(ida, naziva, popust));
            if (success) {
                System.out.println("akcija uspesno izmenjena.");
            } else {
                System.out.println("Izmena akcija nije uspela.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleDelete()throws SQLException {
        System.out.println("ID akcije: ");
        int id = Integer.parseInt(MainUIHandler.sc.nextLine());
        int x = 0;

        try {
            Akcija akcija = akcijaService.getById(id);
            x = komponentaService.saveAllDeleteAkcije(id);
            boolean success = akcijaService.deleteById(id);
            if (success) {
                System.out.println("Akcija uspesno obrisana.");
            } else {
                System.out.println("Brisanje akcije nije uspelo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleTransactionalDelete()throws SQLException {
        System.out.println("ID akcije: ");
        int id = Integer.parseInt(MainUIHandler.sc.nextLine());

        try {
            Akcija akcija = akcijaService.getById(id);
            boolean success = akcijaService.deleteTransactional(id);
            if (success) {
                System.out.println("Akcija uspesno obrisana.");
            } else {
                System.out.println("Brisanje akcije nije uspelo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleMultipleInserts()throws SQLException {
        List<Akcija> theatreList = new ArrayList<>();
        String answer;
        do {
            System.out.println("ID Akcije: ");
            int ida = Integer.parseInt(MainUIHandler.sc.nextLine());

            System.out.println("Naziv: ");
            String naziva = MainUIHandler.sc.nextLine();

            System.out.println("Popust: ");
            int popust = Integer.parseInt(MainUIHandler.sc.nextLine());



            theatreList.add(new Akcija(ida,naziva,popust));

            System.out.println("Prekinuti unos? X za potvrdu");
            answer = MainUIHandler.sc.nextLine();
        } while (!answer.equalsIgnoreCase("X"));

        try {
            int rowsSaved = akcijaService.saveAll(theatreList);
            System.out.println("Uspesno ažurirano " + rowsSaved + " akcija.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


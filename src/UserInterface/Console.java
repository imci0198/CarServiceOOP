package UserInterface;

import Domain.ClientEntry;
import Service.ClientEntryService;

import java.security.KeyException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Console {
    public ClientEntryService clientEntryService;
    Scanner in = new Scanner(System.in);

    public Console(ClientEntryService clientEntryService) {
        this.clientEntryService = clientEntryService;
    }

    public void runUserInterface() {

        while (true) {
            showMenu();
            String option = in.nextLine();
            if ("1".equals(option)) {
                this.handleAddClientEntry();
            } else if ("2".equals(option)) {
                this.handleExitService();
            } else if ("3".equals(option)) {
                this.handleShowAll();
            } else if ("4".equals(option)) {
                //TODO handleShowAllEntries
            } else if ("x".equals(option)) {
                break;
            }
        }
    }

    private void handleExitService() {
        System.out.println("Stand number:");
        int standNumber = in.nextInt();
        System.out.println("Billed Price:");
        double billedPrice = in.nextDouble();
        in.nextLine();
        System.out.println("Report:");
        String report = in.nextLine();

        try {
            this.clientEntryService.exitService(standNumber,billedPrice,report);
        } catch (KeyException e) {
            System.out.println(e.getMessage());
        }

    }



    private void handleShowAll() {
        for (ClientEntry clientEntry : this.clientEntryService.getAll()) {
            System.out.println(clientEntry.toString());
        }
    }
    private void handleAddClientEntry() {
            try {
                System.out.println("Give entry ID:");
                int idClientEntry = in.nextInt();
                System.out.println("Give stand number:");
                int standNumber = in.nextInt();
                System.out.println("License plate:");
                in.nextLine();
                String licensePlate = in.nextLine();
                System.out.println("Number of days in service:");
                int numberOfDays = in.nextInt();
                in.nextLine(); //TODO verifica de ce trebuie si aici preluat enterul,altfel afiseaza de 2 ori meniul. nu inteleg de ce

                this.clientEntryService.addClientEntryService(idClientEntry, standNumber, licensePlate, numberOfDays);


            } catch (KeyException keyException) {
                System.out.println(keyException.getMessage());
            }
        }

        private void showMenu () {
            System.out.println("1.Service entry");
            System.out.println("2.Exit service");
            System.out.println("3.Show all stands");
            System.out.println("4.Show all entries");
            System.out.println("x.Exit");
            System.out.print("Option:");
        }
    }



package UserInterface;

import Service.ClientEntryService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Console {
    public ClientEntryService clientEntryService;

    public Console (ClientEntryService clientEntryService){
        this.clientEntryService = clientEntryService;
    }


    public void runUserInterface(){
        Scanner in = new Scanner(System.in);
        while (true) {
            showMenu();
            String option = in.nextLine();
            if("1".equals(option)){
                this.handleAddClientEntry();
            }
        }
    }

    private void handleAddClientEntry() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Give entry ID:");
            int idClientEntry = in.nextInt();
            System.out.println("Give stand number:");
            int standNumber = in.nextInt();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

                private void showMenu() {
                System.out.println("1.Service entry");
                System.out.println("2.Left service");
                System.out.println("3.Show all stands");
                System.out.println("4.Show all entries");
                System.out.println("x.Exit");
                System.out.print("Optiune");
            }
            }
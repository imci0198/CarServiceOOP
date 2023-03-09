import Repository.ClientEntryRepository;
import Service.ClientEntryService;
import UserInterface.Console;

import java.security.KeyException;

public class Main {
    public static void main(String[] args) throws KeyException {

        ClientEntryRepository clientEntryRepository = new ClientEntryRepository();
        ClientEntryService clientEntryService= new ClientEntryService(clientEntryRepository);
        clientEntryService.addClientEntryService(
                1,
                13,
                "adsht",
                14);
        clientEntryService.exitService(13,200,"aaa");
        clientEntryService.addClientEntryService(
                2,
                13,
                "adsbfghht",
                14);
        clientEntryService.exitService(13,500,"aaa");
        clientEntryService.addClientEntryService(
                3,
                13,
                "adsgggbht",
                14);
        clientEntryService.exitService(13,400,"aaa");

        clientEntryService.addClientEntryService(
                4,
                9,
                "adsgggbht",
                14);
        clientEntryService.exitService(9,500,"aaa");

        clientEntryService.addClientEntryService(
                5,
                9,
                "adsgggbht",
                14);
        clientEntryService.exitService(9,1000,"aaa");
        clientEntryService.addClientEntryService(
                6,
                9,
                "adsgggbht",
                14);
        clientEntryService.exitService(9,700,"aaa");
        clientEntryService.addClientEntryService(
                7,
                70,
                "adsgggbht",
                14);
        clientEntryService.exitService(70,100,"aaa");
        Console console= new Console(clientEntryService);
        console.runUserInterface();
    }
}
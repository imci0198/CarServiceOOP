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
                2,
                "adsht",
                14);
        Console console= new Console(clientEntryService);
        console.runUserInterface();
    }
}
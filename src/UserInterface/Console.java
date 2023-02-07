package UserInterface;

import Service.ClientEntryService;

public class Console {
    public ClientEntryService clientEntryService;

    public Console (ClientEntryService clientEntryService){
        this.clientEntryService = clientEntryService;
    }
}

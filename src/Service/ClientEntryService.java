package Service;

import Domain.ClientEntry;
import Repository.ClientEntryRepository;

import java.security.KeyException;
import java.util.List;

public class ClientEntryService {
    private ClientEntryRepository repository;

    public ClientEntryService(ClientEntryRepository repository) { this.repository = repository; }

    public void addClientEntryService(int idClientEntry, int standNumber, String licensePlate, int numberOfDays) throws KeyException {
        ClientEntry clientEntry = new ClientEntry(idClientEntry, standNumber, licensePlate, numberOfDays);
        // TODO: validation
        this.repository.create(clientEntry);
    }

    public List<ClientEntry> getAll() { return this.repository.read(); }
}

package Repository;

import Domain.ClientEntry;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientEntryRepository {
    private Map<Integer, ClientEntry> storage = new HashMap<>();

    /**
     * Adds a ClientEntry to the Repository
     * @param clientEntry
     * @throws KeyException
     */
    public void create (ClientEntry clientEntry) throws KeyException {
        if(storage.containsKey(clientEntry.getIdClientEntry())){
            throw new KeyException("ERROR The entry ID already exists!");
        }
        storage.put(clientEntry.getIdClientEntry(), clientEntry);
    }

    /**
     * Reads and returns an existing clientEntry
     * @param clientEntryId
     * @return an ClientEntry
     */
    public ClientEntry read (int clientEntryId) {return storage.get(clientEntryId);}

    /**
     * Updates an existing clientEntry
     * @param clientEntry
     * @throws KeyException if the ID doesn't exist
     */
    public void update(ClientEntry clientEntry) throws KeyException {
        if (!storage.containsKey(clientEntry.getIdClientEntry())){
            throw new KeyException("The entry ID does not exist!");
        }
        storage.put(clientEntry.getIdClientEntry(), clientEntry);
    }

    /**
     * Deletes an existing ClientEntry
     * @param idClientEntry
     * @throws KeyException
     */
    public void delete (int idClientEntry) throws KeyException {
        if (!storage.containsKey(idClientEntry)){
            throw new KeyException("The entry ID does not exist!");
        }
        storage.remove(idClientEntry);
    }

    /**
     * Returns a list of all clientEntries
     * @return List of clientEntry
     */
    public List<ClientEntry> read(){return new ArrayList<>(storage.values());}
}



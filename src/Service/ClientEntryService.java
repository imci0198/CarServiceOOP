package Service;

import Domain.ClientEntry;
import Domain.PriceForStandViewModel;
import Repository.ClientEntryRepository;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientEntryService {
    private ClientEntryRepository repository;

    public ClientEntryService(ClientEntryRepository repository) { this.repository = repository; }

    public void addClientEntryService(int idClientEntry, int standNumber, String licensePlate, int numberOfDays) throws KeyException {
        ClientEntry clientEntry = new ClientEntry(idClientEntry, standNumber, licensePlate, numberOfDays);
        // TODO: validation
        this.repository.create(clientEntry);
    }

    public void exitService(int standNumber, double billedPrice, String report) throws KeyException {
        for(ClientEntry clientEntry: this.repository.read()){
            if(!clientEntry.isLeftService() && clientEntry.getStandNumber() == standNumber) {
                clientEntry.setLeftService(true);
                clientEntry.setBilledPrice(billedPrice);
                clientEntry.setReport(report);
                this.repository.update(clientEntry);
                break;
            }
        }
    }

    public List<PriceForStandViewModel> getStandsOrderedByPrice() {
        Map<Integer, List<Double>> standsWithPrices = new HashMap<>();

        for(ClientEntry clientEntry: this.repository.read()) {
            if(clientEntry.isLeftService()) {
                int standNumber = clientEntry.getStandNumber();
                double billedPrice = clientEntry.getBilledPrice();

                if(!standsWithPrices.containsKey(standNumber)){
                List<Double> pricesList = new ArrayList<>();
                pricesList.add(billedPrice);
                standsWithPrices.put(standNumber,pricesList );
            } else {
                    standsWithPrices.get(standNumber).add(billedPrice);
                }
        }
        }

        List<PriceForStandViewModel> result = new ArrayList<>();
        for(int standNumber : standsWithPrices.keySet()) {
            List<Double> pricesForStand = standsWithPrices.get(standNumber);
            double pricesForStandSum = 0;
            for(double price: pricesForStand){
                pricesForStandSum += price;
            }
        PriceForStandViewModel priceForStandViewModel = new PriceForStandViewModel(
                standNumber,
                pricesForStandSum/pricesForStand.size()
        );
            result.add(priceForStandViewModel);
        }
        result.sort((o1, o2) -> {
            if(o1.getAveragePriceForStand() < o2.getAveragePriceForStand()) return 1;
            if(o1.getAveragePriceForStand() == o2.getAveragePriceForStand()) return 0;
            else return -1;
    });
        return result;
    }

    public List<ClientEntry> getAll() { return this.repository.read(); }
}

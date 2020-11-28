package pl.bykowski.pdt4th.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.pdt4th.model.MarketData;

@Service
public class MarketServiceImpl implements MarketService {

    @Override
    public MarketData getMarketData(int id) {
        RestTemplate restTemplate = new RestTemplate();
        MarketData marketData = restTemplate.getForObject("https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeId/"+ id +"?format=json", MarketData.class);
        return marketData;
    }
}

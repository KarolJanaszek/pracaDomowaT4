package pl.bykowski.pdt4th.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.pdt4th.model.MarketData;
import pl.bykowski.pdt4th.model.MarketModel;

@Service
public class MarketServiceImpl implements MarketService {

    @Override
    public MarketData getMarkById(int markId) {
        RestTemplate restTemplate = new RestTemplate();
        MarketData marketData = restTemplate.getForObject("https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeId/" +
                markId + "?format=json", MarketData.class);
        return marketData;
    }

    @Override
    public MarketModel getModelByMarkIdAndModelId(int markId, int modelId) {
        return getMarkById(markId).getResults().stream().filter(m -> m.getModelID() == modelId).findFirst().get();
    }


}

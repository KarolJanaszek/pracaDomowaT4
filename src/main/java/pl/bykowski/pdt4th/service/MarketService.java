package pl.bykowski.pdt4th.service;

import pl.bykowski.pdt4th.model.MarketData;
import pl.bykowski.pdt4th.model.MarketModel;

public interface MarketService {
    MarketData getMarkById(int markId);
    MarketModel getModelByMarkIdAndModelId(int markId, int modelId);
}

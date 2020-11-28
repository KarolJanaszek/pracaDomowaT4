package pl.bykowski.pdt4th.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Count",
        "Message",
        "SearchCriteria",
        "Results"
})
public class MarketData {

    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("SearchCriteria")
    private String searchCriteria;
    @JsonProperty("Results")
    private List<MarketModel> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("Count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("SearchCriteria")
    public String getSearchCriteria() {
        return searchCriteria;
    }

    @JsonProperty("SearchCriteria")
    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @JsonProperty("Results")
    public List<MarketModel> getResults() {
        return results;
    }

    @JsonProperty("Results")
    public void setResults(List<MarketModel> results) {
        this.results = results;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

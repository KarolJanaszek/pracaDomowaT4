package pl.bykowski.pdt4th.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Make_ID",
        "Make_Name",
        "Model_ID",
        "Model_Name"
})
public class MarketModel {

    @JsonProperty("Make_ID")
    private Integer makeID;
    @JsonProperty("Make_Name")
    private String makeName;
    @JsonProperty("Model_ID")
    private Integer modelID;
    @JsonProperty("Model_Name")
    private String modelName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private Color color;

    @JsonProperty("Make_ID")
    public Integer getMakeID() {
        return makeID;
    }

    @JsonProperty("Make_ID")
    public void setMakeID(Integer makeID) {
        this.makeID = makeID;
    }

    @JsonProperty("Make_Name")
    public String getMakeName() {
        return makeName;
    }

    @JsonProperty("Make_Name")
    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    @JsonProperty("Model_ID")
    public Integer getModelID() {
        return modelID;
    }

    @JsonProperty("Model_ID")
    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    @JsonProperty("Model_Name")
    public String getModelName() {
        return modelName;
    }

    @JsonProperty("Model_Name")
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

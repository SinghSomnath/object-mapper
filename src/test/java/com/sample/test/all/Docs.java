package com.sample.test.all;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "cc",
        "rank",
        "id",
        "parentLocation",
        "locationType"
})

public class Docs {
	
	@JsonProperty("ID")
    private int ID;
	
	@JsonProperty("Name")
    private String Name;
	
	@JsonProperty("cc")
    private String cc;
	
	@JsonProperty("rank")
    private int rank;
	
	@JsonProperty("id")
    private String id;
	
	@JsonProperty("parentLocation")
    private int parentLocation;
	
	@JsonProperty("locationType")
    private String locationType;
	
/********************* SETTER & GETTER***************************************/
	
	@JsonProperty("ID")
    public int getID() {
        return ID;
    }
    @JsonProperty("ID")
    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }
    
	
    @JsonProperty("cc")
    public String getcc() {
        return cc;
    }
    @JsonProperty("cc")
    public void setcc(String cc) {
        this.cc = cc;
    }
    
    @JsonProperty("rank")
    public int getrank() {
        return rank;
    }
    @JsonProperty("rank")
    public void setrank(int rank) {
        this.rank = rank;
    }
    
    
    @JsonIgnore
    public String getId() {
        return id;
    }
    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }
    
    @JsonProperty("parentLocation")
    public int getparentLocation() {
        return parentLocation;
    }
    @JsonProperty("parentLocation")
    public void setparentLocation(int parentLocation) {
        this.parentLocation = parentLocation;
    }
    
    
    @JsonProperty("locationType")
    public String getlocationType() {
        return locationType;
    }
    @JsonProperty("locationType")
    public void setlocationType(String locationType) {
        this.locationType = locationType;
    }
}

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
        "numFound",
        "start",
        "docs"
        })

public class SolrResponse {
	
	@JsonProperty("numFound")
    private int numFound;	
	
	@JsonProperty("start")
    private int start;
	
	@JsonProperty("docs")
    private Docs[] docs;	

	
/********************* SETTER & GETTER***************************************/
	
	@JsonProperty("numFound")
    public int getnumFound() {
        return numFound;
    }
    @JsonProperty("numFound")
    public void setnumFound(int numFound) {
        this.numFound = numFound;
    }
    
    @JsonProperty("start")
    public int getstart() {
        return start;
    }
    
    @JsonProperty("start")
    public void setstart(int start) {
        this.start = start;
    }
    
    
    @JsonProperty("docs")
    public Docs[] getDocs() {
        return docs;
    }
    
    @JsonProperty("docs")
    public void setDocs(Docs[] docs) {
        this.docs = docs;
    }
    
	
}

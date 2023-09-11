package com.task.atipera.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
	@JsonProperty("name")
	private String name;

	@JsonProperty("owner")
	private User owner;

	@JsonProperty("fork")
	private boolean fork;

	@JsonProperty("branches_url")
	private String branches_url;
}

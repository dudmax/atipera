package com.task.atipera.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import springfox.documentation.spring.web.json.Json;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
	@JsonProperty("name")
	private String name;

	@JsonProperty("commit")
	private Commit commit;
}

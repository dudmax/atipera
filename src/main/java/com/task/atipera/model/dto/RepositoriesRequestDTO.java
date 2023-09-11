package com.task.atipera.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RepositoriesRequestDTO(@JsonProperty("owner") UserDTO owner, @JsonProperty("header") String header) {

}

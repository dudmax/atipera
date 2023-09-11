package com.task.atipera.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.atipera.model.Repository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDTO {

	@JsonProperty("name")
	private final String name;

	@JsonProperty("owner")
	private final UserDTO owner;

	@JsonProperty("branches")
	private final List<BranchDTO> branchList;

}

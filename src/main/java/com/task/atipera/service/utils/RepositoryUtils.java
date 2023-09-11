package com.task.atipera.service.utils;

import java.util.List;
import com.task.atipera.model.Branch;
import com.task.atipera.model.Repository;
import com.task.atipera.model.dto.BranchDTO;
import com.task.atipera.model.dto.RepositoryDTO;
import com.task.atipera.model.dto.UserDTO;

public class RepositoryUtils {
	public static RepositoryDTO castRepositoryToDTO(Repository repository, List<BranchDTO> branchList) {
		UserDTO userDTO = new UserDTO(repository.getOwner().getLogin());
		return new RepositoryDTO(repository.getName(), userDTO, branchList);
	}

	public static List<BranchDTO> castBranchesToDTO(List<Branch> branchList) {
		return branchList.stream()
				.map(branch -> new BranchDTO(branch.getName(), branch.getCommit().getSha()))
				.toList();
	}
}

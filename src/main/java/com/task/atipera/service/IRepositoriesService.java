package com.task.atipera.service;

import java.util.List;
import com.task.atipera.model.dto.BranchDTO;
import com.task.atipera.model.dto.RepositoryDTO;

public interface IRepositoriesService {

	List<RepositoryDTO> getNotForkedUserRepositories(String owner);

	List<BranchDTO> getBranchesByUrl(String url);
}

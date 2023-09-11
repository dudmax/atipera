package com.task.atipera.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.task.atipera.exception.RepositoriesRequestException;
import com.task.atipera.model.Branch;
import com.task.atipera.model.Repository;
import com.task.atipera.model.dto.BranchDTO;
import com.task.atipera.model.dto.RepositoryDTO;
import com.task.atipera.service.IRepositoriesService;
import com.task.atipera.service.utils.RepositoryUtils;

@Service("repositoriesServiceImpl") public class RepositoriesServiceImpl implements IRepositoriesService {

	@Autowired RestTemplate restTemplate;

	@Value("${github.api.url}") private String githubApiUrl;

	@Override public List<RepositoryDTO> getNotForkedUserRepositories(String owner) {
		String requestUrl = githubApiUrl + owner + "/repos";
		try {
			ResponseEntity<List<Repository>> repositoryResponseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
			});
			if (repositoryResponseEntity.getStatusCode() == HttpStatus.OK) {
				List<Repository> repositoryList = repositoryResponseEntity.getBody();
				if (repositoryList != null) {
					List<Repository> notForkedRepositoryList = repositoryList.stream().filter(repository -> !repository.isFork()).toList();
					if (notForkedRepositoryList.size() > 0) {
						List<RepositoryDTO> repositoryDTOList = new ArrayList<>();
						for (Repository repository : notForkedRepositoryList) {
							String branchesUrl = repository.getBranches_url().replaceAll("\\{/branch}", "");
							List<BranchDTO> branchList = getBranchesByUrl(branchesUrl);
							RepositoryDTO repositoryDTO = RepositoryUtils.castRepositoryToDTO(repository, branchList);
							repositoryDTOList.add(repositoryDTO);
						}
						return repositoryDTOList;
					} else {
						throw new RepositoriesRequestException(HttpStatus.NOT_FOUND, "Not found not forked user repos");
					}
				} else {
					throw new RepositoriesRequestException(HttpStatus.NOT_FOUND, "Not found user repos");
				}
			} else {
				throw new RepositoriesRequestException(repositoryResponseEntity.getStatusCode(), "Error during request");
			}
		} catch (HttpClientErrorException exception) {
			throw new RepositoriesRequestException(exception.getStatusCode(), exception.getLocalizedMessage());
		}
	}

	@Override
	public List<BranchDTO> getBranchesByUrl(String url) {
		ResponseEntity<List<Branch>> branchResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Branch>>() {
		});
		if (branchResponseEntity.getStatusCode() == HttpStatus.OK) {
			List<Branch> branchList = branchResponseEntity.getBody();
			if (branchList != null) {
				return RepositoryUtils.castBranchesToDTO(branchList);
			} else {
				throw new RepositoriesRequestException(HttpStatus.NOT_FOUND, "Not found branch for repo");
			}
		} else {
			throw new RepositoriesRequestException(branchResponseEntity.getStatusCode(), "Error during branch request");
		}
	}
}

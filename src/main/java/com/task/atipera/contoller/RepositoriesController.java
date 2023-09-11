package com.task.atipera.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.task.atipera.model.dto.RepositoryDTO;
import com.task.atipera.service.IRepositoriesService;

@RestController
@RequestMapping("/repos")
public class RepositoriesController {

	@Autowired
	IRepositoriesService repositoriesServiceImpl;

	@RequestMapping(value = "/{owner}", method = RequestMethod.GET,
	consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RepositoryDTO> getNotForkedUserRepositories(@PathVariable String owner) {
			return repositoriesServiceImpl.getNotForkedUserRepositories(owner);
	}
}

package com.vel.model;

import org.springframework.data.repository.CrudRepository;

public interface StatusUpdateDao extends CrudRepository<StatusUpdate,Long>{
	StatusUpdate findFirstByOrderByDateAddedDesc();
}

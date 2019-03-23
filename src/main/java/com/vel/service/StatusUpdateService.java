package com.vel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vel.model.StatusUpdate;
import com.vel.model.StatusUpdateDao;

@Service
public class StatusUpdateService {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	public void save (StatusUpdate statusupdate) {
		statusUpdateDao.save(statusupdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateDao.findFirstByOrderByDateAddedDesc();
	}
}

package com.vel.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vel.App;
import com.vel.model.StatusUpdate;
import com.vel.model.StatusUpdateDao;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =  App.class)
@WebAppConfiguration
@Transactional
public class StatusTests {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	@Test
	public void testSave() {
		
		StatusUpdate status = new StatusUpdate("this is a third staus update");
		statusUpdateDao.save(status);
		
		assertNotNull("Non Null ID expected",status.getId());
		assertNotNull("Non Null Date expected",status.getDateAdded());
		
		StatusUpdate retreived = statusUpdateDao.findById(status.getId()).get();
		
		assertEquals("matching", status, retreived);
		 
		
	}
	
	@Test 
	public void testFindLatest() {
	Calendar calendar = Calendar.getInstance();
	
	StatusUpdate lastUpdated = null;
	
	for(int i=0;i<10;i++) {
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		
		StatusUpdate status = new StatusUpdate("status Update"+i, calendar.getTime());
		
		statusUpdateDao.save(status);
		lastUpdated = status; 
	}
	
	StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByDateAddedDesc();
	
	assertEquals("Latest Status Update", lastUpdated,retrieved);
		
	}

}

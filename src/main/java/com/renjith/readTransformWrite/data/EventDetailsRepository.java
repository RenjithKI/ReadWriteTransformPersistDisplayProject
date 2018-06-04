package com.renjith.readTransformWrite.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.renjith.readTransformWrite.domain.EventDetailsEnity;

public interface EventDetailsRepository extends JpaRepository<EventDetailsEnity, String> {
	
	List<EventDetailsEnity> findByEventid(String id);
	
	List<EventDetailsEnity> findByEventDuration(long eventDuration);
	
	List<EventDetailsEnity> findByAlert(boolean alert);
	
	List<EventDetailsEnity> findAll();

}
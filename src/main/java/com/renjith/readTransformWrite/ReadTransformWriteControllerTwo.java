package com.renjith.readTransformWrite;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renjith.readTransformWrite.data.EventDetailsRepository;
import com.renjith.readTransformWrite.domain.EventDetailsEnity;

/**
 * @author Renjith Kachappilly Ittoop
 * http://localhost:8080/Event-Details
 * http://localhost:8080/home
 * http://localhost:8080/
 * 
 *
 */
@Controller
public class ReadTransformWriteControllerTwo {

	private static Logger logger = Logger.getLogger(ReadTransformWriteControllerTwo.class);
	
	private EventDetailsRepository eventDetailsRepository;	

	/**
	 * @param eventDetailsRepository
	 */
	@Autowired
	public ReadTransformWriteControllerTwo(EventDetailsRepository eventDetailsRepository) {		
		this.eventDetailsRepository = eventDetailsRepository;
	}
	/**
	 *
	 * @return view
	 */
	@RequestMapping(value="/Event-Details-alert/{selector}", method=RequestMethod.GET)
	public String showEventDetails3(@PathVariable("selector") String allOralert, Model model ) {	
		
		
		logger.info("inside showEventDetails2 Alert>>>"+    allOralert);
		List<EventDetailsEnity> alllist;
		if (allOralert.equalsIgnoreCase("true") || allOralert.equalsIgnoreCase("false") ) {
			alllist = eventDetailsRepository.findByAlert(Boolean.valueOf(allOralert));	
		}else 
		 {
			alllist = eventDetailsRepository.findAll();
		 }
		if (alllist != null) {
			logger.info("inside allDetails method size>>>>"+ alllist.size() );
			model.addAttribute("allDetailsList", alllist);
		}		
		return "Event-Details-List";
	}
	
	

}

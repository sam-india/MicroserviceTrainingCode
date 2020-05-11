package com.desease.tracker.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.desease.tracker.demo.model.LocationStat;
import com.desease.tracker.demo.services.CoronaVirusDataService;

@Controller
public class CoronaVirusUpdateController {
		
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
		@GetMapping("/")
		public String getCoronaVirusUpdate(Model model)
		{
			List<LocationStat> allStats = coronaVirusDataService.getAllLocationStats();
			int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
			int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
			model.addAttribute("totalReportedCases",totalReportedCases);
			model.addAttribute("locationstats",allStats);
			model.addAttribute("totalNewCases", totalNewCases);
			return "CoronaVirusUpdate";
		}
}
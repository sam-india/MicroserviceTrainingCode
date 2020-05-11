package com.desease.tracker.demo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.desease.tracker.demo.model.LocationStat;

@Service
public class CoronaVirusDataService {
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/DataHerb/dataset-covid-19/master/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	private List<LocationStat> allLocationStats = new ArrayList<>();
			
	@PostConstruct
	@Scheduled(cron = "1 * * * * *")
	public void fetchVirusData() throws IOException {
		List<LocationStat> tempallLocationStats = new ArrayList<>();
		URL url = new URL(VIRUS_DATA_URL);
		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(url.openStream()));
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			LocationStat stat = new LocationStat();
			stat.setCountry(record.get("Country/Region"));
			stat.setState(record.get("Province/State"));
			int latestCases = 0;
			int prevDayCases = 0;
			try {
				latestCases = Integer.parseInt(record.get(record.size()-1));
				 prevDayCases = Integer.parseInt(record.get(record.size()-2));
			}
			catch(NumberFormatException ex)
			{
				latestCases = 0;
				prevDayCases = 0;
			}
			stat.setLatestTotalCases(latestCases);
			stat.setDiffFromPrevDay(latestCases-prevDayCases);
			tempallLocationStats.add(stat);
			System.out.println(stat.toString());
		}
		this.allLocationStats = tempallLocationStats;
	}

	
	public List<LocationStat> getAllLocationStats() {
		return allLocationStats;
	}
}

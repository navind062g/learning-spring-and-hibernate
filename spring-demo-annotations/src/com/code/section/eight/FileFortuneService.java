package com.code.section.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> messages;
	
	@PostConstruct
	public void readMessagesFromFile() {
		
	    InputStream inputStream;
	    messages = new ArrayList<String>();
		try {
			ClassPathResource resource = new ClassPathResource("fortunes.txt");
			inputStream = resource.getInputStream();
		
		    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		    String line;
		    while ((line = reader.readLine()) != null) {
		        messages.add(line);
		    }
		    reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getDailyFortune() {
		int randomIndex = (int)(Math.random() * messages.size());
		return messages.get(randomIndex);
	}

}

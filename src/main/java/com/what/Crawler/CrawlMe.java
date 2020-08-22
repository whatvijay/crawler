package com.what.Crawler;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class CrawlMe {
	
	@Autowired
	UrlCrawler urlCrawler;

	@GetMapping("/ping")
	public String ping()
	{
		return "pong";
	}
	
	@GetMapping("/crawlMe/{url}")
	public String crawlMe(@PathVariable(name="url") String url)
	{
		//urlCrawler.getPageLinks(url);
		url = "http://www."+url;
		HashSet<String> links =new HashSet<>();
		urlCrawler.resetCounter();
		return "I crawled"+url+"to get following results"+urlCrawler.getPageLinks(url,links).toString();
	}
	
}

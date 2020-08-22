package com.what.Crawler;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.what.parser.DocumentParser;
import java.net.URL; 
@Service
public class UrlCrawler {
	
	 //HashSet<String> links ;
	 int counter=0;
	 DocumentParser documentParser = new DocumentParser();
	 UrlCrawler()
	 {
		// links =new HashSet<>();
	 }
	 public void resetCounter()
	 {
		 counter=0;
	 }
	public HashSet<String> getPageLinks(String URL, HashSet<String> links ) {
		
		 //HashSet<String> links =new HashSet<>();
        //4. Check if you have already crawled the URLs 
        //(we are intentionally not checking for duplicate content in this example)
        if (!links.contains(URL)) {
        	counter++;
            try {
                //4. (i) If not add it to the index
                if (links.add(URL)) {
                	System.out.println(counter);
                	
                   System.out.println(URL);
                }

                //2. Fetch the HTML code
                
                Document document = Jsoup.connect(URL).get();
               // System.out.println(documentParser.parseDocument(document));
                //3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");
                // check for input elements
                Elements input = document.select("input");
                if(null !=input)
                {
                	for(Element pageInput : input) {
                	System.out.println(pageInput.attr("input"));
                	}
                }
               // System.out.println(linksOnPage.text());
                //5. For each extracted URL... go back to Step 4.
                for (Element page : linksOnPage) {
                	if(counter<100) {
                		try {
                			
                			new URL(page.attr("abs:href")).toURI();
                			 getPageLinks(page.attr("abs:href"),links);
                		}
                		catch(Exception e)
                		{
                			
                			System.out.println("problem with uri");
                		}
                		
                   
                	}
                	else 
                	{
                		return links;
                	}
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
        //counter=0;
        return links;

}
}

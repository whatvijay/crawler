package com.what.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentParser {

	public static void main(String args[])
	{
		DocumentParser dp = new DocumentParser();
		Document document = new Document("<input type=>");
		//String s=dp.parseDocument(document);
		//System.out.println(s);
	}
	public boolean parseDocument(Document document)
	{
		//check if document has a entry for input.
		
		 Elements inputField = document.select("input");
		 String inputs="";
		if(null != inputField)
		{
			return true;
			//for(Element e :inputField)
			//{
				//e.getElementsContainingText("input").
			//}
		}
		else
		{
		return false;
		}
		
	}
	
}

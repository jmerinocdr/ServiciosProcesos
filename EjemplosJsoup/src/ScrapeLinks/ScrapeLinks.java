package ScrapeLinks;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeLinks {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://google.com").get();
			
			String title = doc.title();
			System.out.println("Título: "+title);
			
			Elements links = doc.select("a[href]");
			for(Element link : links) {
				System.out.println("Link: "+link.attr("href"));
				System.out.println("Texto: "+link.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

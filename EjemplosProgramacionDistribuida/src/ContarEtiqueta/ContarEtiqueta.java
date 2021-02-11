package ContarEtiqueta;

import java.io.File;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ContarEtiqueta {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File input = new File("/tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

		Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
		}
	}

}

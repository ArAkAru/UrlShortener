package urlShortener.arakaru;

public class Main {
	public static void main(String[] args) {
		
		shortURL toShortUrl = new shortURL("https://vk.com"); 
		String shorturl=toShortUrl.getBase62From10(); 
		System.out.println("Short URL: "+shorturl); 
		String originalURL =toShortUrl.getBase10From62(shorturl); 
		System.out.println("Original URL: "+originalURL); 

		
		
	}

	
}
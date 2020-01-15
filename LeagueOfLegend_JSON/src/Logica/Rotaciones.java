package Logica;


import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Rotaciones {
    public static final String url = "https://leagueoflegends.fandom.com/wiki/Free_champion_rotation#Classic";
    public static final int maxPages = 2;
    private ArrayList<Elements> web = new ArrayList();
    private ArrayList<String> images = new ArrayList();

    public Rotaciones() {

        for (int i = 1; i < maxPages; i++) {
            String urlPage = String.format(url, i);
            if (getStatusConnectionCode(urlPage) == 200) {
                Document document = getHtmlDocument(urlPage);
                Elements entradas = document.select("div[title=Classic]");
                for (Element elem : entradas) {
                    Elements imgTag = elem.getElementsByTag("img");
                    web.add(imgTag);
                }
            } else {
                System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
                break;
            }
        }
        for (int i = 0; i < web.size(); i++) {
            obtenerImagenes(web.get(i));
        }
    }

    private void obtenerImagenes(Elements elements) {
        elements.size();
        for (int i = 1; i < elements.size(); i = i + 2) {
            images.add(elements.get(i).attributes().get("src"));
        }
    }


    public static int getStatusConnectionCode(String url) {

        Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }

    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}




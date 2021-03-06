package main.server.logic.products.enums;

import main.server.logic.products.abstractions.Product;
import main.server.logic.products.producttypes.VehicleProduct;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public enum WebsiteType {

    OLX,
    GRATKA,
    ALLEGRO;


    public static Product getProductDetails(String url) {
        for(WebsiteType type : WebsiteType.values())
            if(url.contains(type.name().toLowerCase()+".pl"))
                return type.getProduct(url);
        throw new UnsupportedOperationException("Unsupported website URL: " + url);
    }

    public Product getProduct(String url) {
        //TODO

        return new VehicleProduct("wymyslona nazwa rezultatu", OLX, "https://static.thenounproject.com/png/1427-200.png", true, "1000","1234",2001,300000);
    }
}

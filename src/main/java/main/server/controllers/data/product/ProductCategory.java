package main.server.controllers.data.product;

import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.producttypes.BikeProductFactory;
import main.server.logic.products.producttypes.VehicleProductFactory;

public enum ProductCategory {
    VEHICLE(new VehicleProductFactory()),
    BIKE(new BikeProductFactory());

    private AbstractProductFactory productFactory;

    ProductCategory(AbstractProductFactory productFactory){
        this.productFactory = productFactory;
    }

    public AbstractProductFactory getProductFactory(){
        return this.productFactory;
    }
}

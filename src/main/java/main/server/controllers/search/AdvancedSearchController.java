package main.server.controllers.search;

import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.Search;
import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdvancedSearchController extends AbstractController {

    @Autowired
    private ShopWebsiteService shopService;

    @RequestMapping(value = "/advanced_search", method = RequestMethod.GET)
    public String search(Search search, Model model) throws IOException {
        List<String> productCategoryList = new ArrayList<>();
        for(ProductCategory productCategory : ProductCategory.values()){
            String productCategoryName = productCategory.name().toLowerCase();
            productCategoryName = productCategoryName.substring(0,1).toUpperCase() + productCategoryName.substring(1);
            productCategoryList.add(productCategoryName);
        }
        model.addAttribute("productCategoryList", productCategoryList);
        List<String> websiteTypeList = new ArrayList<>();
        for(WebsiteType websiteType : WebsiteType.values()){
            String websiteTypeName = websiteType.name().toLowerCase();
            websiteTypeName = websiteTypeName.substring(0,1).toUpperCase() + websiteTypeName.substring(1);
            websiteTypeList.add(websiteTypeName);
        }
        model.addAttribute("websiteTypeList", websiteTypeList);
        return "advanced_search";
    }

}
package main.server.controllers;


import main.server.database.dto.Search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/search")
public class SearchController extends AbstractController {

    @RequestMapping(method= RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("search", new Search());
        return "search";
    }
    @RequestMapping(method= RequestMethod.POST)
    public String processSearchTerm(Search search) {
        return "redirect:/user/search/" + search.getSearchString();
    }

    @RequestMapping(value = "/{searchString}", method = RequestMethod.GET)
    public String printResults(@PathVariable("searchString") String searchString, Model model){
        try{
            Document doc = Jsoup.connect("https://www.olx.pl/oferty/q-"+searchString).get();
            Elements table = doc.select("a.marginright5").select("strong");
            List<String> resultsList = new ArrayList<>();
            for(Element el : table){
                resultsList.add(el.html());
            }
            model.addAttribute("resultsList", resultsList);
        }
        catch(IOException e){e.printStackTrace();}
        return "results";
    }


}

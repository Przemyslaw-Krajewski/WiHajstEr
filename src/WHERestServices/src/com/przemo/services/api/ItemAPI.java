package com.przemo.services.api;

import com.przemo.ProvideDataService;
import com.przemo.entity.Item;
import com.przemo.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemAPI
{
    @Autowired
    ProvideDataService provideDataService;

    @RequestMapping(path = "/create/item",method = {RequestMethod.GET})
    String createItemForm()
    {
        return "createItem";
    }

    @RequestMapping(path = "/create/item",method = {RequestMethod.POST})
    String createItem(@RequestParam String name, ModelMap map)
    {
        ProvideDataService.Response r = provideDataService.createItem(name);
        map.put("result",r.toString());
        return "createItemResult";
    }

    @RequestMapping(path = "/create/item/{name}",method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<String> createItemDirect(@PathVariable String name)
    {
        ProvideDataService.Response r = provideDataService.createItem(name);
        switch (r)
        {
            case SUCCESS:
                return ResponseEntity.status(HttpStatus.CREATED).body("Created");
            case ALREADY_EXISTS:
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Already exists");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occured");
    }
}

package com.aft.sprenium.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ThingController {

    @Autowired
    private ThingService service;

    @RequestMapping("/thing")
    public String welcome(Map<String, Object> model) {
        model.put("things", service.getThings());
        return "thing";
    }
}

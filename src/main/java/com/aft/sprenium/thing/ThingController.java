package com.aft.sprenium.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ThingController {

    @Autowired
    private ThingService service;

    @RequestMapping("/thing")
    public String thingView(Map<String, Object> model) {
        model.put("things", service.getThings());
        return "thing";
    }

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    public String thingAdd(@RequestBody MultiValueMap<String,String> formData) {

        service.add(new Thing(formData.get("name").get(0), formData.get("description").get(0))); // todo: ugly jsp form handling
        return "redirect:/thing";
    }

}

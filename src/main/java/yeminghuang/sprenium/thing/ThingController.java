package yeminghuang.sprenium.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.put("newThing", new Thing());
        return "thing";
    }

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    public String thingAdd(@ModelAttribute Thing thing) {
        service.add(thing);
        return "redirect:/thing";
    }

}

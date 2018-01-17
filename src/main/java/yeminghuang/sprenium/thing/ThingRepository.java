package yeminghuang.sprenium.thing;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ThingRepository {

    private List<Thing> things = new ArrayList<>();

    @PostConstruct
    public void init() {
        things.add(new Thing("abc", "The first thing"));
        things.add(new Thing("xyz", "The second thing"));
    }


    List<Thing> getAll() {
        return things;
    }

    void add(Thing thing) {
        things.add(thing);
    }
}

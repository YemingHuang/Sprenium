package com.aft.sprenium.thing;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ThingRepository {

    public List<Thing> getAll() {
        return Arrays.asList(new Thing("abc", "The first thing"), new Thing("xyz", "The second thing"));
    }

}

package com.aft.sprenium.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingService {

    @Autowired
    private ThingRepository repository;

    List<Thing> getThings() {
        return repository.getAll();
    }

    void add(Thing thing) {
        repository.add(thing);
    }
}

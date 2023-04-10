package com.choker.claimcenter.model;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    NONE, // ordinal 0
    FEMALE,
    MALE;

    private static final Map<Integer, Gender> lookup = new HashMap<>();

    // static initialisation block
    static {
        for (var gender : Gender.values()) {
            lookup.put(gender.ordinal(), gender);
        }
    }

    public static Gender valueOf(int ordinal) {
        return lookup.get(ordinal);
    }
}

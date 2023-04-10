package com.choker.claimcenter.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ClaimStatus {
    NONE, // ordinal 0
    COVERED,
    NOT_COVERED,
    PENDING;

    private static final Map<Integer, ClaimStatus> lookup = new HashMap<>();

    // static initialisation block
    static {
        for (var status : ClaimStatus.values()) {
            lookup.put(status.ordinal(), status);
        }
    }

    public static ClaimStatus valueOf(int ordinal) {
        return lookup.get(ordinal);
    }
}

package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.P2EPoints;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class P2EPointsImpl implements P2EPoints {

    @Getter
    private final int points;

    @Override
    public String toString() {
        return "PointsImpl{" +
                "points='" + points +
                '}';
    }

}

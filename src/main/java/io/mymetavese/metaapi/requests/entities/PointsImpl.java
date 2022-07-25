package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.Points;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointsImpl implements Points {

    @Getter
    private final String points;

    @Override
    public String toString() {
        return "PointsImpl{" +
                "points='" + points +
                '}';
    }

}

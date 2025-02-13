package com.ZomatoProject.Zomato_app.services.impl;

import com.ZomatoProject.Zomato_app.services.DistanceService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point des) {
        return 0;
    }
}

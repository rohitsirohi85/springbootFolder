package com.uberApplication.uber.utils;

import org.geolatte.geom.Point;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;

import com.uberApplication.uber.DTO.PointDto;

public class GeometryUtils {
   
    public static Point createPoint(PointDto pointDto){
        GeometryFactory geometryFactory =new GeometryFactory(new PrecisionModel() , 4326);
    }
}

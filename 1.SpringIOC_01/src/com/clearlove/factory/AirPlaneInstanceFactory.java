package com.clearlove.factory;

import com.clearlove.bean.AirPlane;

/**
 * @author promise
 * @date 2021/2/24 - 22:46 实例工厂
 */
public class AirPlaneInstanceFactory {

    // new AirPlaneInstanceFactory().getAirPlane();
    public AirPlane getAirPlane(String jzName) {
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("kobe");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}

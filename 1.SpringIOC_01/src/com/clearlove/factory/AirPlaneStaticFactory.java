package com.clearlove.factory;

import com.clearlove.bean.AirPlane;

/**
 * @author promise
 * @date 2021/2/24 - 22:46 静态工厂
 */
public class AirPlaneStaticFactory {

  // AirPlaneStaticFactory.getAirPlane()
  public static AirPlane getAirPlane(String jzName) {
    System.out.println("AirPlaneStaticFactory...正在为你造飞机");
    AirPlane airPlane = new AirPlane();
    airPlane.setFdj("太行");
    airPlane.setFjsName("kobe");
    airPlane.setJzName(jzName);
    airPlane.setPersonNum(300);
    airPlane.setYc("198.98m");
    return airPlane;
  }
}

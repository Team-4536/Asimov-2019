package org.minutebots.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.minutebots.robot.RobotMap;

public class DepotYeeter extends Subsystem {

    public static DepotYeeter depotYeeter = new DepotYeeter();

    private PWMVictorSPX SideWheel;

    private DepotYeeter(){
        SideWheel = new PWMVictorSPX(RobotMap.SIDE_WHEEL);
    }

    public void setSideWheel(double speed){
        SideWheel.set(speed);
    }

    public void initDefaultCommand(){

    }
}

package org.minutebots.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import org.minutebots.lib.VirtualMotor;
import org.minutebots.lib.VirtualSolenoid;

public class Superstructure {
    //Talons
    private final int LEFT_FRONT_MOTOR = 2,
            LEFT_BACK_MOTOR = 1,
            RIGHT_FRONT_MOTOR = 0,
            RIGHT_BACK_MOTOR = 3;

    //Pneumatic Ports
    private final static int INTAKE_1 = 1,
            INTAKE_2 = 2,
            CONE_1 = 3,
            CONE_2 = 4;


    //Victor Ports
    private final static int SIDE_WHEEL = 0,
            WHEEL = 1;

    /*---------------------------------------Programmer's territory starts here----------------------------------*/

    Intake intake;
    CargoOuttake cargoOutake;
    DepotYeeter depotYeeter;
    Drivetrain driveTrain;

    private static Superstructure instance = new Superstructure(RobotType.YEETER);

    private Superstructure(RobotType robot) {
        switch (robot) {
            case FRACTURE:
                driveTrain = new Drivetrain(
                        new Spark(LEFT_FRONT_MOTOR),
                        new Spark(RIGHT_FRONT_MOTOR),
                        new Spark(LEFT_BACK_MOTOR),
                        new Spark(RIGHT_BACK_MOTOR));
                cargoOutake = new CargoOuttake(
                        new VirtualMotor(WHEEL));
                depotYeeter = new DepotYeeter(
                        new VirtualMotor(SIDE_WHEEL));
                intake = new Intake(
                        new VirtualSolenoid(INTAKE_1, INTAKE_2),
                        new VirtualSolenoid(CONE_1, CONE_2));
            default:
                driveTrain = new Drivetrain(
                        new WPI_TalonSRX(LEFT_FRONT_MOTOR),
                        new WPI_TalonSRX(RIGHT_FRONT_MOTOR),
                        new WPI_TalonSRX(LEFT_BACK_MOTOR),
                        new WPI_TalonSRX(RIGHT_BACK_MOTOR));
                cargoOutake = new CargoOuttake(
                        new WPI_VictorSPX(WHEEL));
                depotYeeter = new DepotYeeter(
                        new WPI_VictorSPX(SIDE_WHEEL));
                intake = new Intake(
                        new DoubleSolenoid(INTAKE_1, INTAKE_2),
                        new DoubleSolenoid(CONE_1, CONE_2));
        }
    }

    private enum RobotType {
        FRACTURE,
        SIDEWINDER,
        YEETER
    }

    static Superstructure getInstance() {
        return instance;
    }
}


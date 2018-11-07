package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.ComponentInterface.ComponentHardware;
import org.firstinspires.ftc.teamcode.Utilities.Map;
import org.firstinspires.ftc.teamcode.Utilities.SetRobot;

/**
 * Created by spmce on 11/26/2017.
 *
 * This drive train is used for robots with a two motor drive train
 */
@Disabled
public class StandardDrive extends ComponentHardware {
    private final SetRobot setRobot;
    // ---------------------- Hardware Devices ----------------------
    /**
     * left motor
     */
    public DcMotor mLeft;
    /**
     * right motor
     */
    public DcMotor mRight;
    /**
     * back left motor
     */
    public DcMotor mBackLeft;
    /**
     * back right motor
     */
    public DcMotor mBackRight;
    // --------------------- Hardware Variables ---------------------
    /**
     * this variable is used to set power the left motor
     */
    public double leftPower;
    /**
     * this variable is used to set power the right motor
     */
    public double  rightPower;
    private Map map;
    // ------------------------ Constructor -------------------------
    /**
     * Constructs a two motor drive train
     *
     * @param map object that is used to map the drive train
     * @param setRobot object that is used to set the power to the drive train
     */
    public StandardDrive(Map map, SetRobot setRobot) {
        this.map = map;
        this.setRobot = setRobot;
        mLeft    = null;
        mRight   = null;
        mBackLeft  = null;
        mBackRight = null;
        leftPower  = 0;
        rightPower = 0;
    }
    // -------------------------- Mapping ---------------------------
    /**
     * Maps left and right motor of drive train
     */

    public void initHardware() {
        mLeft  = map.revMotor("l");
        mRight = map.motor("r");
        mBackLeft  = map.revMotor("bl");
        mBackRight = map.motor("br");
    }

    @Override
    public void runHardware() {

    }

    @Override
    public void stopHardware() {

    }
    // --------------------- Set Hardware Power ---------------------
    /**
     * Sets power to right and left motor of drive train
     * @param setRobot
     */
    public void runHardware(SetRobot setRobot) {
        setRobot.power(mLeft,leftPower,"left motor");
        setRobot.power(mRight,rightPower,"right motor");
        setRobot.power(mBackLeft,leftPower,"back left motor");
        setRobot.power(mBackRight,rightPower,"back right motor");
    }

    public void stopHardware(SetRobot setRobot) {
        leftPower  = 0;
        rightPower = 0;
        setRobot.power(mLeft,leftPower,"left motor");
        setRobot.power(mRight,rightPower,"right motor");
        setRobot.power(mBackLeft,leftPower,"back left motor");
        setRobot.power(mBackRight,rightPower,"back right motor");
    }
}

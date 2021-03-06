package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class robotmanager extends LinearOpMode{

    ElapsedTime runtime = new ElapsedTime();

//declaring motors and servos
    public double liftPower;
    public double Power[];
    public DcMotor  leftDrive;
    public DcMotor rightDrive;
    public DcMotor boxMotor = null;
    public DcMotor boxext =null;
    public DcMotor liftMotor = null;
    public DcMotor boxPitch =null;




    public void Init()
    {
        // Set all motors to zero power
        
        liftPower=1;
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive=hardwareMap.dcMotor.get("right_drive");
        boxMotor = hardwareMap.get(DcMotor.class, "box_Motor");
        boxext=hardwareMap.dcMotor.get("boxext");
        liftMotor=hardwareMap.dcMotor.get("lift_Motor");
        boxPitch=hardwareMap.dcMotor.get("box_Pitch");
        //sets direction of wheels
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
    }
    public void runOpMode() throws InterruptedException { }

    public void init(HardwareMap hardwareMap) {
    }
}

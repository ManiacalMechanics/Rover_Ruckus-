package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class robotmanager extends LinearOpMode{

    ElapsedTime runtime = new ElapsedTime();

    double liftPower;
    double Power[];
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor boxMotor = null;
    DcMotor boxext =null;
    DcMotor liftMotor = null;




    public void Init()
    {
        liftPower=1;
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive=hardwareMap.dcMotor.get("right_drive");
        boxMotor = hardwareMap.get(DcMotor.class, "box_Motor");
        boxext=hardwareMap.dcMotor.get("boxext");
        liftMotor=hardwareMap.dcMotor.get("lift_Motor");
        //sets direction of wheels
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }
    public void runOpMode(){ }

}

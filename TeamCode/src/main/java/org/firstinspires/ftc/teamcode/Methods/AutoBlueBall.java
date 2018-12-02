package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ComponentInterface.HardwarePushbot;


@Autonomous(name = "AutoBlueBall", group = "AutoBLueBall")

public class AutoBlueBall extends robotmanager{

    /*Declare OpMode members */

    robotmanager    robot  = new robotmanager();
    private ElapsedTime     runtime = new ElapsedTime();
     Object robotmanager;


    @Override
    public void runOpMode() {



        telemetry.addData("Status", "Reseting Enconders ");
        telemetry.update();

        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d",
                robot.leftDrive.getCurrentPosition(),
                robot.rightDrive.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        // set left motor to run for 5000 encoder counts.

        leftDrive.setTargetPosition(-5000);

        // set both motors to 25% power. Movement will start.

        leftDrive.setPower(-0.25);
        rightDrive.setPower(-0.25);

        stop();


    }




}

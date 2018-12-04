package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ComponentInterface.HardwarePushbot;


@Autonomous(name = "AutoRedBall", group = "AutoRedBall")

public class Red_Ball_Auto extends robotmanager {

    /*Declare OpMode members */


    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        Init();


        telemetry.addData("Status", "Reseting Enconders ");
        telemetry.update();

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0", "Starting at %7d :%7d",
                leftDrive.getCurrentPosition(),
                rightDrive.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        // set left motor to run for 5000 encoder counts.


        // set both motors to 25% power. Movement will start.
        while (opModeIsActive()) {

            while(liftMotor.getCurrentPosition()<=100)
            {
                liftMotor.setPower(1);
                telemetry.addData("Position",liftMotor.getCurrentPosition());
                telemetry.update();
            }





            while(liftMotor.getCurrentPosition() >= 100) {
                liftMotor.setPower(0);
                while (leftDrive.getCurrentPosition() < 5000 && rightDrive.getCurrentPosition() < 2000) {
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                }

                while (rightDrive.getCurrentPosition() >= 2000 && leftDrive.getCurrentPosition() < 5000) {
                    rightDrive.setPower(0);
                    leftDrive.setPower(1);
                }

            }

        }


    }
}




package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ComponentInterface.HardwarePushbot;


@Autonomous(name = "AutoBlueBall", group = "AutoBLueBall")

public class AutoBlueBall extends robotmanager {

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
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


            liftMotor.setPower(1);

            if (liftMotor.getCurrentPosition() > 10) {
                liftMotor.setPower(0);
                if (leftDrive.getCurrentPosition() < 50 && rightDrive.getCurrentPosition() < 2) {
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                }

                if (rightDrive.getCurrentPosition() >= 2 && leftDrive.getCurrentPosition() < 50) {
                    rightDrive.setPower(0);
                    leftDrive.setPower(1);
                }
            }
        }


        if (liftMotor.getCurrentPosition() > -10) {
            telemetry.addData("ughhhh","xd");
            telemetry.update();
            liftMotor.setPower(0);
            if (leftDrive.getCurrentPosition() < 50 && rightDrive.getCurrentPosition() < 2) {
                leftDrive.setPower(1);
                rightDrive.setPower(1);
            }

            if (rightDrive.getCurrentPosition() >= 2 && leftDrive.getCurrentPosition() < 50) {
                rightDrive.setPower(0);
                leftDrive.setPower(1);
            }
        }

    }
}




package org.firstinspires.ftc.teamcode.vision;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.Methods.robotmanager;

@Autonomous

public class VisionJavaExample extends robotmanager {
    static  final int MOTOR_TICK_COUNTS = 1120;
    MasterVision vision;
    SampleRandomizedPositions goldPosition;
    private robotmanager robot;                       //this may cause problemsssss tylerrrrrrrr

    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;// recommended camera direction
        parameters.vuforiaLicenseKey = "AaA3nev/////AAABmZWyIPXF/kcKjRqjBWEHQDWJ7dQKsGoekUHJhQ1ps2u7KGvERhDfRZlnGRoaMgkkBLUZ4X3xwpgjZ4tDe3lPobhlRuEsMkz8AI1a9fJIhZNfEl0gw8VRqLj135L7+0cs0iZawSnKcT4Y3ST6AwAAwt9IrTqK+rdZge4YlFHL4Kg2Ild4ic8Z3tB6tGPozZ1qCgNdGL/+UQ89jwXFBN8FkFxQxlJvdWYXH66/mJDV2M1z9QAqawCTYxqRLM1FCv0sn8GKFn3pHLgiDI9xrfgCh+u/vbLcB62Lfd2goGCXIO4OYrPIQ7BDth3gsor5qv7oLF3g1spwzF1KcwIAQ6+alw7HwUCutN3zEGJBV05pKgUm\n";

        vision = new MasterVision(parameters, hardwareMap, true, MasterVision.TFLiteAlgorithm.INFER_RIGHT);
        vision.init();// enables the camera overlay. this will take a couple of seconds
        vision.enable();// enables the tracking algorithms. this might also take a little time



        waitForStart();

        //reset the encoders
        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //how long motor needs to spin for one rotation?
        double circumfrence = 3.14 *2.85;
        double rotationNeeded = 1/circumfrence;
        int encoderDrivingTarget = (int)(rotationNeeded*1120);

        robot.leftDrive.setTargetPosition(encoderDrivingTarget);
        robot.rightDrive.setTargetPosition(encoderDrivingTarget);

        vision.disable();// disables tracking algorithms. this will free up your phone's processing power for other jobs.

        goldPosition = vision.getTfLite().getLastKnownSampleOrder();

        while(opModeIsActive()){
            telemetry.addData("goldPosition was", goldPosition);// giving feedback

            switch (goldPosition){ // using for things in the autonomous program
                case LEFT:
                    telemetry.addLine("going to the left");
                    //set power to motors
                    robot.leftDrive.setPower(.5);
                    robot.rightDrive.setPower(.5);
                    //set the motors to RUN_TO_POSITION
                    robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    break;
                case CENTER:
                    telemetry.addLine("going straight");
                    break;
                case RIGHT:
                    telemetry.addLine("going to the right");
                    break;
                case UNKNOWN:
                    telemetry.addLine("staying put");
                    break;
            }

            telemetry.update();
        }

        vision.shutdown();
    }
}

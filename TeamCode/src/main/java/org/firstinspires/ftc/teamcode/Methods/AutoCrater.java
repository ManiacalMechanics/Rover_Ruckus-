package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ComponentInterface.HardwarePushbot;


@Autonomous(name = "AutoCrater", group = "AutoCrater")

public class AutoCrater extends robotmanager {

    /*Declare OpMode members */

    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 1;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        Init();        // The init() method of the hardware class does all the work here

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        //Step 1: move lift motor down
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 5.8)
        {
            liftMotor.setPower(2);
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin right for 0.3 seconds
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < .3)
        {
            leftDrive.setPower(TURN_SPEED);
            rightDrive.setPower(-TURN_SPEED);
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        //        leftDrive.setPower(0);
        //        rightDrive.setPower(0);

        //Step 3 move forward oh so slightly
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < .4)
        {
            leftDrive.setPower(-FORWARD_SPEED);
            rightDrive.setPower(-FORWARD_SPEED);
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
runtime.reset();
        // Step 4 turn left slightly to straighten up robot
        while (opModeIsActive() && runtime.seconds() < .7)
        {
            leftDrive.setPower(-TURN_SPEED);
            rightDrive.setPower(TURN_SPEED);
            telemetry.addData("Path", "leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
runtime.reset();
        //Step 5 move straight for the crater
        while(opModeIsActive() && runtime.seconds() < 0.5){
            leftDrive.setPower(-FORWARD_SPEED);
            rightDrive.setPower(-FORWARD_SPEED);

        }
        runtime.reset();


        //step 6: Turn back and to the right

        while(opModeIsActive() && runtime.seconds() < 0.3){
            leftDrive.setPower(-TURN_SPEED);
            rightDrive.setPower(TURN_SPEED);

        }
runtime.reset();
        //Step 7: Go forward
        while(opModeIsActive() && runtime.seconds() < 1){

            leftDrive.setPower(-FORWARD_SPEED);
            rightDrive.setPower(-FORWARD_SPEED);
        }
runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1.0))
        {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        //Step 8 spit out marker
        boxMotor.setPower(1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0))
        {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

runtime.reset();
        //step 9 go backwards
        while(opModeIsActive() && runtime.seconds() < 1){
            leftDrive.setPower(FORWARD_SPEED*-1);
            rightDrive.setPower(FORWARD_SPEED*-1);
        }


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }
}
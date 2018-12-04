
package org.firstinspires.ftc.teamcode.Methods;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="Pushbot: Auto Drive By Time", group="Pushbot")
public class AutoRedBall extends robotmanager {

    /* Declare OpMode members. */
    private ElapsedTime     runtime = new ElapsedTime();
    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 1;


    @Override
    public void runOpMode() {
        Init();        // The init() method of the hardware class does all the work here

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Ready to run");    //
            telemetry.update();

            // Wait for the game to start (driver presses PLAY)
            waitForStart();


            //Step 1: move lift motor down
            while (runtime.seconds() < 5)
            {
                liftMotor.setPower(2);
                telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }

            // Step 2:  Spin right for 1.3 seconds
            runtime.reset();
            while ( runtime.seconds() < .3)
            {
                leftDrive.setPower(TURN_SPEED);
                rightDrive.setPower(-TURN_SPEED);
                telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }

    //        leftDrive.setPower(0);
    //        rightDrive.setPower(0);

            //Step 3 move forward oh so slightly
            while (runtime.seconds() < .4)
            {
                leftDrive.setPower(FORWARD_SPEED);
                rightDrive.setPower(FORWARD_SPEED);
                telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();

            }

            // Step 4 turn left slightly to straighten up robot
            while (runtime.seconds() < .7)
            {
                    leftDrive.setPower(-TURN_SPEED);
                    rightDrive.setPower(TURN_SPEED);
                    telemetry.addData("Path", "leg 2: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
            }

            //Step 5 move straight for the crater
            leftDrive.setPower(-FORWARD_SPEED);
            rightDrive.setPower(-FORWARD_SPEED);
            runtime.reset();

                while (opModeIsActive() && (runtime.seconds() < 1.0))
                {
                    telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }


            //Step 6 spit out marker
            boxMotor.setPower(1);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 2.0))
                {
                    telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }


            telemetry.addData("Path", "Complete");
            telemetry.update();
        }
    }

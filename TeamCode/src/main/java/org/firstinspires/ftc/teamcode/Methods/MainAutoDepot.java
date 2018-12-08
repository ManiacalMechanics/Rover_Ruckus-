package org.firstinspires.ftc.teamcode.Methods;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="AutoAuto", group="Pushbot")
public class MainAutoDepot extends robotmanager {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 1;


    @Override
    public void runOpMode() {
        Init();        // The init() method of the hardware class does all the work here

        // Send telemetry message to signify robot waiting;


        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
        waitForStart();

        liftMotor.setPower(1);
        try {
            Thread.sleep(5800);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liftMotor.setPower(0);

        //turns right to unhook
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(400);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //goes forward to pass hook
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // turns left to straighten robot
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        try {
            Thread.sleep(750);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        //go to crater
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //spit of marker

        boxMotor.setPower(1);
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        stop();
    }
}


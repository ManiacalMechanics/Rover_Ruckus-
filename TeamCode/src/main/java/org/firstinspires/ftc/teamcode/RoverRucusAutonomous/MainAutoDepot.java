package org.firstinspires.ftc.teamcode.RoverRucusAutonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.teamcode.Methods.robotmanager;


@Autonomous(name="MainAutoDepot", group="Pushbot")
public class MainAutoDepot extends robotmanager {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 1;


    @Override
    public void runOpMode() {
        Init();  // The init() method of the hardware class does all the work here

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        waitForStart();

// This will lower the lift for 5.8 seconds
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
            Thread.sleep(245);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


//go to crater for .9 seconds
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(950);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);

//spit of marker for 1.5 seconds
        boxMotor.setPower(1);
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
//stops robot
        stop();
    }
}


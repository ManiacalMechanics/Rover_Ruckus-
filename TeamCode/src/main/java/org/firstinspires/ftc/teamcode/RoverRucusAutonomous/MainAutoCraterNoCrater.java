package org.firstinspires.ftc.teamcode.RoverRucusAutonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.teamcode.Methods.robotmanager;


@Autonomous(name="MainAutoCraterNoCrater", group="Pushbot")
public class MainAutoCraterNoCrater  extends robotmanager {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 0.6;


    @Override
    public void runOpMode() throws InterruptedException {

        Init();

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
        waitForStart();


// This will lower the lift for 6.61 seconds
        liftMotor.setPower(1);
        try {
            Thread.sleep(6610);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liftMotor.setPower(0);

//stops robot for 1 sec when on ground
        sleep(1000);


//turns right to unhook
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(260);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// goes forward slightly
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(125);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//turns left to face the depot
        leftDrive.setPower(-TURN_SPEED);
        rightDrive.setPower(TURN_SPEED);
        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

 // goes forward hit jewl
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(447);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//back up a little
        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        try {
            Thread.sleep(560);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


// turn right to start facing the depot
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(355);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//goes to wall
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//turns to face depot
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(582);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//goes to depot
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(577);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);

//spits out marker
        boxMotor.setPower(1);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boxMotor.setPower(0);
        sleep(1000);

//lift motor down
        liftMotor.setPower(-1);
        try {
            Thread.sleep(6600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liftMotor.setPower(0);


    }
}

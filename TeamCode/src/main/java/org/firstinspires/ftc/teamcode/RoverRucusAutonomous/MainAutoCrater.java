package org.firstinspires.ftc.teamcode.RoverRucusAutonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.teamcode.Methods.robotmanager;


@Autonomous(name="MainAutoCrater", group="Pushbot")
public class MainAutoCrater  extends robotmanager {

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


        // This will lower the lift for 5.8 seconds
// This will lower the lift for 5.8 seconds
//        liftMotor.setPower(1);
//        try {
//            Thread.sleep(6610);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        liftMotor.setPower(0);

//hits ground and stops


        //turns right to unhook
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(253);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // goes forward slightly
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(125);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

//turns left to face the depot
        leftDrive.setPower(-TURN_SPEED);
        rightDrive.setPower(TURN_SPEED);
        try {
            Thread.sleep(280);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // goes forward hit jewl
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(447);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

//back up a little
        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        try {
            Thread.sleep(560);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }



// turn right to start facing the depot
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(355);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

//goes to wall
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(340);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        sleep(2000);

//turns to face depot
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        try {
            Thread.sleep(555);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

//goes to depot
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        try {
            Thread.sleep(666);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


//        liftMotor.setPower(-1);
//        try {
//            Thread.sleep(6600);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        liftMotor.setPower(0);


    }
}
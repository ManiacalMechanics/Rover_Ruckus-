package org.firstinspires.ftc.teamcode.Methods;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="MainAutoCrater", group="Pushbot")
public class MainAutoCrater  extends robotmanager {

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
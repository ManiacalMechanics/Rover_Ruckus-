package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class driveMethods extends robotmanager{
    void driveTurn(){
        while(opModeIsActive()) {
            drive = -gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive + turn, -1.0, 1.0);
            rightDrive.setPower(rightPower);
            leftDrive.setPower(leftPower);

        }
    }
    void driveTank() {
while(opModeIsActive()){
            leftPower = gamepad1.left_stick_y;
            rightPower = gamepad1.right_stick_y;
    rightDrive.setPower(rightPower);
    leftDrive.setPower(leftPower);


}
    }
}

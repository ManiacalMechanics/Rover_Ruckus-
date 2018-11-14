package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class driveMethods extends BasicOpMode_Linear{
    void driveTurn(){
        leftPower = Range.clip(drive+turn,-1.0,1.0);
        rightPower = Range.clip(drive+turn,-1.0,1.0);
    }
    void driveTank(){
        leftPower  = gamepad1.left_stick_y ;
        rightPower = gamepad1.right_stick_y ;
    }
}

package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public class turndrive extends BasicOpMode_Linear{

    public double drive(double right){
        Init();


        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        //left    = Range.clip(drive + turn, -1.0, 1.0) ;
        right   = Range.clip(drive - turn, -1.0, 1.0) ;
    return right;
    //return left;

    }
}

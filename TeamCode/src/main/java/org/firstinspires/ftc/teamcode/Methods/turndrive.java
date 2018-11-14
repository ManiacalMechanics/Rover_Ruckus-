package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class turndrive extends BasicOpMode_Linear{

    double drive = -gamepad1.left_stick_y;
    double turn  =  gamepad1.right_stick_x;

            double rdrive(){
                Init();
                double rdrive = Range.clip(drive - turn, -1.0, 1.0) ;
                return rdrive();
            }

            double ldrive(){
                Init();
                double ldrive = Range.clip(drive+turn,-1.0,1.0);
                return ldrive();
            }
}

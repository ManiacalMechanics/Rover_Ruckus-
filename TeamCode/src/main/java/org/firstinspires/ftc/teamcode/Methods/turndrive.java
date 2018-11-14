package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class turndrive extends BasicOpMode_Linear{

            double rdrive(double drive,double turn){
                Init();
                return Range.clip(drive+turn,-1.0,1.0);
            }

            double ldrive(double drive, double turn){
                Init();
                return Range.clip(drive+turn,-1.0,1.0);
            }
}

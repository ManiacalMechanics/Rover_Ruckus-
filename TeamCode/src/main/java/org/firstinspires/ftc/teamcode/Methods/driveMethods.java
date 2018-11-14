package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class driveMethods extends BasicOpMode_Linear{

    void driveTurn(double drive, double turn){
        Init();
        leftPower = Range.clip(drive+turn,-1.0,1.0);
        rightPower = Range.clip(drive+turn,-1.0,1.0);
    }
}

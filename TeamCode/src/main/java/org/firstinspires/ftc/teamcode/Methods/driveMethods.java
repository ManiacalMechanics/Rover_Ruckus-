package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

public  class driveMethods extends robotmanager{
     double[] driveTurn(float leftstick, float rightstick){

            drive = leftstick;
            turn = rightstick;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive + turn, -1.0, 1.0);
    return new double[]{rightPower,leftPower};
        }

    double[] driveTank(float leftstick,float rightstick) {

            leftPower = leftstick;
            rightPower = rightstick;
        return new double[]{rightPower,leftPower};


    }
}

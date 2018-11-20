package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

        class driveMethods extends robotmanager{
     double[] driveTurn(float leftstick, float rightstick){
            drive = leftstick;
            turn = rightstick;
    return new double[]{Range.clip(drive + turn, -1.0, 1.0),Range.clip(drive + turn, -1.0, 1.0)};
        }

    double[] driveTank(float leftstick,float rightstick) {
        return new double[]{rightstick,leftstick};
    }
}

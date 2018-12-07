package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.util.Range;

        class driveMethods extends robotmanager{
     double[] driveTurn(float leftstick, float rightstick){
    return new double[]{Range.clip(leftstick + rightstick, -1.0, 2.0),Range.clip(leftstick + rightstick, -1.0, 2.0)};
        }

    double[] driveTank(float leftstick,float rightstick) {
        return new double[]{rightstick,leftstick};
    }
}

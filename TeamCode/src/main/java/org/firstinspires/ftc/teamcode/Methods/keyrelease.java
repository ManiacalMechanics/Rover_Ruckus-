package org.firstinspires.ftc.teamcode.Methods;

public class keyrelease {

    boolean listener,residual=false;

    boolean keyrelease(boolean event){

        boolean xd;
        if(event) {
            listener = true;
            residual = true;
        }else{
            listener = false;
        }
        if(listener==false&&residual==true){
            xd =true;
            return xd;
        }else{
            xd=false;
            return xd;
        }

    }
    void keyreleasecom(){
        residual=false;
    }
}

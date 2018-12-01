package org.firstinspires.ftc.teamcode.Methods;

public class keyrelease {

    boolean listener,residual=false;


    void whenkeypress(boolean event){

        if(event) {
            listener = true;
            residual = true;
        }else{
            listener = false;
        }
    }
    void whenkeyrelease(){
        residual=false;
    }
}

/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.Methods;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
//@Disabled
public class BasicOpMode_Linear extends robotmanager {

    // Declare OpMode members.

    @Override
    public void runOpMode() {

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // drive mode switching
                        if(gamepad1.y){
                            mdswitch*=-1;
                        }

                        if(mdswitch==1){
                            driveMethods.driveTurn();
                        }else{
                            driveMethods.driveTank();
                        }
                                //slowmode button
                                if(gamepad1.right_bumper){
                                    smode*=-1;
                                }

                                    //power delivery
                                    if(smode==1) {
                                        leftDrive.setPower(leftPower);
                                        rightDrive.setPower(rightPower);
                                    }else{
                                        leftDrive.setPower(leftPower*.5);
                                        rightDrive.setPower(rightPower*.5);
                                    }

        // lift motor power and thing
            if(gamepad2.left_bumper){
                liftMotor.setPower(liftPower*1);
            }else{
                if (gamepad2.right_bumper){
                    liftMotor.setPower(liftPower*-1);
                }else{
                    liftMotor.setPower(0);
                }
            }

        //boxservo
            if (gamepad1.b) {
            boxMotor.setPower(-1);
            }else{
                boxMotor.setPower(0);
        }

        //boxext buttons
            if(gamepad2.a){
                boxext.setPower(1);
            }else {
                if(gamepad2.b){
                    boxext.setPower(-1);
                }else {
                    boxext.setPower(0);
                }
        }


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("variable status","smode, mdswitch",smode,mdswitch);
            telemetry.update();
        }
    }
}

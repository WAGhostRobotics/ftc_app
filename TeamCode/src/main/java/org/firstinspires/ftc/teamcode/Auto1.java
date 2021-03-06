/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.HardwareGhostbot;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Ghostbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: GhostbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Ghostbot: Auto Drive By Time", group="Ghostbot")
@Disabled
public class Auto1 extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareGhostbot         robot   = new HardwareGhostbot();   // Use a Ghostbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();


    double     FORWARD_SPEED = 0.5;
    //static final double     TURN_SPEED    = 0.5;
    double rightPoints = 0;
    double leftPoints = 0;
    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
/*
        boolean pressed = robot.sensor_touch.isPressed();
        boolean direction = false;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        telemetry.addData("Status: ", "Running!");
        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 10 seconds
        while (opModeIsActive()) {
            if (pressed && !robot.sensor_touch.isPressed()) {
                pressed = false;
                if (!direction) {
                    robot.leftMotor.setPower(FORWARD_SPEED);
                    robot.rightMotor.setPower(-FORWARD_SPEED);
                    direction = true;
                    rightPoints++;

                } else if (direction) {
                    robot.leftMotor.setPower(-FORWARD_SPEED);
                    robot.rightMotor.setPower(FORWARD_SPEED);
                    direction = false;
                } else {
                    break;
                }

            } else if (!pressed && robot.sensor_touch.isPressed())
                pressed = true;
            if(gamepad1.dpad_up){
                FORWARD_SPEED += 0.1;
            }else if (gamepad1.dpad_down) {
                FORWARD_SPEED -= 0.1;
            }
            telemetry.addData("Right Points: ", rightPoints);
            telemetry.addData("Left Points: ", leftPoints);
            telemetry.addData("Touch Sensor Pressed: ", pressed);
            telemetry.update();
        }
        /*
        robot.leftMotor.setPower(FORWARD_SPEED);
        robot.rightMotor.setPower(FORWARD_SPEED);
        direction=false;
        boolean negative = true;
        runtime.reset();
        while (opModeIsActive() && (negative)) {
            points += 1;
            telemetry.addData("Left: +1 Point!", "Total Points: %2.5f", points);
            telemetry.update();
        }
        // Step 2:  Drive backwards for 10 seconds
        robot.leftMotor.setPower(-FORWARD_SPEED);
        robot.rightMotor.setPower(-FORWARD_SPEED);
        firection=true;
        runtime.reset();
        while (opModeIsActive() && (!negative)) {
            telemetry.addData("Right: +1 Point!", "Total Points: %2.5f", points);
            telemetry.update();
        }
        */

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

    }
}

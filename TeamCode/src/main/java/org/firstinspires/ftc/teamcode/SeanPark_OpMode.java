package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by robotics on 2019-11-03.
 * Testing if template will change
 */

public class SeanPark_OpMode extends OpMode {
    private DcMotor left_Wheel, right_Wheel;
    private double motor_Power;

    public void init(){
        left_Wheel = hardwareMap.dcMotor.get("left_motor");
        right_Wheel = hardwareMap.dcMotor.get("right_motor");
        right_Wheel.setDirection(DcMotorSimple.Direction.REVERSE); // right motor direction set
    }
    public void loop(){
        motor_Power =  -gamepad1.left_stick_y;
        left_Wheel.setPower(motor_Power);
        right_Wheel.setPower(motor_Power);
    }
}

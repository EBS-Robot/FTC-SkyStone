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
    private double motor_Power_l, motor_Power_r;

    public void init(){
        left_Wheel = hardwareMap.dcMotor.get("left_motor");
        right_Wheel = hardwareMap.dcMotor.get("right_motor");
        right_Wheel.setDirection(DcMotorSimple.Direction.REVERSE); // right motor direction set

        //set motors to 0 power
        left_Wheel.setPower(0);
        right_Wheel.setPower(0);
    }

    public void loop(){
        motor_Power_l = -gamepad1.left_stick_y;
        motor_Power_r = -gamepad1.right_stick_y;
        left_Wheel.setPower(motor_Power_l);
        right_Wheel.setPower(motor_Power_r);
    }
}

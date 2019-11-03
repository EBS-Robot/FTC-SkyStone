package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
//created by Jeffrey_Moon 11/3/2019

public class GamepadDrive extends OpMode {

    private DcMotor rightWheel;
    private DcMotor leftWheel;

    private double rightWheelPower;
    private double leftWheelPower;

    @Override
    public void init() {
        leftWheel = hardwareMap.dcMotor.get ("left_wheel");
        rightWheel = hardwareMap.dcMotor.get ("right_wheel");

        rightWheel.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        leftWheelPower = -gamepad1.left_stick_y;
        rightWheelPower = -gamepad1.left_stick_x;

        leftWheel.setPower (leftWheelPower);
        rightWheel.setPower (rightWheelPower);
    }
}

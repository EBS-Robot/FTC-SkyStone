package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//created by Jeffrey_Moon 11/3/2019

public class FourWheelDrive extends OpMode {

    private DcMotor rightWheel1;
    private DcMotor leftWheel1;
    private DcMotor rightWheel2;
    private DcMotor leftWheel2;

//rightWheel2 and leftWheel1 is A. rightWheel1 and leftWheel2 is B.

    private double speedAdjust = 7;

    @Override
    public void init() {
        leftWheel1 = hardwareMap.dcMotor.get ("left_wheel_1");
        rightWheel1 = hardwareMap.dcMotor.get ("right_wheel_1");
        leftWheel2 = hardwareMap.dcMotor.get ("left_wheel_2");
        rightWheel2 = hardwareMap.dcMotor.get ("right_wheel_2");

        rightWheel1.setDirection(DcMotor.Direction.REVERSE);
        rightWheel2.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        leftWheel2.setPower ((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*(-speedAdjust/10));
        rightWheel2.setPower ((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x)*(-speedAdjust/10));
        leftWheel1.setPower ((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*(-speedAdjust/10));
        rightWheel1.setPower ((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)*(-speedAdjust/10));


        telemetry.addData("Speed Adjust", speedAdjust);
    }
}

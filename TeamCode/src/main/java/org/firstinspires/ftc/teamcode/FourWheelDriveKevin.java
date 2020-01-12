package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//created by Jeffrey_Moon 11/3/2019
//Kevin's team

@TeleOp
        (name = "FourWheelDrive", group = "Run")
public class FourWheelDriveKevin extends LinearOpMode {

    private DcMotor rightWheel_1 = null, leftWheel_1 = null, rightWheel_2 = null, leftWheel_2 = null, push = null, rise = null;
    private Servo leftClaw, rightClaw;

//rightWheel_2 and leftWheel_1 is A type. rightWheel_1 and leftWheel_2 is B type.


    @Override

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");

        leftWheel_1 = hardwareMap.dcMotor.get("leftWheel_1");
        rightWheel_1 = hardwareMap.dcMotor.get("rightWheel_1");
        leftWheel_2 = hardwareMap.dcMotor.get("leftWheel_2");
        rightWheel_2 = hardwareMap.dcMotor.get("rightWheel_2");
        push = hardwareMap.dcMotor.get("push");
        rise = hardwareMap.dcMotor.get("rise");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");

        rightWheel_1.setDirection(DcMotor.Direction.FORWARD);
        rightWheel_2.setDirection(DcMotor.Direction.FORWARD);
        push.setDirection(DcMotor.Direction.FORWARD);
        rise.setDirection(DcMotor.Direction.FORWARD);
        leftWheel_1.setDirection(DcMotor.Direction.REVERSE);
        leftWheel_2.setDirection(DcMotor.Direction.REVERSE);
        leftClaw.setPosition(Servo.MAX_POSITION);
        rightClaw.setPosition(Servo.MAX_POSITION);

        telemetry.addData("Status", "Initialized");

        waitForStart();

        while (opModeIsActive()) {

            double rightStick_Y = -gamepad1.right_stick_y;
            double rightStick_X = -gamepad1.right_stick_x;
            boolean rightStick = gamepad1.right_stick_button;
            float rightTrigger = gamepad1.right_trigger;
            boolean rightBumper = gamepad1.right_bumper;
            float leftTrigger = gamepad1.left_trigger;
            boolean leftBumper = gamepad1.left_bumper;
            boolean lift = gamepad1.y;
            boolean drop = gamepad1.a;
            boolean closeClaw = gamepad1.b;
            boolean openClaw = gamepad1.x;
            boolean pushFront = gamepad1.dpad_up;
            boolean pushBack = gamepad1.dpad_down;

            double leftStick_Y = -gamepad1.left_stick_y;
            double leftStick_X = -gamepad1.left_stick_x;
            if (rightStick_X == 0 && rightStick_Y == 0 && leftStick_X == 0 && leftStick_Y == 0) {
                rightWheel_2.setPower(0);
                rightWheel_1.setPower(0);
                leftWheel_2.setPower(0);
                leftWheel_1.setPower(0);
            } else if (rightStick_X > 0 && rightStick_Y == 0 && !rightStick) {
                rightWheel_2.setPower(-rightStick_X);
                rightWheel_1.setPower(rightStick_X);
                leftWheel_2.setPower(rightStick_X);
                leftWheel_1.setPower(-rightStick_X);
            } else if (rightStick_X < 0 && rightStick_Y == 0 && !rightStick) {
                rightWheel_2.setPower(-rightStick_X);
                rightWheel_1.setPower(rightStick_X);
                leftWheel_2.setPower(rightStick_X);
                leftWheel_1.setPower(-rightStick_X);
            } else if (rightStick_X == 0 && rightStick_Y != 0 && !rightStick) {
                rightWheel_2.setPower(rightStick_Y);
                rightWheel_1.setPower(rightStick_Y);
                leftWheel_2.setPower(rightStick_Y);
                leftWheel_1.setPower(rightStick_Y);
            } else if (leftTrigger > 0) {
                rightWheel_1.setPower(1);
                leftWheel_2.setPower(1);
            } else if (leftBumper == true) {
                rightWheel_2.setPower(-1);
                leftWheel_1.setPower(-1);
            } else if (rightTrigger > 0) {
                rightWheel_2.setPower(1);
                leftWheel_1.setPower(1);
            } else if (rightBumper == true) {
                rightWheel_1.setPower(-1);
                leftWheel_2.setPower(-1);
            } else if (leftStick_X != 0) {
                rightWheel_2.setPower(leftStick_X);
                rightWheel_1.setPower(leftStick_X);
                leftWheel_2.setPower(-leftStick_X);
                leftWheel_1.setPower(-leftStick_X);
            }

            if (lift == true) {
                rise.setPower(1);
            } else if (drop == true) {
                rise.setPower(-1);
            } else {
                rise.setPower(0);
            }
            if (closeClaw == true) {
                leftClaw.setPosition(Servo.MIN_POSITION);
                rightClaw.setPosition(Servo.MIN_POSITION);
            } else if (openClaw == true) {
                leftClaw.setPosition(Servo.MAX_POSITION);
                rightClaw.setPosition(Servo.MAX_POSITION);
            }
            if (pushFront == true) {
                push.setPower(1);
            } else if (pushBack == true) {
                push.setPower(-1);
            } else {
                push.setPower(0);
            }

        }



    }}
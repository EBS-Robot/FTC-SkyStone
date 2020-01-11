package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by robotics on 2019-11-10.
 * Testing if template will change
 */

@TeleOp(name = "FederTest", group = "Tests")
public class FederTest extends LinearOpMode {

    private DcMotor rightWheelFront;
    private DcMotor rightWheelBack;
    private DcMotor leftWheelFront;
    private DcMotor leftWheelBack;

    @Override
    public void runOpMode() throws InterruptedException{

        rightWheelFront = hardwareMap.dcMotor.get("rightWheel_1");
        rightWheelBack = hardwareMap.dcMotor.get("rightWheel_2");
        leftWheelFront = hardwareMap.dcMotor.get("leftWheel_1");
        leftWheelBack = hardwareMap.dcMotor.get("leftWheel_2");

        leftWheelFront.setDirection(DcMotor.Direction.REVERSE);
        leftWheelBack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()){

            double rightStick_Y = -gamepad1.right_stick_y;
            double rightStick_X = -gamepad1.right_stick_x;
            boolean rightStick = gamepad1.right_stick_button;

            double leftStick_Y = -gamepad1.left_stick_y;
            double leftStick_X = -gamepad1.left_stick_x;

            boolean bumper_Right = gamepad1.right_bumper;
            boolean bumper_Left = gamepad1.left_bumper;


            if(rightStick_X == 0 && rightStick_Y == 0 && leftStick_X == 0 && leftStick_Y == 0){
                rightWheelBack.setPower(0);
                rightWheelFront.setPower(0);
                leftWheelBack.setPower(0);
                leftWheelFront.setPower(0);
            }
            else if(rightStick_X > 0 && rightStick_Y == 0 && !rightStick){
                rightWheelBack.setPower(-rightStick_X);
                rightWheelFront.setPower(rightStick_X);
                leftWheelBack.setPower(rightStick_X);
                leftWheelFront.setPower(-rightStick_X);
            }
            else if(rightStick_X < 0 && rightStick_Y == 0 && !rightStick){
                rightWheelBack.setPower(-rightStick_X);
                rightWheelFront.setPower(rightStick_X);
                leftWheelBack.setPower(rightStick_X);
                leftWheelFront.setPower(-rightStick_X);
            }
            else if(rightStick_X == 0 && rightStick_Y != 0 && !rightStick) {
                rightWheelBack.setPower(rightStick_Y);
                rightWheelFront.setPower(rightStick_Y);
                leftWheelBack.setPower(rightStick_Y);
                leftWheelFront.setPower(rightStick_Y);
            }
            else if (bumper_Right) {
                rightWheelFront.setPower(1);
                leftWheelBack.setPower(1);
            }
            else if(rightStick_X > 0 && leftStick_Y > 0 && rightStick){
                rightWheelFront.setPower(1);
                leftWheelBack.setPower(1);
            }
            else if(rightStick_X > 0 && leftStick_Y < 0 && rightStick){
                rightWheelBack.setPower(-1);
                leftWheelFront.setPower(-1);
            }
            else if(rightStick_X < 0 && leftStick_Y > 0 && rightStick){
                rightWheelBack.setPower(1);
                leftWheelFront.setPower(1);
            }
            else if(rightStick_X < 0 && leftStick_Y < 0 && rightStick){

                rightWheelFront.setPower(-1);
                leftWheelBack.setPower(-1);
            }
            else if(leftStick_X !=0){
                rightWheelBack.setPower(leftStick_X);
                rightWheelFront.setPower(leftStick_X);
                leftWheelBack.setPower(-leftStick_X);
                leftWheelFront.setPower(-leftStick_X);
            }
            idle();

        }

    }

}

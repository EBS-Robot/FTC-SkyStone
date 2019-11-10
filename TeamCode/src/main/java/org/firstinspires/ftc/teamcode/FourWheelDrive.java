package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
//created by Jeffrey_Moon 11/3/2019


@TeleOp(name="Basic: FourWheelDrive OpMode", group="Iterative Opmode")
@Disabled
public class FourWheelDrive extends OpMode {

    private DcMotor rightWheel_1 = null, leftWheel_1 = null, rightWheel_2 = null, leftWheel_2 = null;
    //private Servo Claw;

//rightWheel2 and leftWheel1 is A type. rightWheel1 and leftWheel2 is B type.

    private double speedAdjust = 7;

    @Override
    public void init() {
        leftWheel_1 = hardwareMap.dcMotor.get("left_wheel_1");
        rightWheel_1 = hardwareMap.dcMotor.get("right_wheel_1");
        leftWheel_2 = hardwareMap.dcMotor.get("left_wheel_2");
        rightWheel_2 = hardwareMap.dcMotor.get("right_wheel_2");

        //Claw = hardwareMap.servo.get ("Claw");

        rightWheel_1.setDirection(DcMotor.Direction.REVERSE);
        rightWheel_2.setDirection(DcMotor.Direction.REVERSE);
        leftWheel_1.setDirection(DcMotor.Direction.FORWARD);
        leftWheel_2.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {
        leftWheel_1.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) * (-speedAdjust / 10));
        rightWheel_1.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) * (-speedAdjust / 10));
        leftWheel_2.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * (-speedAdjust / 10));
        rightWheel_2.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) * (-speedAdjust / 10));
        //speedAdjust is divided by 10 so that the value is easy to see in our phones.

        /*
         if (gamepad2.x) {
            Claw.setPosition(1);
        } else {
            Claw.setPosition(0);
        }*/

        telemetry.addData("Speed Adjust", speedAdjust);
        //while(opModeIsActive()){


        //}

    }
    @Override
    public void stop(){


    }

}
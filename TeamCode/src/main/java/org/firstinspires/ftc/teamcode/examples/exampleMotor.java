package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Training Time take 2")
public class exampleMotor extends OpMode {
    DcMotor fLeft;
    DcMotor fRight;
    DcMotor bLeft;
    DcMotor bRight;

    @Override
    public void init() {
        fLeft = hardwareMap.get(DcMotor.class, "fLeft");
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setPower(0);
        bLeft = hardwareMap.get(DcMotor.class, "fLeft");
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setPower(0);
        bRight = hardwareMap.get(DcMotor.class, "fLeft" );
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setPower(0);
        fRight = hardwareMap.get(DcMotor.class, "fRight");
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight.setPower(0);

    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double r = gamepad1.right_stick_x;
        fRight.setPower(y-x-r);
        fLeft.setPower(y+x-r);
        bLeft.setPower(y-x+r);
        bRight.setPower(y+x+r);
    }
}

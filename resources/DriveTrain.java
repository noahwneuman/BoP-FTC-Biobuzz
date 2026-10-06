package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    public DcMotor fLeft;
    public DcMotor fRight;
    public DcMotor bLeft;
    public DcMotor bRight;
    public DriveTrain(HardwareMap hardwareMap){
        fLeft = hardwareMap.get(DcMotor.class, "fLeft");
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft = hardwareMap.get(DcMotor.class, "fLeft");
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight = hardwareMap.get(DcMotor.class, "fLeft" );
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight = hardwareMap.get(DcMotor.class, "fRight");
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void mecanum(Gamepad gamepad1){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double r = gamepad1.right_stick_x;
        fRight.setPower(y-x-r);
        fLeft.setPower(y+x-r);
        bLeft.setPower(y-x+r);
        bRight.setPower(y+x+r);
    }
}

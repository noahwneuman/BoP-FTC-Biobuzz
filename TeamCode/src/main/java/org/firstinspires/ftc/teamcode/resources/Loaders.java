package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Loaders {
    DcMotor loader;
    public Loaders(HardwareMap hardwareMap){
        loader = hardwareMap.get(DcMotor.class,"loader");
        loader.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void loadUp(Gamepad gamepad1){
        loader.setPower(gamepad1.left_trigger);
    }
    public void autoLoad(double power){
        loader.setPower(power);
    }
}

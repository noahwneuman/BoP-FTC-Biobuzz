package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private final DcMotorEx wheels;

    public Shooter(HardwareMap hardwareMap){
        wheels = hardwareMap.get(DcMotorEx.class, "fWheels");
        wheels.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void activate(double power){
        double MAX_RPM = 6000;
        wheels.setVelocity(power * MAX_RPM);
    }
    public void powerUp(Gamepad gamepad1){
        activate((gamepad1.x) ? 1 : 0);
    }
}

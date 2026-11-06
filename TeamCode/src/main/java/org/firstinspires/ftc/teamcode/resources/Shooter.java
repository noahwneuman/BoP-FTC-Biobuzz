package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private final DcMotorEx wheels;
    double MAX_RPM = 6000;
    DcMotor motor;
    public Shooter(HardwareMap hardwareMap){
        wheels = hardwareMap.get(DcMotorEx.class, "fWheels");
        wheels.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor = hardwareMap.get(DcMotor.class, "motor");
    }
    public void powerUp(Gamepad gamepad2){
        wheels.setVelocity(gamepad2.right_trigger * MAX_RPM);
    }
    public void activate(double power){
        wheels.setVelocity(power * MAX_RPM);
        //USE FOR AUTONOMOUS ONLY
    }
    public void test(Gamepad gamepad1){
        motor.setPower(((gamepad1.x)? 1 : 0));
    }

}

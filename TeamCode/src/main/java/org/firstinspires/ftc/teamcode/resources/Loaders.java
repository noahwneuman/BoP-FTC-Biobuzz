package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Loaders {
    CRServo pLoader;
    CRServo nLoader;

    public Loaders(HardwareMap hardwareMap){
        pLoader = hardwareMap.get(CRServo.class, "pLoader");
        nLoader = hardwareMap.get(CRServo.class, "nLoader");
    }
    public void loadUp(Gamepad gamepad1){
        pLoader.setPower(gamepad1.left_trigger);
        nLoader.setPower(gamepad1.right_trigger);
    }
}

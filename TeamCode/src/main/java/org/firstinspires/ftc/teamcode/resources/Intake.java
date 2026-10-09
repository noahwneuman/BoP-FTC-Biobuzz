package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final DcMotor sWheel;

    public Intake(HardwareMap hardwareMap) {
        sWheel = hardwareMap.get(DcMotor.class, "intake");
        sWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void update (Gamepad gamepad2) {
        spin((gamepad2.y) ? 1 : (gamepad2.x) ? -1 : 0);
    }
    public void spin(double power){
        sWheel.setPower(power);
    }
}
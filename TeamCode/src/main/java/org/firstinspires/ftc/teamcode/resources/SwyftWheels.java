package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SwyftWheels {
    private final DcMotor sWheel;
    private final DigitalChannel beamBreak;

    public SwyftWheels(HardwareMap hardwareMap) {
        sWheel = hardwareMap.get(DcMotor.class, "swyftWheels");
        sWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        beamBreak = hardwareMap.get(DigitalChannel.class, "beamBreak");
    }

    public void update (Gamepad gamepad2) {
        spin((gamepad2.y) ? 1 : (gamepad2.x) ? -1 : 0);
    }
    public void spin(double power){
        sWheel.setPower(power);
    }

    public boolean ballSense (){
        return !beamBreak.getState() && sWheel.getPower() < 0;
    }
}
package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.SwyftWheels;

@TeleOp(name = "DRIVE TEAM, CHOOSE THIS ONE")
public class Tele extends OpMode {

    SwyftWheels s;
    public boolean b = false;


    @Override
    public void init() {
        s = new SwyftWheels(hardwareMap);

    }

    @Override
    public void loop() {
        s.update(gamepad2);
        telemetry.addData("Ball", s.ballSense());

    }
}

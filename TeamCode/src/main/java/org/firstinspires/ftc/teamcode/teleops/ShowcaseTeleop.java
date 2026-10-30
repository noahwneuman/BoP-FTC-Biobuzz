package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;

@TeleOp
public class ShowcaseTeleop extends OpMode {
    DriveTrain d;
    @Override
    public void init() {
        d = new DriveTrain(hardwareMap);
    }

    @Override
    public void loop() {
        d.mecanum(gamepad1);
    }
}

package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.Intake;
import org.firstinspires.ftc.teamcode.resources.Loaders;
import org.firstinspires.ftc.teamcode.resources.Shooter;

@TeleOp(name = "HARDWARE TEST TELEOP" )
public class TestMotor extends OpMode {
    Shooter s;
    Loaders l;
    Intake w;
    @Override
    public void init() {
        s = new Shooter(hardwareMap);
        l = new Loaders(hardwareMap);
        w = new Intake(hardwareMap);
    }

    @Override
    public void loop() {
        s.test(gamepad1);
        l.loadUp(gamepad1);
        w.update(gamepad1);
    }
}

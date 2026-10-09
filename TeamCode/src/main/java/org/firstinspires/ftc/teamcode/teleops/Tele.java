package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;
import org.firstinspires.ftc.teamcode.resources.Intake;
import org.firstinspires.ftc.teamcode.resources.Loaders;
import org.firstinspires.ftc.teamcode.resources.Shooter;

@TeleOp(name = "DRIVE TEAM, CHOOSE THIS ONE")
public class Tele extends OpMode {

    Intake s;
    DriveTrain d;
    Shooter c;
    Loaders l;
    @Override
    public void init() {
        s = new Intake(hardwareMap);
        d = new DriveTrain(hardwareMap);
        c = new Shooter(hardwareMap);
        l = new Loaders(hardwareMap);
    }

    @Override
    public void loop() {
        s.update(gamepad2);
        d.mecanum(gamepad1);
        c.powerUp(gamepad1);
        l.loadUp(gamepad1);
    }
}

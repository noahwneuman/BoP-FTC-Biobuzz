package org.firstinspires.ftc.teamcode.resources;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedro.Constants;

public class PedroDT {
    private final Follower follower;

    public PedroDT(HardwareMap hardwareMap){
        follower = Constants.create(hardwareMap);
    }
    public void drive(Gamepad gamepad1){
         double forward = gamepad1.left_stick_y;
         double lateral = gamepad1.left_stick_x;
         double turn = gamepad1.right_stick_x;
         follower.manual(
           forward,
           lateral,
           turn
         );
         follower.update();
        Pose robotPose = follower.pose();
        telemetry.addData("Robot x location", robotPose.x());
        telemetry.addData("Robot y location", robotPose.y());
        telemetry.addData("Robot heading", Math.toDegrees(robotPose.heading()));
    }
}

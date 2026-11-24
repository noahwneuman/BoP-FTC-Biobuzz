package org.firstinspires.ftc.teamcode.autos;

import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.conditional;
import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.resources.LimeLightAT;

@Autonomous
public class PedroLight extends OpMode{
    private Follower follower;
    private LimeLightAT l;
    private boolean tagRedAud = false;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose startPose = poseFactory.of(56, 0, 90);
    private final Pose path1 = poseFactory.of(56, 36, 90);
    private final Pose firstTrueStart = poseFactory.of(56, 36, 180);
    private final Pose firstTrue = poseFactory.of(42, 36, 180);
    private final Pose firstFalseStart = poseFactory.of(56, 36, 0);
    private final Pose firstFalse = poseFactory.of(70, 36, 0);

    public Path path1() {
        return Paths.line(startPose, path1).linear(startPose, path1);
    }

    public Path firstTrue() {
        return Paths.line(firstTrueStart, firstTrue).linear(firstTrueStart, firstTrue);
    }

    public Path firstFalse() {
        return Paths.line(firstFalseStart, firstFalse).linear(firstFalseStart, firstFalse);
    }

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);

        l = new LimeLightAT(hardwareMap);
    }

    @Override
    public void start() {
        schedule(autoRoutine());
    }

    private Command autoRoutine() {
        return sequential(
                follow(follower, path1()),
                waitMs(200),
                instant(() -> tagRedAud = l.seeTagsRedAud()),
                conditional(() -> tagRedAud,
                        follow(follower, firstTrue()),
                        follow(follower, firstFalse()))
        );
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
        telemetry.addData("Red Aud (35)", l.seeTagsRedAud());
        telemetry.addData("Red Score (31)", l.seeTagsRedScore());
        telemetry.addData("Blue Aud (44)", l.seeTagsBlueAud());
        telemetry.addData("Blue Score (41)", l.seeTagsBlueScore());
        telemetry.addData("Decision (tagRedAud)", tagRedAud);
        telemetry.update();
    }
}

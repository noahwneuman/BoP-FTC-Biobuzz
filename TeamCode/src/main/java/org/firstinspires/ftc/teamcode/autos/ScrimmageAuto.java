package org.firstinspires.ftc.teamcode.autos;

import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;
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
import org.firstinspires.ftc.teamcode.resources.Intake;
import org.firstinspires.ftc.teamcode.resources.Shooter;

@Autonomous
public class ScrimmageAuto extends OpMode {
    private Follower follower;
    private Shooter shooter;
//    private Intake intake;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose startPose = poseFactory.of(0, 80, 0);
    private final Pose path1 = poseFactory.of(30, 80, 0);
    private final Pose path2 = poseFactory.of(58, 20, 0);
    private final Pose path2Control1 = poseFactory.of(30, 20, 0);
    private final Pose shootNowStart = poseFactory.of(58, 20, 90);
    private final Pose shootNow = poseFactory.of(58, 20, 90);
    private final Pose intakeParallelStart = poseFactory.of(58, 20, 90);
    private final Pose intakeParallel = poseFactory.of(58, 45, 90);
    private final Pose path5Start = poseFactory.of(58, 45, 180);
    private final Pose path5 = poseFactory.of(38, 45, 180);
    private final Pose path6Start = poseFactory.of(38, 45, 90);
    private final Pose path6 = poseFactory.of(38, 120, 90);
    private final Pose path7Start = poseFactory.of(38, 120, 0);
    private final Pose path7 = poseFactory.of(58, 120, 0);
    private final Pose point8Start = poseFactory.of(58, 120, 270);
    private final Pose point8 = poseFactory.of(58, 120, 270);
    private final Pose point9 = poseFactory.of(0, 100, 180);
    private final Pose point9Control1 = poseFactory.of(58, 100, 0);

        public Path path1() {
        return Paths.line(startPose, path1).linear(startPose, path1);
    }

    public Path path2() {
        return Paths.curve(path1, path2Control1, path2).tangent();
    }

    public Path shootNow() {
        return Paths.line(shootNowStart, shootNow).linear(shootNowStart, shootNow);
    }

    public Path intakeParallel() {
        return Paths.line(intakeParallelStart, intakeParallel).linear(intakeParallelStart, intakeParallel);
    }

    public Path path5() {
        return Paths.line(path5Start, path5).linear(path5Start, path5);
    }

    public Path path6() {
        return Paths.line(path6Start, path6).linear(path6Start, path6);
    }

    public Path path7() {
        return Paths.line(path7Start, path7).linear(path7Start, path7);
    }

    public Path path8() {
        return Paths.line(point8Start, point8).linear(point8Start, point8);
    }

    public Path path9() {
        return Paths.curve(point8, point9Control1, point9).tangent();
    }

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);

        shooter = new Shooter(hardwareMap);
//        intake = new Intake(hardwareMap);
    }

    @Override
    public void start() {
        schedule(autoRoutine());
    }

    private Command startShoot() {
        return instant(() -> shooter.activate(1));
    }
    private Command endShoot() {
        return instant(() -> shooter.activate(0));
    }
//    private Command startIntake() {
//        return instant(() -> intake.activate(1));
//    }
//    private Command endIntake() {
//        return instant(() -> intake.activate(0));
//    }

    private Command autoRoutine() {
        return sequential(

                follow(follower, path1()),
                follow(follower, path2()),
                follow(follower, shootNow()),
                parallel(startShoot(), waitMs(3000)),
                endShoot(),
                follow(follower, intakeParallel()),
                follow(follower, path5()),
                follow(follower, path6()),
                follow(follower, path7()),
                follow(follower, path8()),
                follow(follower, path9())
        );
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}

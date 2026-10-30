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
    private final Pose path2Start = poseFactory.of(30, 80, 0);
    private final Pose path2 = poseFactory.of(58, 20, 90);
    private final Pose path2Control1 = poseFactory.of(30, 20, 0);
    private final Pose path3Start = poseFactory.of(58, 20, 90);
    private final Pose path3 = poseFactory.of(58, 45, 90);
    private final Pose path4Start = poseFactory.of(58, 45, 180);
    private final Pose path4 = poseFactory.of(38, 45, 180);
    private final Pose path5Start = poseFactory.of(38, 45, 90);
    private final Pose path5 = poseFactory.of(38, 120, 0);
    private final Pose path6Start = poseFactory.of(38, 120, 0);
    private final Pose path6 = poseFactory.of(58, 120, 270);
    private final Pose path7Start = poseFactory.of(58, 120, 270);
    private final Pose path7 = poseFactory.of(0, 100, 0);
    private final Pose path7Control1 = poseFactory.of(58, 100, 0);

    public Path path1() {
        return Paths.line(startPose, path1).linear(startPose, path1);
    }

    public Path path2() {
        return Paths.curve(path2Start, path2Control1, path2).linear(path2Start, path2);
    }

    public Path path3() {
        return Paths.line(path3Start, path3).linear(path3Start, path3);
    }

    public Path path4() {
        return Paths.line(path4Start, path4).linear(path4Start, path4);
    }

    public Path path5() {
        return Paths.line(path5Start, path5).linear(path5Start, path5);
    }

    public Path path6() {
        return Paths.line(path6Start, path6).linear(path6Start, path6);
    }

    public Path path7() {
        return Paths.curve(path7Start, path7Control1, path7).linear(path7Start, path7);
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
                parallel(follow(follower, path2()), (startShoot())),
                waitMs(3000),
                parallel(follow(follower, path3()), (endShoot())),
                follow(follower, path4()),
                follow(follower, path5()),
                parallel(follow(follower, path6()), (startShoot())),
                waitMs(3000),
                parallel (follow(follower, path7()), (endShoot()))
        );
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}

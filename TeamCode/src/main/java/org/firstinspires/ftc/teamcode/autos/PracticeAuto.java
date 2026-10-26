package org.firstinspires.ftc.teamcode.autos;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

@Autonomous
public class PracticeAuto extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();

    // poses go here
    // p.of(x, y, heading);
    private final Pose startPose = p.of(0,0,0);
    private final Pose midPose = p.of(24,0,0);
    private final Pose endPose = p.of(24,36,0);

    private Path move1() {
        return line(startPose, midPose).linear(startPose, midPose);

    }private Path move2() {
        return line(midPose, endPose).linear(midPose, endPose);
    }

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }

    @Override
    public void start() {
        schedule(follow(follower, move1()));
        schedule(follow(follower, move2()));
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}

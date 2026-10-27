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
import com.pedropathing.ivy.Command;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.commands.Commands.waitMs;

@Autonomous
public class PracticeAuto extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();

    // poses go here
    // p.of(x, y, heading);
    private final Pose startPose = p.of(0,0,0);
    private final Pose shootPose = p.of(48,36,90);
    private final Pose parkPose = p.of(0,12,270);

    private Path move1() {
        return line(startPose, shootPose).linear(startPose, shootPose);
    }
    private Path move2() {
        return line(shootPose, parkPose).linear(shootPose, parkPose);
    }

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }

    private Command autoRoutine() {
        return sequential(
                follow(follower, move1()),
                waitMs(3000),
                follow(follower, move2())
        );
    }

    @Override
    public void start() {
        schedule(autoRoutine());
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}

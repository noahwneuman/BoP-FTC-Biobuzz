package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("fLeft");
        c.frontRightName.set("fRight");
        c.backLeftName.set("bLeft");
        c.backRightName.set("bRight");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("odmGear");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-0.4031205740500623);
        c.yPodOffset.set(-1.419044554702879);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.22083061946972377);
                Controller secondaryTranslationalForward = Controller.proportional(0.0815910131912359);
                Controller primaryTranslationalLateral = Controller.proportional(0.23675479985153028);
                Controller secondaryTranslationalLateral = Controller.proportional(0.08747457234037702);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.018438021796316338));
                c.brake.set(Controller.proportionalFeedforward(0.015672318526868886));

                c.headingFeedback.set(Controller.proportional(2.754776787619174));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04626671256405784, 0.0038485689082892365));

                c.linearBrakeCoefficients.set(Matrix.diag(0.08881133649846126, 0.06746856554581121));
                c.quadraticBrakeCoefficients.set(Matrix.diag(7.656320497789817E-4, 0.0011132869813242937));

                c.maxAchievableForwardVelocity.set(57.46057055991048);
                c.maxAchievableStrafeVelocity.set(48.325681080154844);
                c.naturalForwardDeceleration.set(39.32172905346262);
                c.naturalStrafeDeceleration.set(57.5419596488968);
            }
    );
    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
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
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("odmGear");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-0.37843080956166186);
        c.yPodOffset.set(0.0983251361396369);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.19755616424942163);
                Controller secondaryTranslationalForward = Controller.proportional(0.07299172389223153);
                Controller primaryTranslationalLateral = Controller.proportional(0.21239783515916028);
                Controller secondaryTranslationalLateral = Controller.proportional(0.0784753247166294);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0));
                c.brake.set(Controller.proportionalFeedforward(0.014489550111188104));

                c.headingFeedback.set(Controller.proportional(2.0199111788276403));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.5853063332911315, -0.06448513467197567));

                c.linearBrakeCoefficients.set(Matrix.diag(0.14229128187254048, 0.6482911486031249));
                c.quadraticBrakeCoefficients.set(Matrix.diag(-2.054681881393037E-4, -0.0028413348867142134));

                c.maxAchievableForwardVelocity.set(59.60787336696524);
                c.maxAchievableStrafeVelocity.set(50.33609253747285);
                c.naturalForwardDeceleration.set(38.436218867957884);
                c.naturalStrafeDeceleration.set(51.85711882364119);
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
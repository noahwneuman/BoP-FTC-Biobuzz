package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;
import org.firstinspires.ftc.teamcode.resources.LimeLightAT;

@Autonomous
public class TestLimeLight extends LinearOpMode {

    DriveTrain d;
    ElapsedTime e;
    LimeLightAT l;
    boolean tagRedAud = false;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        e = new ElapsedTime();
        d = new DriveTrain(hardwareMap);
        l = new LimeLightAT(hardwareMap);

        waitForStart();
        e.reset();

        while(opModeIsActive()) {
            telemetry.addData("Red Aud (35)", l.seeTagsRedAud());
            telemetry.addData("Red Score (31)", l.seeTagsRedScore());
            telemetry.addData("Blue Aud (44)", l.seeTagsBlueAud());
            telemetry.addData("Blue Score (41)", l.seeTagsBlueScore());
            telemetry.addData("Decision (tagRedAud)", tagRedAud);
            telemetry.update();

            if(e.seconds() <= 1.2) {
                d.autoPowers(-1,-1,-1,-1);
            }
            else if(e.seconds() <= 1.4) {
                d.autoPowers(0,0,0,0);
                tagRedAud = l.seeTagsRedAud();
            }
            else if(e.seconds() <= 2) {
                if(tagRedAud) {
                    d.autoPowers(1,-1,-1,1);
                }
                else {
                    d.autoPowers(-1,1,1,-1);
                }
            }
            else {
                d.autoPowers(0,0,0,0);
                break;
            }
        }
    }
}

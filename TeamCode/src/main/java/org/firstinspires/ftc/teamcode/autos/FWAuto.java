package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;
@Autonomous
public class FWAuto extends LinearOpMode {
    DriveTrain d;
    ElapsedTime e;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        d = new DriveTrain(hardwareMap);
        e = new ElapsedTime();
        e.reset();
        while (true) {
            if (e.seconds() <= 0.15) {
                d.fLeft.setPower(-0.5);
                d.fRight.setPower(-0.5);
                d.bLeft.setPower(-0.5);
                d.bRight.setPower(-0.5);
            }
            else if(e.seconds() == 0.16){
                d.fLeft.setPower(0);
                d.fRight.setPower(0);
                d.bLeft.setPower(0);
                d.bRight.setPower(0);
            }
            else if (e.seconds() <= 0.55) {
                d.fLeft.setPower(0.5);
                d.fRight.setPower(-0.5);
                d.bLeft.setPower(-0.5);
                d.bRight.setPower(0.5);
            }
            else if (e.seconds() >= 0.56) {
                d.fLeft.setPower(0);
                d.fRight.setPower(0);
                d.bLeft.setPower(0);
                d.bRight.setPower(0);
                break;
            }

        }
    }
}

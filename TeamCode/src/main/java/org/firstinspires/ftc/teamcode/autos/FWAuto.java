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
        start();
        e.reset();
        if(e.seconds() <= 4.7){
            d.fLeft.setPower(1);
            d.fRight.setPower(1);
            d.bLeft.setPower(1);
            d.bRight.setPower(1);
        }
//        else if(e.seconds() == 4.700001){
//            d.fLeft.setPower(0);
//            d.fRight.setPower(0);
//            d.bLeft.setPower(0);
//            d.bRight.setPower(0);
//            }

        else if(e.seconds() <=5.1){
            d.fLeft.setPower(1);
            d.fRight.setPower(-1);
            d.bLeft.setPower(1);
            d.bRight.setPower(-1);
        }
        else if(e.seconds() >=5.1000000001){
            d.fLeft.setPower(0);
            d.fRight.setPower(0);
            d.bLeft.setPower(0);
            d.bRight.setPower(0);
        }

    }
}

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
        d = new DriveTrain(hardwareMap);
        start();
        time = e.seconds();
        if(time <= 0.7){
            d.fLeft.setPower(1);
            d.fRight.setPower(1);
            d.bLeft.setPower(1);
            d.bRight.setPower(1);
        }
        if(time == 0.700001){
            d.fLeft.setPower(0);
            d.fRight.setPower(0);
            d.bLeft.setPower(0);
            d.bRight.setPower(0);
        }
        if(time <=1.1){
            d.fLeft.setPower(1);
            d.fRight.setPower(-1);
            d.bLeft.setPower(1);
            d.bRight.setPower(-1);
        }
        if(time >=1.1000000001){
            d.fLeft.setPower(0);
            d.fRight.setPower(0);
            d.bLeft.setPower(0);
            d.bRight.setPower(0);
        }

    }
}

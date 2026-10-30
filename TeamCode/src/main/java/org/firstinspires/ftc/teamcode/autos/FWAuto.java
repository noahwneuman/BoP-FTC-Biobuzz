package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;
//import org.firstinspires.ftc.teamcode.resources.Loaders;
import org.firstinspires.ftc.teamcode.resources.Shooter;

@Autonomous
public class FWAuto extends LinearOpMode {
    DriveTrain d;
    ElapsedTime e;
    Shooter s;
    // Loaders l;


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        d = new DriveTrain(hardwareMap);
        e = new ElapsedTime();
        s = new Shooter(hardwareMap);
        //l = new Loaders(hardwareMap);
        e.reset();
        while (true) {
            if (e.seconds() <= 0.55) {
                d.fLeft.setPower(-0.75);
                d.fRight.setPower(0.75);
                d.bLeft.setPower(-0.75);
                d.bRight.setPower(0.75);
            }
            else if(e.seconds() == 0.56){
                d.fLeft.setPower(0);
                d.fRight.setPower(0);
                d.bLeft.setPower(0);
                d.bRight.setPower(0);
            }

            else if (e.seconds() <= 0.85) {
                d.fLeft.setPower(0.75);
                d.fRight.setPower(0.75);
                d.bLeft.setPower(-0.75);
                d.bRight.setPower(-0.75);
            }
            else if(e.seconds() <= 1.55){
                d.fLeft.setPower(-0.75);
                d.fRight.setPower(-0.75);
                d.bLeft.setPower(-0.75);
                d.bRight.setPower(-0.75);
            }
            else if (e.seconds() <= 1.95) {
                d.fLeft.setPower(0.75);
                d.fRight.setPower(0.75);
                d.bLeft.setPower(-0.75);
                d.bRight.setPower(-0.75);
            }
            else if(e.seconds() <= 3){
                s.activate(1);
                d.fLeft.setPower(0);
                d.fRight.setPower(0);
                d.bLeft.setPower(0);
                d.bRight.setPower(0);
//                if(e.seconds()>= 0.37){
//                    l.autoLoad(1);
//                }
            }
            else if (e.seconds() <= 3.4) {
                d.fLeft.setPower(-0.75);
                d.fRight.setPower(-0.75);
                d.bLeft.setPower(0.75);
                d.bRight.setPower(0.75);
            }

            else if (e.seconds() >= 3.5) {
                d.fLeft.setPower(0);
                d.fRight.setPower(0);
                d.bLeft.setPower(0);
                d.bRight.setPower(0);
                break;
            }

        }
    }
}

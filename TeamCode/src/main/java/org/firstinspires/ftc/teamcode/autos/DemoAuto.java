package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.resources.DriveTrain;

public class DemoAuto extends LinearOpMode {
    DriveTrain d;
    ElapsedTime e;
    @Override
    public void runOpMode() throws InterruptedException {
        d = new DriveTrain(hardwareMap);
        e = new ElapsedTime();
        waitForStart();
        e.reset();
        while(true){
            if(e.seconds() <= 0.75){
                d.autoPowers(0.75,0.75,0.75,0.75);
                // TEST AUTO AND EDIT TIME VALUES AS NEEDED
            }
            else if(e.seconds() <= 0.85){
                d.autoPowers(0.75,0.75,0,-0.75);
            }
            else if(e.seconds() <= 0.9){
                d.autoPowers(-0.75,-0.75,0,0.75);
            }
            else if(e.seconds() <= 0.95){
                d.autoPowers(0.75,0.75,0,-0.75);
            }
            else if(e.seconds() <= 1){
                d.autoPowers(0.75,0.75,0,-0.75);
            }
            else if(e.seconds() <= 1.025) {
                d.autoPowers(-0.75, -0.75, 0, 0.75);
            }
            else if(e.seconds() <= 1.05){
                d.autoPowers(0.75,0.75,0,-0.75);
            }
            else if(e.seconds() <= 1.075) {
                d.autoPowers(-0.75, -0.75, 0, 0.75);
            }
            else if(e.seconds() <= 1.2){
                d.autoPowers(0,0,0,0);
            }
            else if(e.seconds() <= 1.35) {
                d.autoPowers(-0.75, -0.75, 0.75, 0.75);
            }
            else if(e.seconds() <= 1.351){
                d.autoPowers(0,0,0,0);
                break;
            }
        }
    }
}

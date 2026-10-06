package org.firstinspires.ftc.teamcode.tests;

//import com.ftcteams.behaviortrees.DebugTree;
//import com.ftcteams.behaviortrees.Node;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
//import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
//
//@Autonomous(group = "Tests")
//public class TestBehaviorTree extends BoPMode {
//    Node n = new N1();
//
//    @Override
//    public void locInit() {
//
//    }
//
//    @Override
//    public void main() {
//        n.tick(debugTree, this);
//    }
//}
//
//class N1 extends BNode {
////    static boolean c;
////
////    @Override
////    public State tick(DebugTree debug, BoPMode opMode) {
////        if (c) opMode.hwSuite.drive.runMotors(new double[] {-1, -1, -1, -1});
////        else opMode.hwSuite.drive.runMotors(new double[] {1, 1, 1, 1});
////        c ^= true;
////
////        opMode.hwSuite.drive.odometry.update();
////        opMode.telemetry.addData("Pose", opMode.hwSuite.drive.odometry.getPosition());
////        return State.RUNNING;
////    }
//
//    static int i = 0;
//
//    @Override
//    public State tick(DebugTree debug, BoPMode opMode) {
//        opMode.telemetry.addData("I", i);
//        opMode.telemetry.update();
//        i++;
//
//        return State.RUNNING;
//    }
//}

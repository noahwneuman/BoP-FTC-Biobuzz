package org.firstinspires.ftc.teamcode.resources;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class LimeLightAT {
    Limelight3A light;
    LLResult result;
    public LimeLightAT(HardwareMap hardwareMap) {
        light = hardwareMap.get(Limelight3A.class, "limelight");
        light.setPollRateHz(100);
        light.start();
        light.pipelineSwitch(0);
    }
    public boolean seeTagsRedAud(){
        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            int id = fiducial.getFiducialId(); // The ID number of the fiducial
            if(id == 35){
                return true;
            }
        }
        return false;
    }
    public boolean seeTagsRedScore(){
        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            int id = fiducial.getFiducialId(); // The ID number of the fiducial
            if(id == 31){
                return true;
            }
        }
        return false;
    }
    public boolean seeTagsBlueAud(){
        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            int id = fiducial.getFiducialId(); // The ID number of the fiducial
            if(id == 44){
                return true;
            }
        }
        return false;
    }
    public boolean seeTagsBlueScore(){
        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            int id = fiducial.getFiducialId(); // The ID number of the fiducial
            if(id == 41){
                return true;
            }
        }
        return false;
    }
}

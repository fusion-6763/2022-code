package frc.robot.subsystems;
import com.revrobotics.*;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class DriveTrain extends SubsystemBase {
    private final CANSparkMax left1 = new CANSparkMax(Constants.DriveConstants.DRIVE_LEFT_NEO_1,MotorType.kBrushless);
    private final CANSparkMax left2 = new CANSparkMax(Constants.DriveConstants.DRIVE_LEFT_NEO_2,MotorType.kBrushless);
    private final CANSparkMax right1 = new CANSparkMax(Constants.DriveConstants.DRIVE_RIGHT_NEO_1,MotorType.kBrushless);
    private final CANSparkMax right2 = new CANSparkMax(Constants.DriveConstants.DRIVE_RIGHT_NEO_2,MotorType.kBrushless);
    private final MotorControllerGroup leftside = new MotorControllerGroup(left1, left2);
    private final MotorControllerGroup rightside = new MotorControllerGroup(right1, right2); 
    private final DifferentialDrive myRobot = new DifferentialDrive(leftside,rightside);

    public DriveTrain(){
        setDefaultCommand(new RunCommand(this::neutral,this));
    }

    public void drive(Double forwardSpeed, Double leftSpeed){
       myRobot.arcadeDrive(-leftSpeed, -forwardSpeed);
    }

    public void neutral(){
        myRobot.stopMotor();
    }
}
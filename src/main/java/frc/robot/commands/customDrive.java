package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
public class customDrive extends CommandBase{
    private DriveTrain driveTrain; 
    private double forwardSpeed;
    private double turnSpeed;

    public customDrive(DriveTrain _driveTrain, double _forwardSpeed, double _turnSpeed){
        driveTrain = _driveTrain; 
        forwardSpeed = _forwardSpeed;
        turnSpeed = _turnSpeed;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        driveTrain.drive(forwardSpeed, turnSpeed);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

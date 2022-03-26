package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtendingClimber;
public class ClimberLeft extends CommandBase{
    private ExtendingClimber climber; 
    private double speed;
    public ClimberLeft(ExtendingClimber _climber, double _speed){
        climber = _climber;  
        speed = _speed;
        addRequirements(climber);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        climber.runLeft(speed);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

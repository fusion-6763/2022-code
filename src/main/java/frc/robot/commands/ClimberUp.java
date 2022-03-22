package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtendingClimber;
public class ClimberUp extends CommandBase{
    private ExtendingClimber climber; 
    public ClimberUp(ExtendingClimber _climber){
        climber = _climber;  
        addRequirements(climber);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        climber.up();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

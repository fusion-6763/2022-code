package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RotatingClimber;
public class ClimberForward extends CommandBase{
    private RotatingClimber climber; 
    public ClimberForward(RotatingClimber _climber){
        climber = _climber;  
        addRequirements(climber);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        climber.forward();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

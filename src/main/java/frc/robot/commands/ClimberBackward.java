package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RotatingClimber;
public class ClimberBackward extends CommandBase{
    private RotatingClimber climber; 
    public ClimberBackward(RotatingClimber _climber){
        climber = _climber;  
        addRequirements(climber);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        climber.backward();
    }

    @Override
    public void end(boolean interrupted){
        climber.run(0.0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}

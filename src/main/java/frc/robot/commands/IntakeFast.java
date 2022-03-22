package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;
public class IntakeFast extends CommandBase{
    private Tower tower; 
    public IntakeFast(Tower _tower){
        tower = _tower;  
        addRequirements(tower);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        tower.intakeFast();
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;
public class customTower extends CommandBase{
    private Tower tower; 
    private double forwardSpeed;

    public customTower(Tower _tower, double _forwardSpeed){
        tower = _tower; 
        forwardSpeed = _forwardSpeed;
        addRequirements(tower);
    }
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        tower.run(forwardSpeed);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

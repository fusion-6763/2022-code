package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class RotatingClimber extends SubsystemBase {
    private final double speed = Constants.ClimberConstants.rotatingSpeed;
    private final double defaultSpeed = Constants.ClimberConstants.rotatingDefaultSpeed;
    private final Spark motor1 = new Spark(Constants.ClimberConstants.RotatingClimberSparkMax);

    public RotatingClimber(){
        setDefaultCommand(new RunCommand(this::neutral,this));
    }

    public void run(Double forwardSpeed){
      motor1.set(forwardSpeed);
    }
    public void backward(){
        motor1.set(speed);
    }
    public void forward(){
        motor1.set(-speed);
    }

    public void neutral(){
        motor1.set(defaultSpeed);
    }
}
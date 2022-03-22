package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class ExtendingClimber extends SubsystemBase {
    private final double speed = Constants.ClimberConstants.extendingSpeed;
    private final double defaultSpeed = Constants.ClimberConstants.extendingDefaultSpeed;
    private final Spark motor1 = new Spark(Constants.ClimberConstants.SparkPort1);
    private final Spark motor2 = new Spark(Constants.ClimberConstants.SparkPort2);


    public ExtendingClimber(){
        setDefaultCommand(new RunCommand(this::neutral,this));
    }

    public void run(Double forwardSpeed){
      motor1.set(forwardSpeed);
      motor2.set(-forwardSpeed);
    }
    public void down(){
        motor1.set(speed);
        motor2.set(-speed);
    }
    public void up(){
        motor1.set(-speed);
        motor2.set(speed);
    }

    public void neutral(){
        motor1.set(defaultSpeed);
        motor2.set(-defaultSpeed);
    }
}
package frc.robot.subsystems;
import frc.robot.Constants;

import java.io.Console;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class RotatingClimber extends SubsystemBase {
    private final double speed = Constants.ClimberConstants.rotatingSpeed;
    private final double defaultSpeed = Constants.ClimberConstants.rotatingDefaultSpeed;
    private final CANSparkMax motor1 = new CANSparkMax(Constants.ClimberConstants.RotatingClimberSparkMax, MotorType.kBrushless);

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
        //motor1.set(defaultSpeed);
    }
}
package frc.robot.subsystems;
import com.revrobotics.*;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class Tower extends SubsystemBase {
    private final double fastSpeed = Constants.TowerConstants.fastSpeed;
    private final double slowSpeed = Constants.TowerConstants.slowSpeed;
    private final CANSparkMax motor = new CANSparkMax(Constants.TowerConstants.SparkMaxPort,MotorType.kBrushless);


    public Tower(){
        setDefaultCommand(new RunCommand(this::neutral,this));
    }

    public void run(Double forwardSpeed){
      motor.set(forwardSpeed);
    }
    public void intakeFast(){
        motor.set(fastSpeed);
    }
    public void intakeSlow(){
        motor.set(slowSpeed);
    }
    public void outtakeFast(){
        motor.set(-fastSpeed);
    }
    public void outtakeSlow(){
        motor.set(-slowSpeed);
    }

    public void neutral(){
        motor.stopMotor();
    }
}
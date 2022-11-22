package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Input extends SubsystemBase {
    private Joystick joystick;
    
    public Input(){
        this.joystick = new Joystick(Constants.joystickNum);
    }

    public double getX(){
        return this.joystick.getX();
    }

    public double getY(){
        return this.joystick.getY();
    }

    public boolean getButton(int button){
        return this.joystick.getRawButton(button);
    }
}

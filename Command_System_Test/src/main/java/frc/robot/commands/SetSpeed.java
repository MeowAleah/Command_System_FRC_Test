package frc.robot.commands;

import javax.swing.JList.DropLocation;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class SetSpeed extends CommandBase {
    private final Drivetrain drivetrain;
    private final double speed;

    public SetSpeed(Drivetrain drivetrain, double speed){
        this.drivetrain = drivetrain;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        drivetrain.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

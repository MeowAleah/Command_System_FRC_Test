package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        SmartDashboard.putBoolean("Test", true);
        drivetrain.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

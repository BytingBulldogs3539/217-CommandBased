package org.usfirst.frc.team217.robot.autongroups;

import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team217.robot.commands.GearDown;
import org.usfirst.frc.team217.robot.commands.ReleaseGear;
import org.usfirst.frc.team217.robot.commands.ReleaseGearPos;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterPeg extends CommandGroup {

    public CenterPeg() 
    {
    	addSequential(new AutonDrive(RobotMap.whiteLineDistance,5));
    	addSequential(new ReleaseGearPos());
    	addParallel(new ReleaseGear(1));
    	addParallel(new GearDown());
    	addParallel(new AutonDrive(-20, 2));    	
    }
}

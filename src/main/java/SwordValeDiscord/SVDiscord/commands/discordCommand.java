package SwordValeDiscord.SVDiscord.commands;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;
import SwordValeDiscord.SVDiscord.util.verificationData;

public class discordCommand implements CommandExecutor {
	
	//This whole class can be recoded as it does not need the cmd check method.
	
	SwordValeDiscord plugin;
	public discordCommand(SwordValeDiscord plugin) {
		this.plugin = plugin;
	}
	
	Random r = new Random();
	int code;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(sender instanceof Player) {
		
		Player p = (Player) sender;
		//This needs to be somewhat recoded as it is insufficient
			
		if(cmd.getLabel().equalsIgnoreCase("discord")) {
			code = r.nextInt(900000) + 100000;
			
			//Add some sort of MySQL check for this as well.
			if(verificationData.getVerificationData().contains(p.getName())) {
				p.sendMessage("You already have a verification code: " + verificationData.getVerificationData().getInt(p.getName()) + "!");
				return false;
			} else {
				verificationData.getVerificationData().set(p.getName(), code);
				verificationData.saveVerificationData();
				//This can be done more efficiently.
				p.sendMessage("Your discord verification code is: " + String.valueOf(code));
				return true;
			}
			
		}
		
		} else {
			sender.sendMessage("Only players can use this command!");
		}
		
		return false;
	}

}

package SwordValeDiscord.SVDiscord;

import org.bukkit.plugin.java.JavaPlugin;

import SwordValeDiscord.SVDiscord.Listeners.discordClientListener;
import SwordValeDiscord.SVDiscord.Listeners.discordJoinListener;
import SwordValeDiscord.SVDiscord.commands.discordCommand;
import SwordValeDiscord.SVDiscord.util.verificationData;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;


public class SwordValeDiscord extends JavaPlugin
{

	private static JDA discordBot;
	
	public void onEnable() {
		setupDiscord("MzM0NjY1NDA0MTA0MzEwNzg0.DEkRVw.vbu2Hiq4sfr3uSsC4_ILyS0DrXg");
		setupMinecraft();
	}
	
	public void onDisable() {
		discordBot.getPresence().setStatus(OnlineStatus.OFFLINE);
		discordBot.shutdownNow();
	}
	
	private void setupMinecraft() {
		new verificationData(this);
		new discordClientListener(this);
		new discordJoinListener(this);
		
		getCommand("discord").setExecutor(new discordCommand(this));
	}
	
	private void setupDiscord(String token) {
		try {
		discordBot = new JDABuilder(AccountType.BOT)
				.setToken(token)
				.buildAsync();
		discordBot.getPresence().setPresence(OnlineStatus.ONLINE, Game.of("swordvale.net"));
		
		discordBot.setAutoReconnect(true);
		discordBot.addEventListener(new discordClientListener(this));
		discordBot.addEventListener(new discordJoinListener(this));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JDA getDiscord() {
		return discordBot;
	}
	
}
	

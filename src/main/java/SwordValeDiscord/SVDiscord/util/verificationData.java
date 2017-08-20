package SwordValeDiscord.SVDiscord.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;

public class verificationData {
	
	private final SwordValeDiscord plugin;
	public verificationData(SwordValeDiscord plugin) {
		this.plugin = plugin;
		
		setupData();
	}
	
	//This class is fine
	private static File verifyFile;
	private static FileConfiguration verificationData;
	
	private void setupData() {
		if(verifyFile == null) {
		verifyFile = new File(plugin.getDataFolder() + "/verificationData.yml");
		}
		verificationData = YamlConfiguration.loadConfiguration(verifyFile);
		saveVerificationData();
	}
	
	public static FileConfiguration getVerificationData() {
		return verificationData;
	}
	
	public static void saveVerificationData() {
		if(verifyFile == null || verificationData == null) {
			return;
		}
		try {
			verificationData.options().copyDefaults(true);
			verificationData.save(verifyFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

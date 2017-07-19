package SwordValeDiscord.SVDiscord.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;

public class verificationData {
	
	public verificationData() {
		setupData();
	}
	
	private static File verifyFile;
	private static FileConfiguration verificationData;
	
	public static void setupData() {
		if(verifyFile == null) {
		verifyFile = new File(SwordValeDiscord.getPlugin().getDataFolder() + "/verificationData.yml");
		}
		verificationData = YamlConfiguration.loadConfiguration(verifyFile);
		saveVerificationData();
	}
	
	public static FileConfiguration getVerificationData() {
		if(verificationData == null) {
			setupData();
		}
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

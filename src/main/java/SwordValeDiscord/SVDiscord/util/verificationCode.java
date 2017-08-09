package SwordValeDiscord.SVDiscord.util;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;

public class verificationCode {
	
	//Class can be made more efficient - should recode.
	
	private static Random r = new Random();
	private static int verificationCode;
	
	private static HashMap<String, Integer> codeMap = new HashMap<String, Integer>();
	
	private final SwordValeDiscord plugin;
	public verificationCode(SwordValeDiscord plugin) {
		this.plugin = plugin;
	}
	
	public static void create(String userName) {
		verificationCode = r.nextInt(900000) + 100000;
		
		//Need to add MySQL support for each of these methods
		if(!verificationData.getVerificationData().contains(userName.toString())) {
		try {
			codeMap.put(userName.toString(), verificationCode);
			//could possibly use UUID instead of a Player name
			verificationData.getVerificationData().set(userName.toString(), verificationCode);
			verificationData.saveVerificationData();
			Bukkit.getServer().getLogger().info("User " + userName.toString() + " has been given verification code " + verificationCode);
		} catch (Exception e) {
			e.printStackTrace();
			Bukkit.getServer().getLogger().severe("Could not put code " + verificationCode + " for " + userName.toString() + " into a hashmap.");
		}
		} else {
		try {
			Bukkit.getServer().getLogger().info("User " + userName.toString() + " already has a verification code");
		} catch (Exception e) {
			e.printStackTrace();
			Bukkit.getServer().getLogger().severe("Could not check if user " + userName.toString() + " already has a verification code");
		}
		}
	}
	
	public static Integer get(String userName) {
		//Again, a UUID for the player could be used.
		if(codeMap.containsKey(userName)) {
			return codeMap.get(userName);
		} else {
			if(!verificationData.getVerificationData().contains(userName)) {
				Bukkit.getServer().getLogger().severe("User " + userName + " does not have a verification code");
			}
			return verificationData.getVerificationData().getInt(userName);
		}
		
	}

}

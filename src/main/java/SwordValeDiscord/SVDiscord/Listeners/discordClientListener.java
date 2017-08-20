package SwordValeDiscord.SVDiscord.Listeners;


import SwordValeDiscord.SVDiscord.SwordValeDiscord;
import SwordValeDiscord.SVDiscord.util.discordUtil;
import SwordValeDiscord.SVDiscord.util.verificationCode;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class discordClientListener extends ListenerAdapter {
	
	private final SwordValeDiscord plugin;
	public discordClientListener(SwordValeDiscord plugin) {
		this.plugin = plugin;
	}

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		User u = e.getAuthor();
		Message m = e.getMessage();
		
		//This needs to be moved to a mc command.
		
		if(m.getContent().equals("/discord verify")) {
			verificationCode.create(u.getName());
			discordUtil.sendPrivateMessage(u, "Thanks for joining! Your verification code is: " + verificationCode.get(u.getName()));
		}
	}
	
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel objChnl = e.getChannel();
		Message objMsg = e.getMessage();
		User objUser = e.getAuthor();
		
		//This was a test command for discord. Can be removed if no use is found.
		if(objMsg.getContent().equals("/svbot")) {
			objChnl.sendMessage(objUser.getAsMention() + " Need info on the SwordVale Bot? It has been Direct Messaged to you.").queue();
		}
	}
	
}

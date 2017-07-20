package SwordValeDiscord.SVDiscord.Listeners;

import SwordValeDiscord.SVDiscord.SwordValeDiscord;
import SwordValeDiscord.SVDiscord.util.discordUtil;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class discordJoinListener extends ListenerAdapter {
	
	private final SwordValeDiscord plugin;
	public discordJoinListener(SwordValeDiscord plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		User u = e.getMember().getUser();
		
		discordUtil.sendPrivateMessage(u, "Thanks for joining! Your verification code is: **NULL**");
	}
	
	
}

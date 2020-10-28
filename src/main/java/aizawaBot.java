import events.aizawaEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class aizawaBot {

    @RequestMapping("/")
    @ResponseBody

    String home() {
        return "Hello World!";
    }

    public static void main (String args[]) throws LoginException {


        JDABuilder builder = JDABuilder.createDefault("NzQ5NDA3MjE2NTk0OTc2Nzkw.X0rh2w.0XuLs3vJtcXQX_--zvH323_VczI");

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("Watching you sleep"));


        builder.addEventListeners(new aizawaEvents());

        builder.build();

        SpringApplication.run(aizawaBot.class, args);



    }







}

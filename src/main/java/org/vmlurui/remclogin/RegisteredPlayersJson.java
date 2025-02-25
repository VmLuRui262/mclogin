package org.vmlurui.remclogin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.mindrot.jbcrypt.BCrypt;

public class RegisteredPlayersJson {
    private static final File REGISTERED_PLAYERS = new File("registered-players.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static JsonArray jsonArray = new JsonArray();

    public static boolean isPlayerRegistered(String username) {
        return findPlayerObject(username) != null;
    }

    public static boolean isCorrectPassword(String username, String password) {
        JsonObject playerObject = findPlayerObject(username);
        return playerObject != null && BCrypt.checkpw(password, playerObject.get("password").getAsString());
    }

    private static JsonObject findPlayerObject(String username) {
        JsonObject playerObject = null;
        if (jsonArray.size() == 0) {
            return null;
        }
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject playerObjectIndex = jsonArray.get(i).getAsJsonObject(); 
            if (playerObjectIndex.get("name").getAsString().equals(username)) {
                playerObject = playerObjectIndex;
                break;
            }
        }
        return playerObject;
    }

    public static void save(String uuid, String username, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uuid", uuid);
        jsonObject.addProperty("name", username);
        jsonObject.addProperty("password", BCrypt.hashpw(password, BCrypt.gensalt()));
        jsonArray.add(jsonObject);
        try {
            //noinspection UnstableApiUsage
            BufferedWriter bufferedWriter = Files.newWriter(REGISTERED_PLAYERS, StandardCharsets.UTF_8);
            bufferedWriter.write(gson.toJson(jsonArray));
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        if (!REGISTERED_PLAYERS.exists()) {
            return;
        }
        try {
            //noinspection UnstableApiUsage
            BufferedReader bufferedReader = Files.newReader(REGISTERED_PLAYERS, StandardCharsets.UTF_8);
            jsonArray = gson.fromJson(bufferedReader, JsonArray.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removePlayer(String username) { //在原项目没有这一段，被用于Passwd的修改密码及Dereg的删除账户
        jsonArray.remove(findPlayerObject(username));
    }
}


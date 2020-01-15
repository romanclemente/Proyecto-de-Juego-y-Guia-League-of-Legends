package Logica;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.event.ChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class BBDD {
    private String linkUrl = "http://ddragon.leagueoflegends.com/cdn/9.24.2/data/en_US/champion.json";
    private ArrayList<String> campeones;
    private ArrayList<String> preguntas;
    private ArrayList<Campeon> ChampionLeague;

    public BBDD() {
        ChampionLeague = new ArrayList<>();
        campeones = new ArrayList<>();
        preguntas = new ArrayList<>();
        aniadirPreguntas();
        URL url = null;
        try {
            url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader lector = new BufferedReader
                    (new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String linea;
            while ((linea = lector.readLine()) != null) {
                builder.append(linea);
            }
            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONObject jsonObjectGenerico = jsonObject.getJSONObject("data");
            Iterator<String> iterator = jsonObjectGenerico.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                JSONObject jsonObjectParticular = jsonObjectGenerico.getJSONObject(key);
                String version = jsonObjectParticular.getString("version");
                String nombre = jsonObjectParticular.getString("id");
                String titulo = jsonObjectParticular.getString("title");
                String blurb = jsonObjectParticular.getString("blurb");

                JSONObject jsoninfo = jsonObjectParticular.getJSONObject("info");
                int attack = jsoninfo.getInt("attack");
                int defense = jsoninfo.getInt("defense");
                int magic = jsoninfo.getInt("magic");
                int difficulty = jsoninfo.getInt("difficulty");

                Info info = new Info(attack, defense, magic, difficulty);

                JSONArray tags = jsonObjectParticular.getJSONArray("tags");
                String[] roles = new String[tags.length()];
                for (int i = 0; i < tags.length(); i++) {
                    roles[i] = tags.getString(i);
                }
                String partype = jsonObjectParticular.getString("partype");
                JSONObject jsonData = jsonObjectParticular.getJSONObject("stats");
                double hp = jsonData.getDouble("hp");
                double hplevel = jsonData.getDouble("hpperlevel");
                double mp = jsonData.getDouble("mp");
                double mpperlevel = jsonData.getDouble("mpperlevel");
                double movespeed = jsonData.getDouble("movespeed");
                double armor = jsonData.getDouble("armor");
                double armorperlevel = jsonData.getDouble("armorperlevel");
                double spellblock = jsonData.getDouble("spellblock");
                double spellblockperlevel = jsonData.getDouble("spellblockperlevel");
                double attackrange = jsonData.getDouble("attackrange");
                double hpregen = jsonData.getDouble("hpregen");
                double hpregenperlevel = jsonData.getDouble("hpregenperlevel");
                double mpregen = jsonData.getDouble("mpregen");
                double mpregenperlevel = jsonData.getDouble("mpregenperlevel");
                double crit = jsonData.getDouble("crit");
                double critperlevel = jsonData.getDouble("critperlevel");
                double attackdamage = jsonData.getDouble("attackdamage");
                double attackdamageperlevel = jsonData.getDouble("attackdamageperlevel");
                double attackspeedperlevel = jsonData.getDouble("attackspeedperlevel");
                double attackspeed = jsonData.getDouble("attackspeed");
                Stats stats = new Stats(hp, hplevel, mp, mpperlevel, movespeed, armor, armorperlevel, spellblock, spellblockperlevel, attackrange,
                        hpregen, hpregenperlevel, mpregen, mpregenperlevel, crit, critperlevel, attackdamage, attackdamageperlevel, attackspeedperlevel, attackspeed);

                Campeon campeon = new Campeon(version, nombre, titulo, blurb, info, roles, partype, stats);
                ChampionLeague.add(campeon);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void aniadirPreguntas() {
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente armadura base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde el siguiente crecimiento de armadura base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente vida base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente crecimiento de vida?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente regeneracion de vida base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente crecimiento de regeneracion de vida?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde el siguiente daño de ataque base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente velocidad de ataque base?");
        preguntas.add("¿A cual de los siguientes campeones le corresponde la siguiente resistencia de magica base?");

    }

    public ArrayList<Campeon> getChampionLeague() {
        return ChampionLeague;
    }

    public ArrayList<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<String> preguntas) {
        this.preguntas = preguntas;
    }
}



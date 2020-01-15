package Logica;

import java.util.ArrayList;

public class Campeon {
    private String version;
    private String name;
    private String title;
    private String blurb;
    private Info info;
    private String[] tags;
    private String partype;
    private Stats stats;


    public Campeon(String version, String name, String title, String blurb, Info info, String[] tags, String partype, Stats stats) {
        this.version = version;
        this.name = name;
        this.title = title;
        this.blurb = blurb;
        this.info = info;
        this.tags = tags;
        this.partype = partype;
        this.stats = stats;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}

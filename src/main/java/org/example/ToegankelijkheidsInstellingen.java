package org.example;

public class ToegankelijkheidsInstellingen {
    private boolean grootLettertype;
    private boolean vereenvoudigdeInterface;
    private boolean audioMeldingen;

    public ToegankelijkheidsInstellingen() {
        this.grootLettertype = false;
        this.vereenvoudigdeInterface = false;
        this.audioMeldingen = false;
    }

    public void setGrootLettertype(boolean grootLettertype) {
        this.grootLettertype = grootLettertype;
    }

    public void setVereenvoudigdeInterface(boolean vereenvoudigdeInterface) {
        this.vereenvoudigdeInterface = vereenvoudigdeInterface;
    }

    public void setAudioMeldingen(boolean audioMeldingen) {
        this.audioMeldingen = audioMeldingen;
    }

    public boolean isGrootLettertype() {
        return grootLettertype;
    }

    public boolean isVereenvoudigdeInterface() {
        return vereenvoudigdeInterface;
    }

    // Deze getter methode ontbrak
    public boolean isAudioMeldingen() {
        return audioMeldingen;
    }
}
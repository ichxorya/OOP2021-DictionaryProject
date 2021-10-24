package uet.oop.ourtreedictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class DictAudio {

    String voiceName = "kevin16";
    VoiceManager freeVM;
    Voice voice;

    public DictAudio() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
        } else {
            throw new IllegalStateException("Cannot find voice: kevin16");
        }
    }

    public void play(String word) {
        try {
            voice.setRate(190);
            voice.setPitch(150);
            voice.setVolume(3);
            voice.speak(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
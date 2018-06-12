package com.amit_pc.demoapp.utils;

public class Constants {

    public interface CONCEPT_NAME {
        String BOUNDED_SERVICE = "Bounded Service Example";
        String FOREGROUND_SERVICE = "Foreground (started) Service Example";
        String INTENT_SERVICE = "Intent Service Example";
        String STRING_PERMUTATION = "Permutation of String";
        String LOAD_PATTERN = "Load Pattern";
        String PLAY_MUSIC_USING_SERVICE = "Play music using started service";
        String LAUNCH_MODES = "Launch Modes of activity";
    }

    public interface ACTION {
        String MAIN_ACTION = "com.amit_pc.demoapp.utils.action.main";
        String PREV_ACTION = "com.amit_pc.demoapp.utils.action.prev";
        String PLAY_ACTION = "com.amit_pc.demoapp.utils.action.play";
        String NEXT_ACTION = "com.amit_pc.demoapp.utils.action.next";
        String START_FOREGROUND_ACTION = "com.amit_pc.demoapp.utils.action.startforeground";
        String STOP_FOREGROUND_ACTION = "com.amit_pc.demoapp.utils.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        int FOREGROUND_SERVICE = 101;
    }
}
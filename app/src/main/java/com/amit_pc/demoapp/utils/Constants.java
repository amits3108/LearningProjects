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
        public static String MAIN_ACTION = "com.amit_pc.demoapp.utils.action.main";
        public static String PREV_ACTION = "com.amit_pc.demoapp.utils.action.prev";
        public static String PLAY_ACTION = "com.amit_pc.demoapp.utils.action.play";
        public static String NEXT_ACTION = "com.amit_pc.demoapp.utils.action.next";
        public static String STARTFOREGROUND_ACTION = "com.amit_pc.demoapp.utils.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.amit_pc.demoapp.utils.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}
package su.ezhidze.museum.utilities;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String KEY_PREFERENCE_NAME = "museumAppPreference";

    public static final String[] TITLES = {"MAP"};

    public static final Map<String, String> EXPOs_ID = Map.ofEntries(
            entry("#A17BA3", "1"),
            entry("#5B2960", "1"),
            entry("#6B6B6B", "2"),
            entry("#000000", "2"),
            entry("#ED9CEF", "3"),
            entry("#5E2F61", "3"),
            entry("#F489D3", "4"),
            entry("#7D1362", "4"),
            entry("#FFB600", "5"),
            entry("#895F00", "5"),
            entry("#748EC1", "6"),
            entry("#1A468E", "6"),
            entry("#80C0FF", "7"),
            entry("#166FB7", "7"),
            entry("#75F2EE", "8"),
            entry("#14847E", "8"),
            entry("#AB7FEF", "9"),
            entry("#674BAA", "9"),
            entry("#87EF75", "10"),
            entry("#4B9B3B", "10"),
            entry("#ED7777", "11"),
            entry("#993A3A", "11"),
            entry("#EDE84F", "12"),
            entry("#A8A233", "12"));

    public static final String EXPO_ID = "expo_id";
}

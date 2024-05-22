package su.ezhidze.museum.utilities;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import kotlin.Pair;
import su.ezhidze.museum.R;
import su.ezhidze.museum.models.Section;

public class Constants {
    public static final String KEY_PREFERENCE_NAME = "museumAppPreference";

    public static final String[] TITLES = {"Карта", "О музее", "Контакты", "О проекте"};

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

    public static final Map<String, Integer> EXPOs_NAMES = Map.ofEntries(
            entry("1", R.string.expo1Name),
            entry("2", R.string.expo2Name),
            entry("3", R.string.expo3Name),
            entry("4", R.string.expo4Name),
            entry("5", R.string.expo5Name),
            entry("9", R.string.expo9Name),
            entry("11", R.string.expo11Name),
            entry("12", R.string.expo12Name)
    );

    public static final Map<String, Integer> EXPOs_TEXTS = Map.ofEntries(
            entry("1", R.string.expo1Text),
            entry("2", R.string.expo2Text),
            entry("3", R.string.expo3Text),
            entry("4", R.string.expo4Text),
            entry("5", R.string.expo5Text),
            entry("9", R.string.expo9Text),
            entry("11", R.string.expo11Text),
            entry("12", R.string.expo12Text)
    );

    public static final List<Pair<Integer, Integer>> EXPO6_SECTIONS = Arrays.asList(
            new Pair<>(R.string.expo6Name, R.string.expo6Text),
            new Pair<>(R.string.expo6_1Name, R.string.expo6_1Text),
            new Pair<>(R.string.expo6_2Name, R.string.expo6_2Text),
            new Pair<>(R.string.expo6_3Name, R.string.expo6_3Text),
            new Pair<>(R.string.expo6_4Name, R.string.expo6_4Text),
            new Pair<>(R.string.expo6_5Name, R.string.expo6_5Text));

    public static final List<Pair<Integer, Integer>> EXPO7_SECTIONS = Arrays.asList(
            new Pair<>(R.string.expo7_1Name, R.string.expo7_1Text),
            new Pair<>(R.string.expo7_2Name, R.string.expo7_2Text),
            new Pair<>(R.string.expo7_3Name, R.string.expo7_3Text),
            new Pair<>(R.string.expo7_4Name, R.string.expo7_4Text));

    public static final List<Pair<Integer, Integer>> EXPO8_SECTIONS = Arrays.asList(
            new Pair<>(R.string.expo8_1Name, R.string.expo8_1Text),
            new Pair<>(R.string.expo8_2Name, R.string.expo8_2Text),
            new Pair<>(R.string.expo8_3Name, R.string.expo8_3Text),
            new Pair<>(R.string.expo8_4Name, R.string.expo8_4Text),
            new Pair<>(R.string.expo8_5Name, R.string.expo8_5Text),
            new Pair<>(R.string.expo8_6Name, R.string.expo8_6Text),
            new Pair<>(R.string.expo8_7Name, R.string.expo8_7Text),
            new Pair<>(R.string.expo8_8Name, R.string.expo8_8Text));

    public static final Map<String, Integer> EXPOs_AUDIOS = Map.ofEntries(
            entry("1", R.raw.expo1),
            entry("2", R.raw.expo2),
            entry("3", R.raw.expo3),
            entry("4", R.raw.expo4),
            entry("5", R.raw.expo5),
            entry("9", R.raw.expo9),
            entry("11", R.raw.expo11),
            entry("12", R.raw.expo12)
    );

    public static final List<Integer> EXPO6_AUDIOS = Arrays.asList(
            R.raw.expo6,
            R.raw.expo6_1,
            R.raw.expo6_2,
            R.raw.expo6_3,
            R.raw.expo6_4,
            R.raw.expo6_5);

    public static final List<Integer> EXPO7_AUDIOS = Arrays.asList(
            R.raw.expo7_1,
            R.raw.expo7_2,
            R.raw.expo7_3,
            R.raw.expo7_4);

    public static final List<Integer> EXPO8_AUDIOS = Arrays.asList(
            R.raw.expo8_1,
            R.raw.expo8_2,
            R.raw.expo8_3,
            R.raw.expo8_4,
            R.raw.expo8_5,
            R.raw.expo8_6,
            R.raw.expo8_7,
            R.raw.expo8_8);

    public static final List<Integer> EXPO10_AUDIOS = Arrays.asList(
            R.raw.expo10_1,
            R.raw.expo10_2);

    public static final List<Pair<Integer, Integer>> EXPO10_SECTIONS = Arrays.asList(
            new Pair<>(R.string.expo10_1Name, R.string.expo10_1Text),
            new Pair<>(R.string.expo10_2Name, R.string.expo10_2Text));

    public static final Map<Integer, Integer> EXPOs_Sections_Counts = Map.ofEntries(
            entry(6, 6),
            entry(7, 4),
            entry(8, 10),
            entry(10, 2)
    );

    public static final String EXPO_ID = "expo_id";

    public static final String KEY_SECTION = "section";

    public static List<Section> expo6Sections = new ArrayList<>();

    public static List<Section> expo7Sections = new ArrayList<>();

    public static List<Section> expo8Sections = new ArrayList<>();

    public static List<Section> expo10Sections = new ArrayList<>();
}

package club.cser.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String listToString(List<? extends Object> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public static String listToSortedString(List<? extends Object> list) {
        return list.stream().map(Object::toString).sorted().collect(Collectors.joining("\n"));
    }

    public static String intToString(int[][] intval) {
        return Arrays.stream(intval).map(Arrays::toString).reduce((a, b) -> a + b).get();
    }

    public static String charToString(char[][] chs) {
        return Arrays.stream(chs).map(Arrays::toString).reduce((a, b) -> a + b).get();
    }

    public static String charToString(boolean[][] chs) {
        return Arrays.stream(chs).map(Arrays::toString).reduce((a, b) -> a + "\n" + b).get();
    }

    public static List<List<String>> JSONTo2DList(String JSONString) {
        List<List<String>> res = new ArrayList<>();
        try {
            res = objectMapper.readValue(JSONString, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParsingExample {

    public static void main(String[] args) {
        //String data = "{\"items\":[{\"label\":\"캐시미어 100% 터틀넥 스웨터\",\"price\":70000},{\"label\":\"반팔 스트라이프 스웨터\",\"price\":30000},{\"label\":\"화이트 스포츠 점퍼\",\"price\":150000}]}";
        String data = "{\n" +
                "       \"items\": [\n" +
                "         {\n" +
                "           \"label\": \"캐시미어 100% 터틀넥 스웨터\",\n" +
                "           \"price\": 70000\n" +
                "         },\n" +
                "         {\n" +
                "           \"label\": \"반팔 스트라이프 스웨터\",\n" +
                "           \"price\": 30000\n" +
                "         },\n" +
                "         {\n" +
                "           \"label\": \"화이트 스포츠 점퍼\",\n" +
                "           \"price\": 150000\n" +
                "         }\n" +
                "       ]\n" +
                "   }";
        List<Items> result = solution(data);

        for (Items item : result) {
            System.out.println(item.getLabel() + ", " + item.getPrice());
        }

    }

    private static List<Items> solution(String data) {
        List<Items> list = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {
            JSONObject parseData = (JSONObject) parser.parse(data);
            JSONArray jsonArray = (JSONArray) parseData.get("items");


            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);

                String label = (String) obj.get("label");
                int price = Integer.parseInt(String.valueOf(obj.get("price")));

                list.add(new Items(label, price));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Collections.sort(list);

        return list;
    }
}

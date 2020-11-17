package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler {

    public Map<String, String> getDictionary(List<String> list) {
        Map<String, String> map = new HashMap<>();
        for (String s : list) {
            String[] arr = s.split(" ");
            if (arr.length == 3) {
                map.put(arr[1] + " " + arr[2], arr[0]);
            } else {
                map.put(arr[1], arr[0]);
            }
        }
        return map;
    }

    public List<String> getList(List<String> list) {
        List<String> answer = new ArrayList<>();
        for (String s : list) {
            String[] arr = s.split(" ");
            if (arr.length == 3) {
                answer.add(arr[1] + " " + arr[2]);
            } else {
                answer.add(arr[1]);
            }
        }
        return answer;
    }
}

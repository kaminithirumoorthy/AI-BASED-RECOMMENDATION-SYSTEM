import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> userRatings = new HashMap<>();

        userRatings.put("User1", Map.of("Laptop", 5, "Phone", 4));
        userRatings.put("User2", Map.of("Laptop", 4, "Headphones", 5));
        userRatings.put("User3", Map.of("Phone", 5, "Headphones", 4));

        recommendItems(userRatings, "User1");
    }

    public static void recommendItems(Map<String, Map<String, Integer>> data, String user) {

        Set<String> userItems = data.get(user).keySet();
        Map<String, Integer> recommendations = new HashMap<>();

        for (String otherUser : data.keySet()) {
            if (!otherUser.equals(user)) {
                for (Map.Entry<String, Integer> entry : data.get(otherUser).entrySet()) {
                    if (!userItems.contains(entry.getKey())) {
                        recommendations.put(entry.getKey(),
                                recommendations.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }
            }
        }

        System.out.println("Recommended items for " + user + ":");
        for (String item : recommendations.keySet()) {
            System.out.println(item);
        }
    }
}
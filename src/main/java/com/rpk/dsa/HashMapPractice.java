package com.rpk.dsa;

public class HashMapPractice {



    /* 
    public static void main(String[] args) {
        // Create a HashMap to store key-value pairs
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Retrieve a value using a key
        int value = map.get("Banana");
        System.out.println("Value for key 'Banana': " + value); // Output: 2

        // Check if a key exists in the HashMap
        boolean hasKey = map.containsKey("Apple");
        System.out.println("Does the key 'Apple' exist? " + hasKey); // Output: true

        // Remove a key-value pair from the HashMap
        map.remove("Orange");

        // Iterate over the HashMap and print all key-value pairs
        System.out.println("Current HashMap contents:");
        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        java.util.HashMap<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


    }
}

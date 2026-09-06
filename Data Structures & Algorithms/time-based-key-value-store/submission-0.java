class TimeMap {
    Map<String, TreeMap<Integer, String>> h;

    public TimeMap() {
        h = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        h.computeIfAbsent(key, k -> new TreeMap<>())
         .put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!h.containsKey(key)) return "";

        Map.Entry<Integer, String> e =
            h.get(key).floorEntry(timestamp);

        return e == null ? "" : e.getValue();
    }
}
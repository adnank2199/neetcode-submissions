class TimeMap {
    Map<String, TreeMap<Integer, String>> h;

    public TimeMap() {
        h = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        h.computeIfAbsent(key , k -> new TreeMap<>()).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(h.get(key) == null)
        return "" ;
        else
        return (h.get(key).floorEntry(timestamp)==null ? "" : h.get(key).floorEntry(timestamp).getValue());
    }
}
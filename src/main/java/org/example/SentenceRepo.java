package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SentenceRepo {
    Map<ReplyType,Map<String,String>> sentences = new ConcurrentHashMap<>();
    Map<ReplyType , String> NoSentence = new ConcurrentHashMap<>();
    private static SentenceRepo instance;
    private SentenceRepo() {

    }
    public static SentenceRepo getInstance() {
        if (instance == null) {
            return new SentenceRepo();
        }
        return instance;
    }

    public void AddSentence(String key, String value , ReplyType type) {
        sentences.get(type).put(key,value);
    }
    public String GetSentence(String key,ReplyType type) {
        return sentences.get(type).getOrDefault(key  , NoSentence.get(type));
    }
    public void RemoveSentence(String key,ReplyType type) {
        sentences.get(type).remove(key);
    }

    public void UpdateSentence(String key, String value,ReplyType type) {
        sentences.get(type).put(key,value);
    }
    public void AddDefault (ReplyType type,String value) {
        NoSentence.put(type,value);
    }
    public void AddType (ReplyType type) {
        sentences.put(type,new ConcurrentHashMap<>());

    }
}

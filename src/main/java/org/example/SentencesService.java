package org.example;

public class SentencesService {

    private final SentenceRepo sentenceRepo=  SentenceRepo.getInstance();
    private static SentencesService instance;
    private SentencesService() {

    }
    public static SentencesService getInstance() {
        if (instance == null) {
            instance = new SentencesService();
        }
        return instance;
    }
    public String PrepareSentence(String sentence) {
        if (sentence==null)return null;
        return sentence.strip().toLowerCase();
    }

    public void AddSentence(String key, String value , ReplyType type) {
        key = PrepareSentence(key);
        if (key==null)return;
        sentenceRepo.AddSentence(key,value,type);
    }
    public String GetSentence(String key,ReplyType type) {
        key = PrepareSentence(key);
        if (key==null)return null;

        return sentenceRepo.GetSentence(key,type);
    }
    public void RemoveSentence(String key,ReplyType type) {
        key = PrepareSentence(key);
        if (key==null)return;
        sentenceRepo.RemoveSentence(key,type);
    }

    public void UpdateSentence(String key, String value,ReplyType type) {
        key = PrepareSentence(key);
        if (key==null)return;
        sentenceRepo.UpdateSentence(key,value,type);

    }
    public void AddDefault(ReplyType type , String value) {
        if (type==null)return;
        sentenceRepo.AddDefault(type,value);
    }
    public void AddType(ReplyType type) {
        if (type==null)return;
        sentenceRepo.AddType(type);
    }

}



package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
public class builder {
    private final SentencesService service =  SentencesService.getInstance();
    private static builder instance;
    private builder() {
        Start();

    }
    public static builder getInstance(){
        if (instance == null){
            instance = new builder();
        }
        return instance;
    }
    private void Start() {
        InputStream is = builder.class.getResourceAsStream("/package.json");
        Map<ReplyType, Map<String, String>> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(is, new TypeReference<Map<ReplyType, Map<String, String>>>() {
            });
        }
        catch (Exception e) {
            //
        }
        System.out.println(map);
        for (ReplyType type : ReplyType.values()) {
            service.AddType(type);
        }
        for (Map.Entry<ReplyType, Map<String, String>> outerEntry: map.entrySet()){
            ReplyType type = outerEntry.getKey();
            for (Map.Entry<String, String> innerEntry: outerEntry.getValue().entrySet()){

                String key = innerEntry.getKey();
                String value = innerEntry.getValue();

                if (key.equals("any other text")){
                    service.AddDefault(type, value);
                    continue;
                }
                System.out.println(key+" "+value+" "+type);
                service.AddSentence(key,value,type);

            }
        }

    }
}

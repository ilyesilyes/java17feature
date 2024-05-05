package org.example.fortest;

import java.util.Map;

public class MyDictionary {
    Map<String, String> wordMap;
    public String getMeaning(String aWord) {
        return wordMap.get(aWord);
    }
}

package com.urlgen.hack.impl;

import com.urlgen.hack.GenerateUniqueUrl;

public class GenerateUniqueUrlImpl implements GenerateUniqueUrl {

    private final String characterMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int charBase = characterMap.length();

    @Override
    public String getUniqueUrl(String targetUserId, String templateId, String salesUserId) {
        StringBuilder sb = new StringBuilder();
        int num = Math.abs(covertToInteger(targetUserId,templateId,salesUserId));
        while (num > 0) {
            sb.append(characterMap.charAt(num % charBase));
            num /= charBase;
        }
        return sb.reverse().toString();
    }

    public int covertToInteger(String targetUserId, String templateId, String salesUserId){
        String str = targetUserId + templateId+ salesUserId;
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash*31 + str.charAt(i);
        }
        return hash;
    }


    public static void main(String[] args) {
        GenerateUniqueUrlImpl generateUniqueUrl = new GenerateUniqueUrlImpl();
        System.out.println(generateUniqueUrl.getUniqueUrl("asdfghjl","qwertyuio112","qwertyuivbn678"));
    }
}


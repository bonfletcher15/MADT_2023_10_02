package com.example.madt_2023_10_02;

public class WordsCounter
{
    public static String getWordsCount(String input)
    {
        input = input.trim();
        if (input.isEmpty())
        {
            return "0";
        }
        String[] words = input.split("[\\s.,]+");
        return String.valueOf(words.length);
    }
}
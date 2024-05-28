package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine = new SuggestionEngine();


    @Test
    public void testLoadDictionaryData() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        Assertions.assertTrue(suggestionEngine.getWordSuggestionDB().containsKey("hello"));
        Assertions.assertFalse(suggestionEngine.getWordSuggestionDB().containsKey("zxcvbnm"));
        Assertions.assertEquals(1, suggestionEngine.getWordSuggestionDB().get("hello"));
    }

    @Test
    public void testGenerateSuggestionsEmptyInput() {
        String suggestions = suggestionEngine.generateSuggestions("");
        Assertions.assertTrue(suggestions.isEmpty());
    }
    
    @Test
    public void testGenerateSuggestionsCorrectWord() {
        String suggestions = suggestionEngine.generateSuggestions("hello");
        Assertions.assertEquals("", suggestions);
    }
}

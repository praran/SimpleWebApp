package com.develogical.app;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is("No answer"));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void willRespondToQuestonsWhatIsYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("basil"));
    }

    @Test
    public void willRespondToQuestonToAddTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 20 plus 20"), containsString("40"));
    }
}

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
        assertThat(queryProcessor.process("58dc6de0: what is 9 plus 3"), is("12"));
    }

    //fb8fbe00:  which  of  the  following  numbers  is  the  largest:  447,  2,  150,  47

    @Test
    public void willRespondToQuestonToLargestNumbers() throws Exception {
        assertThat(
                queryProcessor.
                        process("fb8fbe00:  which  of  the  following  numbers  is  the  largest:  447,  2,  150,  47"),
                is("447"));
    }

    @Test
    public void willRespondToQuestonForSquareAndCubes() throws Exception {
        assertThat(
                queryProcessor.
                        process("d3389780: which of the following numbers is both a square and a cube: 1, 3, 64"),
                is("1, 64"));
    }
}

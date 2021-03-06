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

    //38cd5870:  which  of  the  following  numbers  are  primes:  623,  227
    @Test
    public void willRespondToQuestionPrimeNumbers() throws Exception {
        assertThat(
                queryProcessor.
                        process("38cd5870:  which  of  the  following  numbers  are  primes:  3,  7,  10"),
                is("3, 7"));
    }

    //903d77d0:  what  is  0  multiplied  by  10"
    @Test
    public void willRespondToQuestonToMultiplyTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("903d77d0: what is 0 multiplied by 10"), is("0"));
    }

    @Test
    public void willRespondToQuestonNthFibonnaciSequence() throws Exception {
        assertThat(queryProcessor.process("ea4da160: what is the 6th number in the Fibonacci sequence"), is("8"));
    }
}

package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new PhrasesNeedingWordsIterator();
    }


    private class PhrasesNeedingWordsIterator implements Iterator<Phrase> {
        private int numWordsNeeded;
        Iterator phraseIterator;

        private PhrasesNeedingWordsIterator() {
            phraseIterator = phrases.iterator();
            calculateNumWordsNeeded();
        }

        @Override
        public boolean hasNext() {
            return (numWordsNeeded > 0);
        }

        @Override
        public Phrase next() {
            Phrase phrase = (Phrase) phraseIterator.next();
            while (!phrase.needsWord()) {
                phrase = (Phrase) phraseIterator.next();
            }
            numWordsNeeded--;
            return phrase;
        }

        private void calculateNumWordsNeeded() {
            Iterator<Phrase> iterator = phrases.iterator();
            while (iterator.hasNext()) {
                if(iterator.next().needsWord()) {
                    numWordsNeeded++;
                }
            }
        }
    }


}

package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public class NameRepo implements Container {

    public String names[] = {"Stephen", "Daniel", "John", "Edwin"};
    @Override
    public Iterator getIterator() {
        return new getNameIterator();
    }

    private class getNameIterator implements Iterator{

        int index = 0;
        @Override
        public boolean hasNext() {
            if(index < names.length) return true;
            else return false;
        }

        @Override
        public Object next() {

            if(this.hasNext())
                return names[index++];
            else
                return null;
        }
    }
}

package home;

import home.Observer;
interface Subject{

    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();
    public Object getCurrentValue(Observer observer);


}
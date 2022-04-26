package home;

import java.util.ArrayList;
import java.util.List;
public class News implements Subject {
    private List<Observer> observers;
    private String headline;
    private boolean is_news_updated;
    private final Object lock_object=new Object();

    public News(){
        this.observers=new ArrayList();
    }


    @Override
    public void register(Observer observer) {
        if(observer==null) throw new NullPointerException("Null Observer");
        synchronized(lock_object){
            if(!observers.contains(observer)) observers.add(observer);
        }
        
    }

    @Override
    public void unregister(Observer observer) {
            synchronized(lock_object){
                observers.remove(lock_object);
            }
        
    }

    @Override
    public void notifyObservers() {
        List<Observer> local_observers=null;
        synchronized(lock_object){
            if(!is_news_updated)return;
                
            local_observers=new ArrayList<Observer>(this.observers);
            this.is_news_updated=false;

        }
        for(Observer obj:local_observers){
            obj.update();
        }
        
    }

    @Override
    public Object getCurrentValue(Observer observer) {
        
        return this.headline;
    }

    public void postNews(String news){
        System.out.println("news updated: news title is "+news);
        this.headline=news;
        this.is_news_updated=true;
        notifyObservers();

    }
    
}

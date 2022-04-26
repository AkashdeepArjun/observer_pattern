package home;

public class Subscriber implements Observer {

    private String name;
    private Subject subject;
    public Subscriber(String name){
        this.name=name;
    }

    @Override
    public void setSubject(Subject subject) {
       this.subject=subject;
        
    }

    @Override
    public void update() {
        String news_title=(String) subject.getCurrentValue(this);
        if(news_title==null){
            System.out.println("nothing is new");

        }else{
            System.out.println(this.name+" got news "+news_title);
        }
        
    }
    
}

package home;

public class TestOp {

    public static void main(String[] args){

        News news_source=new News();
        Observer akash=new Subscriber("akashdeep");
        Observer aman = new Subscriber("amandeep");
        Observer gaurav= new Subscriber("gaurav jassal");

        news_source.register(akash);
        news_source.register(aman);
        news_source.register(gaurav);

        akash.setSubject(news_source);
        aman.setSubject(news_source);
        gaurav.setSubject(news_source);


        akash.update();

        news_source.postNews("Welcome to coding world");


    }
    
    
}

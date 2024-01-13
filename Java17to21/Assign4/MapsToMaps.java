package Java17to21.Assign4;
import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120000); 
        channelToSubscribers.put("JustForGags", 10000); 
        channelToSubscribers.put("ContemplationTechniques", 10000); 
        channelToSubscribers.put("A New Earth", 20000); 
        
        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)   
        // V2 -> V1
        channelToPublisher.forEach( (c,p) -> {
            if (channelToSubscribers.containsKey(c)) {
                if (publisherToSubscribers.containsKey(p)) {
                    publisherToSubscribers.put(p, publisherToSubscribers.get(p)+channelToSubscribers.get(c));
                } else {
                    publisherToSubscribers.put(p, channelToSubscribers.get(c));
                }
            }
        });



        // 2. Output "publisherToSubscribers"
        publisherToSubscribers.forEach((p, v) -> System.out.println("Publisher: "+p+", subscribers: "+v));


        // 3. Who has the most/least subscribers?
        class Tuplet {
            public String pub = null;
            public Integer sub = null;
            public void set(String pub, Integer sub) {
                this.pub = pub;
                this.sub = sub;
            }
        }

        Tuplet least = new Tuplet();
        Tuplet most = new Tuplet();        

        publisherToSubscribers.forEach((p, s) -> {
            if (least.sub == null || least.sub > s) { least.set(p, s);  }
            if (most.sub == null || most.sub < s) { most.set(p, s);  }
        });

        System.out.println("Publisher with most subscribers: "+most.pub + " " + most.sub);
        System.out.println("Publisher with least subscribers: "+least.pub + " " + least.sub);

    }

}

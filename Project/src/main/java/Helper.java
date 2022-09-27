import java.util.ArrayList;

public class Helper {
    public ArrayList<Long> xmlSet1RandomText,
            xmlSet2RandomText,
            xmlSet3RandomText,
            xmlSet1SameText,
            xmlSet2SameText,
            xmlSet3SameText,
            gzipSet1RandomText,
            gzipSet2RandomText,
            gzipSet3RandomText,
            gzipSet1SameText,
            gzipSet2SameText,
            gzipSet3SameText,
            protobufSet1RandomText,
            protobufSet2RandomText,
            protobufSet3RandomText,
            protobufSet1SameText,
            protobufSet2SameText,
            protobufSet3SameText;

    public Helper() {
        this.xmlSet1RandomText = new ArrayList<>();
        this.xmlSet2RandomText = new ArrayList<>();
        this.xmlSet3RandomText = new ArrayList<>();
        this.xmlSet1SameText = new ArrayList<>();
        this.xmlSet2SameText = new ArrayList<>();
        this.xmlSet3SameText = new ArrayList<>();
        this.gzipSet1RandomText = new ArrayList<>();
        this.gzipSet2RandomText = new ArrayList<>();
        this.gzipSet3RandomText = new ArrayList<>();
        this.gzipSet1SameText = new ArrayList<>();
        this.gzipSet2SameText = new ArrayList<>();
        this.gzipSet3SameText = new ArrayList<>();
        this.protobufSet1RandomText = new ArrayList<>();
        this.protobufSet2RandomText = new ArrayList<>();
        this.protobufSet3RandomText = new ArrayList<>();
        this.protobufSet1SameText = new ArrayList<>();
        this.protobufSet2SameText = new ArrayList<>();
        this.protobufSet3SameText = new ArrayList<>();
    }

    public Helper(ArrayList<Long> xmlSet1RandomText, ArrayList<Long> xmlSet2RandomText, ArrayList<Long> xmlSet3RandomText, ArrayList<Long> xmlSet1SameText, ArrayList<Long> xmlSet2SameText, ArrayList<Long> xmlSet3SameText, ArrayList<Long> gzipSet1RandomText, ArrayList<Long> gzipSet2RandomText, ArrayList<Long> gzipSet3RandomText, ArrayList<Long> gzipSet1SameText, ArrayList<Long> gzipSet2SameText, ArrayList<Long> gzipSet3SameText, ArrayList<Long> protobufSet1RandomText, ArrayList<Long> protobufSet2RandomText, ArrayList<Long> protobufSet3RandomText, ArrayList<Long> protobufSet1SameText, ArrayList<Long> protobufSet2SameText, ArrayList<Long> protobufSet3SameText) {
        this.xmlSet1RandomText = xmlSet1RandomText;
        this.xmlSet2RandomText = xmlSet2RandomText;
        this.xmlSet3RandomText = xmlSet3RandomText;
        this.xmlSet1SameText = xmlSet1SameText;
        this.xmlSet2SameText = xmlSet2SameText;
        this.xmlSet3SameText = xmlSet3SameText;
        this.gzipSet1RandomText = gzipSet1RandomText;
        this.gzipSet2RandomText = gzipSet2RandomText;
        this.gzipSet3RandomText = gzipSet3RandomText;
        this.gzipSet1SameText = gzipSet1SameText;
        this.gzipSet2SameText = gzipSet2SameText;
        this.gzipSet3SameText = gzipSet3SameText;
        this.protobufSet1RandomText = protobufSet1RandomText;
        this.protobufSet2RandomText = protobufSet2RandomText;
        this.protobufSet3RandomText = protobufSet3RandomText;
        this.protobufSet1SameText = protobufSet1SameText;
        this.protobufSet2SameText = protobufSet2SameText;
        this.protobufSet3SameText = protobufSet3SameText;
    }


    // XML adds
    public void addLongToXmlSet1RandomText(long a){
        xmlSet1RandomText.add(a);
    }
    public void addLongToXmlSet2RandomText(long a){
        xmlSet2RandomText.add(a);
    }
    public void addLongToXmlSet3RandomText(long a){
        xmlSet3RandomText.add(a);
    }
    public void addLongToXmlSet1SameText(long a){
        xmlSet1SameText.add(a);
    }
    public void addLongToXmlSet2SameText(long a){
        xmlSet2SameText.add(a);
    }
    public void addLongToXmlSet3SameText(long a){
        xmlSet3SameText.add(a);
    }

    // Gzip adds
    public void addLongToGzipSet1RandomText(long a){
        gzipSet1RandomText.add(a);
    }
    public void addLongToGzipSet2RandomText(long a){
        gzipSet2RandomText.add(a);
    }
    public void addLongToGzipSet3RandomText(long a){
        gzipSet2RandomText.add(a);
    }
    public void addLongToGzipSet1SameText(long a){
        gzipSet1SameText.add(a);
    }
    public void addLongToGzipSet2SameText(long a){
        gzipSet2SameText.add(a);
    }
    public void addLongToGzipSet3SameText(long a){
        gzipSet2SameText.add(a);
    }

    //Protobuf adds
    public void addLongToProtobufSet1RandomText(long a){
        protobufSet1RandomText.add(a);
    }
    public void addLongToProtobufSet2RandomText(long a){
        protobufSet2RandomText.add(a);
    }
    public void addLongToProtobufSet3RandomText(long a){
       protobufSet3RandomText.add(a);
    }
    public void addLongToProtobufSet1SameText(long a){
        protobufSet1SameText.add(a);
    }
    public void addLongToProtobufSet2SameText(long a){
        protobufSet2SameText.add(a);
    }
    public void addLongToProtobufSet3SameText(long a){
        protobufSet3SameText.add(a);
    }


}

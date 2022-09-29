import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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
            protobufSet3SameText,
            protobufSet1RandomTextWrite,
            protobufSet2RandomTextWrite,
            protobufSet3RandomTextWrite,
            protobufSet1RandomTextTotal,
            protobufSet2RandomTextTotal,
            protobufSet3RandomTextTotal,
            protobufSet1SameTextWrite,
            protobufSet2SameTextWrite,
            protobufSet3SameTextWrite,
            protobufSet1SameTextTotal,
            protobufSet2SameTextTotal,
            protobufSet3SameTextTotal;


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
        this.protobufSet1RandomTextWrite = new ArrayList<>();
        this.protobufSet2RandomTextWrite = new ArrayList<>();
        this.protobufSet3RandomTextWrite = new ArrayList<>();
        this.protobufSet1SameTextWrite = new ArrayList<>();
        this.protobufSet2SameTextWrite = new ArrayList<>();
        this.protobufSet3SameTextWrite = new ArrayList<>();
        this.protobufSet1RandomTextTotal = new ArrayList<>();
        this.protobufSet2RandomTextTotal = new ArrayList<>();
        this.protobufSet3RandomTextTotal = new ArrayList<>();
        this.protobufSet1SameTextTotal = new ArrayList<>();
        this.protobufSet2SameTextTotal = new ArrayList<>();
        this.protobufSet3SameTextTotal = new ArrayList<>();
    }


    // XML adds
    public void addLongToXmlSet1RandomText(long a) {
        xmlSet1RandomText.add(a);
    }

    public void addLongToXmlSet2RandomText(long a) {
        xmlSet2RandomText.add(a);
    }

    public void addLongToXmlSet3RandomText(long a) {
        xmlSet3RandomText.add(a);
    }

    public void addLongToXmlSet1SameText(long a) {
        xmlSet1SameText.add(a);
    }

    public void addLongToXmlSet2SameText(long a) {
        xmlSet2SameText.add(a);
    }

    public void addLongToXmlSet3SameText(long a) {
        xmlSet3SameText.add(a);
    }

    // Gzip adds
    public void addLongToGzipSet1RandomText(long a) {
        gzipSet1RandomText.add(a);
    }

    public void addLongToGzipSet2RandomText(long a) {
        gzipSet2RandomText.add(a);
    }

    public void addLongToGzipSet3RandomText(long a) {
        gzipSet3RandomText.add(a);
    }

    public void addLongToGzipSet1SameText(long a) {
        gzipSet1SameText.add(a);
    }

    public void addLongToGzipSet2SameText(long a) {
        gzipSet2SameText.add(a);
    }

    public void addLongToGzipSet3SameText(long a) {
        gzipSet3SameText.add(a);
    }

    //Protobuf adds
    public void addLongToProtobufSet1RandomText(long a) {
        protobufSet1RandomText.add(a);
    }

    public void addLongToProtobufSet2RandomText(long a) {
        protobufSet2RandomText.add(a);
    }

    public void addLongToProtobufSet3RandomText(long a) {
        protobufSet3RandomText.add(a);
    }

    public void addLongToProtobufSet1SameText(long a) {
        protobufSet1SameText.add(a);
    }

    public void addLongToProtobufSet2SameText(long a) {
        protobufSet2SameText.add(a);
    }

    public void addLongToProtobufSet3SameText(long a) {
        protobufSet3SameText.add(a);
    }

    public void addLongToProtobufSet1RandomTextWrite(long a){
        protobufSet1RandomTextWrite.add(a);
    }

    public void addLongToProtobufSet2RandomTextWrite(long a){
        protobufSet2RandomTextWrite.add(a);
    }
    public void addLongToProtobufSet3RandomTextWrite(long a){
        protobufSet3RandomTextWrite.add(a);
    }

    public void addLongToProtobufSet1SameTextWrite(long a){
        protobufSet1SameTextWrite.add(a);
    }

    public void addLongToProtobufSet2SameTextWrite(long a){
        protobufSet2SameTextWrite.add(a);
    }

    public void addLongToProtobufSet3SameTextWrite(long a){
        protobufSet3SameTextWrite.add(a);
    }

    public void addLongToProtobufSet1RandomTextTotal(long a){
        protobufSet1RandomTextTotal.add(a);
    }

    public void addLongToProtobufSet2RandomTextTotal(long a){
        protobufSet2RandomTextTotal.add(a);
    }

    public void addLongToProtobufSet3RandomTextTotal(long a){
        protobufSet3RandomTextTotal.add(a);
    }

    public void addLongToProtobufSet1SameTextTotal(long a){
        protobufSet1SameTextTotal.add(a);
    }

    public void addLongToProtobufSet2SameTextTotal(long a){
        protobufSet2SameTextTotal.add(a);
    }
    public void addLongToProtobufSet3SameTextTotal(long a){
        protobufSet3SameTextTotal.add(a);
    }

    public ArrayList<Long> getXmlSet1RandomText() {
        return xmlSet1RandomText;
    }

    public void setXmlSet1RandomText(ArrayList<Long> xmlSet1RandomText) {
        this.xmlSet1RandomText = xmlSet1RandomText;
    }

    public ArrayList<Long> getXmlSet2RandomText() {
        return xmlSet2RandomText;
    }

    public void setXmlSet2RandomText(ArrayList<Long> xmlSet2RandomText) {
        this.xmlSet2RandomText = xmlSet2RandomText;
    }

    public ArrayList<Long> getXmlSet3RandomText() {
        return xmlSet3RandomText;
    }

    public void setXmlSet3RandomText(ArrayList<Long> xmlSet3RandomText) {
        this.xmlSet3RandomText = xmlSet3RandomText;
    }

    public ArrayList<Long> getXmlSet1SameText() {
        return xmlSet1SameText;
    }

    public void setXmlSet1SameText(ArrayList<Long> xmlSet1SameText) {
        this.xmlSet1SameText = xmlSet1SameText;
    }

    public ArrayList<Long> getXmlSet2SameText() {
        return xmlSet2SameText;
    }

    public void setXmlSet2SameText(ArrayList<Long> xmlSet2SameText) {
        this.xmlSet2SameText = xmlSet2SameText;
    }

    public ArrayList<Long> getXmlSet3SameText() {
        return xmlSet3SameText;
    }

    public void setXmlSet3SameText(ArrayList<Long> xmlSet3SameText) {
        this.xmlSet3SameText = xmlSet3SameText;
    }

    public ArrayList<Long> getGzipSet1RandomText() {
        return gzipSet1RandomText;
    }

    public void setGzipSet1RandomText(ArrayList<Long> gzipSet1RandomText) {
        this.gzipSet1RandomText = gzipSet1RandomText;
    }

    public ArrayList<Long> getGzipSet2RandomText() {
        return gzipSet2RandomText;
    }

    public void setGzipSet2RandomText(ArrayList<Long> gzipSet2RandomText) {
        this.gzipSet2RandomText = gzipSet2RandomText;
    }

    public ArrayList<Long> getGzipSet3RandomText() {
        return gzipSet3RandomText;
    }

    public void setGzipSet3RandomText(ArrayList<Long> gzipSet3RandomText) {
        this.gzipSet3RandomText = gzipSet3RandomText;
    }

    public ArrayList<Long> getGzipSet1SameText() {
        return gzipSet1SameText;
    }

    public void setGzipSet1SameText(ArrayList<Long> gzipSet1SameText) {
        this.gzipSet1SameText = gzipSet1SameText;
    }

    public ArrayList<Long> getGzipSet2SameText() {
        return gzipSet2SameText;
    }

    public void setGzipSet2SameText(ArrayList<Long> gzipSet2SameText) {
        this.gzipSet2SameText = gzipSet2SameText;
    }

    public ArrayList<Long> getGzipSet3SameText() {
        return gzipSet3SameText;
    }

    public void setGzipSet3SameText(ArrayList<Long> gzipSet3SameText) {
        this.gzipSet3SameText = gzipSet3SameText;
    }

    public ArrayList<Long> getProtobufSet1RandomText() {
        return protobufSet1RandomText;
    }

    public void setProtobufSet1RandomText(ArrayList<Long> protobufSet1RandomText) {
        this.protobufSet1RandomText = protobufSet1RandomText;
    }

    public ArrayList<Long> getProtobufSet2RandomText() {
        return protobufSet2RandomText;
    }

    public void setProtobufSet2RandomText(ArrayList<Long> protobufSet2RandomText) {
        this.protobufSet2RandomText = protobufSet2RandomText;
    }

    public ArrayList<Long> getProtobufSet3RandomText() {
        return protobufSet3RandomText;
    }

    public void setProtobufSet3RandomText(ArrayList<Long> protobufSet3RandomText) {
        this.protobufSet3RandomText = protobufSet3RandomText;
    }

    public ArrayList<Long> getProtobufSet1SameText() {
        return protobufSet1SameText;
    }

    public void setProtobufSet1SameText(ArrayList<Long> protobufSet1SameText) {
        this.protobufSet1SameText = protobufSet1SameText;
    }

    public ArrayList<Long> getProtobufSet2SameText() {
        return protobufSet2SameText;
    }

    public void setProtobufSet2SameText(ArrayList<Long> protobufSet2SameText) {
        this.protobufSet2SameText = protobufSet2SameText;
    }

    public ArrayList<Long> getProtobufSet3SameText() {
        return protobufSet3SameText;
    }

    public void setProtobufSet3SameText(ArrayList<Long> protobufSet3SameText) {
        this.protobufSet3SameText = protobufSet3SameText;
    }

    public ArrayList<Long> getProtobufSet1RandomTextWrite() {
        return protobufSet1RandomTextWrite;
    }

    public void setProtobufSet1RandomTextWrite(ArrayList<Long> protobufSet1RandomTextWrite) {
        this.protobufSet1RandomTextWrite = protobufSet1RandomTextWrite;
    }

    public ArrayList<Long> getProtobufSet2RandomTextWrite() {
        return protobufSet2RandomTextWrite;
    }

    public void setProtobufSet2RandomTextWrite(ArrayList<Long> protobufSet2RandomTextWrite) {
        this.protobufSet2RandomTextWrite = protobufSet2RandomTextWrite;
    }

    public ArrayList<Long> getProtobufSet3RandomTextWrite() {
        return protobufSet3RandomTextWrite;
    }

    public void setProtobufSet3RandomTextWrite(ArrayList<Long> protobufSet3RandomTextWrite) {
        this.protobufSet3RandomTextWrite = protobufSet3RandomTextWrite;
    }

    public ArrayList<Long> getProtobufSet1RandomTextTotal() {
        return protobufSet1RandomTextTotal;
    }

    public void setProtobufSet1RandomTextTotal(ArrayList<Long> protobufSet1RandomTextTotal) {
        this.protobufSet1RandomTextTotal = protobufSet1RandomTextTotal;
    }

    public ArrayList<Long> getProtobufSet2RandomTextTotal() {
        return protobufSet2RandomTextTotal;
    }

    public void setProtobufSet2RandomTextTotal(ArrayList<Long> protobufSet2RandomTextTotal) {
        this.protobufSet2RandomTextTotal = protobufSet2RandomTextTotal;
    }

    public ArrayList<Long> getProtobufSet3RandomTextTotal() {
        return protobufSet3RandomTextTotal;
    }

    public void setProtobufSet3RandomTextTotal(ArrayList<Long> protobufSet3RandomTextTotal) {
        this.protobufSet3RandomTextTotal = protobufSet3RandomTextTotal;
    }

    public ArrayList<Long> getProtobufSet1SameTextWrite() {
        return protobufSet1SameTextWrite;
    }

    public void setProtobufSet1SameTextWrite(ArrayList<Long> protobufSet1SameTextWrite) {
        this.protobufSet1SameTextWrite = protobufSet1SameTextWrite;
    }

    public ArrayList<Long> getProtobufSet2SameTextWrite() {
        return protobufSet2SameTextWrite;
    }

    public void setProtobufSet2SameTextWrite(ArrayList<Long> protobufSet2SameTextWrite) {
        this.protobufSet2SameTextWrite = protobufSet2SameTextWrite;
    }

    public ArrayList<Long> getProtobufSet3SameTextWrite() {
        return protobufSet3SameTextWrite;
    }

    public void setProtobufSet3SameTextWrite(ArrayList<Long> protobufSet3SameTextWrite) {
        this.protobufSet3SameTextWrite = protobufSet3SameTextWrite;
    }

    public ArrayList<Long> getProtobufSet1SameTextTotal() {
        return protobufSet1SameTextTotal;
    }

    public void setProtobufSet1SameTextTotal(ArrayList<Long> protobufSet1SameTextTotal) {
        this.protobufSet1SameTextTotal = protobufSet1SameTextTotal;
    }

    public ArrayList<Long> getProtobufSet2SameTextTotal() {
        return protobufSet2SameTextTotal;
    }

    public void setProtobufSet2SameTextTotal(ArrayList<Long> protobufSet2SameTextTotal) {
        this.protobufSet2SameTextTotal = protobufSet2SameTextTotal;
    }

    public ArrayList<Long> getProtobufSet3SameTextTotal() {
        return protobufSet3SameTextTotal;
    }

    public void setProtobufSet3SameTextTotal(ArrayList<Long> protobufSet3SameTextTotal) {
        this.protobufSet3SameTextTotal = protobufSet3SameTextTotal;
    }

    public long getAverage( ArrayList<Long> a){
        long sum = 0;
        for(int i = 10; i<a.size(); ++i ){
            sum += a.get(i);
        }
        return sum/(a.size()-10);
    }

    public long SD(ArrayList<Long> a){
        long standardDeviation = 0;
        long mean = getAverage(a);
        for(int i = 10; i<a.size(); ++i ){
            standardDeviation += Math.pow(a.get(i)-mean, 2);
        }
        return (long)Math.sqrt(standardDeviation/(a.size()-10));
    }

    public void printer(String type) throws FileNotFoundException {

            //print marshallHelper
            System.out.println("--------"+ type + " XML RandomText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getXmlSet1RandomText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getXmlSet2RandomText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getXmlSet3RandomText()));
            System.out.println("--------"+ type + " XML SameText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getXmlSet1SameText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getXmlSet2SameText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getXmlSet3SameText()));

            System.out.println("--------"+ type + " Gzip RandomText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getGzipSet1RandomText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getGzipSet2RandomText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getGzipSet3RandomText()));
            System.out.println("--------"+ type + " Gzip SameText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getGzipSet1SameText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getGzipSet2SameText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getGzipSet3SameText()));

            System.out.println("--------"+ type + " Protobuf RandomText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getProtobufSet1RandomText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getProtobufSet2RandomText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getProtobufSet3RandomText()));
            System.out.println("--------"+ type + " Protobuf SameText");
            System.out.println("- Set 1");
            System.out.println(getAverage(getProtobufSet1SameText()));
            System.out.println("- Set 2");
            System.out.println(getAverage(getProtobufSet2SameText()));
            System.out.println("- Set 3");
            System.out.println(getAverage(getProtobufSet3SameText()));


        System.out.println("--------"+ type + " Protobuf RandomText Writer");
        System.out.println("- Set 1");
        System.out.println(getAverage(getProtobufSet1RandomTextWrite()));
        System.out.println("- Set 2");
        System.out.println(getAverage(getProtobufSet2RandomTextWrite()));
        System.out.println("- Set 3");
        System.out.println(getAverage(getProtobufSet3RandomTextWrite()));
        System.out.println("--------"+ type + " Protobuf SameText Writer");
        System.out.println("- Set 1");
        System.out.println(getAverage(getProtobufSet1SameTextWrite()));
        System.out.println("- Set 2");
        System.out.println(getAverage(getProtobufSet2SameTextWrite()));
        System.out.println("- Set 3");
        System.out.println(getAverage(getProtobufSet3SameTextWrite()));

        System.out.println("--------"+ type + " Protobuf RandomText Total");
        System.out.println("- Set 1");
        System.out.println(getAverage(getProtobufSet1RandomTextTotal()));
        System.out.println("- Set 2");
        System.out.println(getAverage(getProtobufSet2RandomTextTotal()));
        System.out.println("- Set 3");
        System.out.println(getAverage(getProtobufSet3RandomTextTotal()));
        System.out.println("--------"+ type + " Protobuf SameText Total");
        System.out.println("- Set 1");
        System.out.println(getAverage(getProtobufSet1SameTextTotal()));
        System.out.println("- Set 2");
        System.out.println(getAverage(getProtobufSet2SameTextTotal()));
        System.out.println("- Set 3");
        System.out.println(getAverage(getProtobufSet3SameTextTotal()));

        //      standard deviation
        //print marshallHelper
        System.out.println("--------"+ type + " XML RandomText");
        System.out.println("- Set 1");
        System.out.println(SD(getXmlSet1RandomText()));
        System.out.println("- Set 2");
        System.out.println(SD(getXmlSet2RandomText()));
        System.out.println("- Set 3");
        System.out.println(SD(getXmlSet3RandomText()));
        System.out.println("--------"+ type + " XML SameText");
        System.out.println("- Set 1");
        System.out.println(SD(getXmlSet1SameText()));
        System.out.println("- Set 2");
        System.out.println(SD(getXmlSet2SameText()));
        System.out.println("- Set 3");
        System.out.println(SD(getXmlSet3SameText()));

        System.out.println("--------"+ type + " Gzip RandomText");
        System.out.println("- Set 1");
        System.out.println(SD(getGzipSet1RandomText()));
        System.out.println("- Set 2");
        System.out.println(SD(getGzipSet2RandomText()));
        System.out.println("- Set 3");
        System.out.println(SD(getGzipSet3RandomText()));
        System.out.println("--------"+ type + " Gzip SameText");
        System.out.println("- Set 1");
        System.out.println(SD(getGzipSet1SameText()));
        System.out.println("- Set 2");
        System.out.println(SD(getGzipSet2SameText()));
        System.out.println("- Set 3");
        System.out.println(SD(getGzipSet3SameText()));

        System.out.println("--------"+ type + " Protobuf RandomText");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1RandomText()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2RandomText()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3RandomText()));
        System.out.println("--------"+ type + " Protobuf SameText");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1SameText()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2SameText()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3SameText()));


        System.out.println("--------"+ type + " Protobuf RandomText Writer");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1RandomTextWrite()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2RandomTextWrite()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3RandomTextWrite()));
        System.out.println("--------"+ type + " Protobuf SameText Writer");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1SameTextWrite()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2SameTextWrite()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3SameTextWrite()));

        System.out.println("--------"+ type + " Protobuf RandomText Total");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1RandomTextTotal()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2RandomTextTotal()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3RandomTextTotal()));
        System.out.println("--------"+ type + " Protobuf SameText Total");
        System.out.println("- Set 1");
        System.out.println(SD(getProtobufSet1SameTextTotal()));
        System.out.println("- Set 2");
        System.out.println(SD(getProtobufSet2SameTextTotal()));
        System.out.println("- Set 3");
        System.out.println(SD(getProtobufSet3SameTextTotal()));

        //print marshallHelper
        System.out.println("--------"+ type + " XML RandomText");
        System.out.println("- Set 1");
        System.out.println(getXmlSet1RandomText());
        System.out.println("- Set 2");
        System.out.println(getXmlSet2RandomText());
        System.out.println("- Set 3");
        System.out.println(getXmlSet3RandomText());
        System.out.println("--------"+ type + " XML SameText");
        System.out.println("- Set 1");
        System.out.println(getXmlSet1SameText());
        System.out.println("- Set 2");
        System.out.println(getXmlSet2SameText());
        System.out.println("- Set 3");
        System.out.println(getXmlSet3SameText());

        System.out.println("--------"+ type + " Gzip RandomText");
        System.out.println("- Set 1");
        System.out.println(getGzipSet1RandomText());
        System.out.println("- Set 2");
        System.out.println(getGzipSet2RandomText());
        System.out.println("- Set 3");
        System.out.println(getGzipSet3RandomText());
        System.out.println("--------"+ type + " Gzip SameText");
        System.out.println("- Set 1");
        System.out.println(getGzipSet1SameText());
        System.out.println("- Set 2");
        System.out.println(getGzipSet2SameText());
        System.out.println("- Set 3");
        System.out.println(getGzipSet3SameText());

        System.out.println("--------"+ type + " Protobuf RandomText");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1RandomText());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2RandomText());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3RandomText());
        System.out.println("--------"+ type + " Protobuf SameText");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1SameText());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2SameText());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3SameText());


        System.out.println("--------"+ type + " Protobuf RandomText Writer");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1RandomTextWrite());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2RandomTextWrite());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3RandomTextWrite());
        System.out.println("--------"+ type + " Protobuf SameText Writer");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1SameTextWrite());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2SameTextWrite());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3SameTextWrite());

        System.out.println("--------"+ type + " Protobuf RandomText Total");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1RandomTextTotal());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2RandomTextTotal());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3RandomTextTotal());
        System.out.println("--------"+ type + " Protobuf SameText Total");
        System.out.println("- Set 1");
        System.out.println(getProtobufSet1SameTextTotal());
        System.out.println("- Set 2");
        System.out.println(getProtobufSet2SameTextTotal());
        System.out.println("- Set 3");
        System.out.println(getProtobufSet3SameTextTotal());



        }
}

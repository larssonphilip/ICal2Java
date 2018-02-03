import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ICalReader {
    private BufferedReader br;
    private List<ICSHandler> infoList;
    private List<String> calendarAboutList;
    private ICSHandler handler;
    private boolean first;

    public void read(String filename) {
        first = true;
        infoList = new ArrayList<ICSHandler>();
        calendarAboutList = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(filename));
            String s;
            handler = new ICSHandler();
            while((s = br.readLine()) != null) {
                if(first) {
                    if(s.substring(0, s.indexOf(":")).equals("VERSION")) {
                        calendarAboutList.add(s.substring(s.lastIndexOf(":") + 1));
                    }
                    if(s.substring(0, s.indexOf(":")).equals("PRODID")) {
                        calendarAboutList.add(s.substring(s.lastIndexOf(":") + 1));
                    }
                    if(s.substring(0, s.indexOf(":")).equals("METHOD")) {
                        calendarAboutList.add(s.substring(s.lastIndexOf(":") + 1));
                    }
                    if(s.substring(0, s.indexOf(":")).equals("X-WR-CALNAME")) {
                            calendarAboutList.add(s.substring(s.lastIndexOf(":") + 1));
                            first = false;
                    }
                }

                if(s.substring(0, s.indexOf(":")).equals("DTSTART")) {
                    handler.setStartDate(s.substring(s.lastIndexOf(":") + 1, s.lastIndexOf("T")));
                    handler.setStartTime(s.substring(s.lastIndexOf("T") + 1, s.lastIndexOf("Z")));
                }
                if(s.substring(0, s.indexOf(":")).equals("DTEND")) {
                    handler.setEndDate(s.substring(s.lastIndexOf(":") + 1, s.lastIndexOf("T")));
                    handler.setEndTime(s.substring(s.lastIndexOf("T") + 1, s.lastIndexOf("Z")));
                }
                if(s.substring(0, s.indexOf(":")).equals("DTSTAMP")) {
                    handler.setDtStampDate(s.substring(s.lastIndexOf(":") + 1, s.lastIndexOf("T")));
                    handler.setDtStampTime(s.substring(s.lastIndexOf("T") + 1, s.lastIndexOf("Z")));
                }
                if(s.substring(0, s.indexOf(":")).equals("UID")) {
                    handler.setUID(s.substring(s.lastIndexOf(":") + 1));
                }
                if(s.substring(0, s.indexOf(":")).equals("CREATED")) {
                    handler.setCreationDate(s.substring(s.lastIndexOf(":") + 1, s.lastIndexOf("T")));
                    handler.setCreationTime(s.substring(s.lastIndexOf("T"), s.lastIndexOf("Z")));
                }
                if(s.substring(0, s.indexOf(":")).equals("MODIFIED")) {
                    handler.setLastModifiedDate(s.substring(s.lastIndexOf(":") + 1, s.lastIndexOf("T")));
                    handler.setLastModifiedTime(s.substring(s.lastIndexOf("T"), s.lastIndexOf("Z")));
                }
                if(s.substring(0, s.indexOf(":")).equals("LOCATION")) {
                    handler.setLocation(s.substring(s.lastIndexOf(":") + 1));
                }
                if(s.substring(0, s.indexOf(":")).equals("SEQUENCE")) {
                    handler.setSequence(Integer.parseInt((s.substring(s.lastIndexOf(":") + 1))));
                }
                if(s.substring(0, s.indexOf(":")).equals("STATUS")) {
                    handler.setStatus(s.substring(s.lastIndexOf(":") + 1));
                }
                if(s.substring(0, s.indexOf(":")).equals("SUMMARY")) {
                    handler.setSummary(s.substring(s.lastIndexOf(":") + 1));
                }
                if(s.substring(0, s.indexOf(":")).equals("TRANSP")) {
                    handler.setTransparency(s.substring(s.lastIndexOf(":") + 1));
                }
                if(s.equals("END:VEVENT") && handler != null) {
                    infoList.add(handler);
                    handler = new ICSHandler();
                }
            }
        } catch(IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public List<ICSHandler> getList() {
        return infoList;
    }

    public List<String> getInfoAboutICAL() {
        return calendarAboutList;
    }
}

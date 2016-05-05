package utilities;

//http://programmers.stackexchange.com/questions/166908/a-way-to-return-multiple-return-values-from-a-method-put-method-inside-class-re
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSorter {

    private String firstLine;
    private Map<Integer, String> messages;
    private String lastLine;

    public MapSorter( List<String> messages ) {
        this.messages = new HashMap();
        createMap( messages );
        this.firstLine = messages.get( 0 );
        this.lastLine = messages.get( messages.size() - 1 );
    }

    private void createMap( List<String> messages ) {
        for ( Integer i = 0; i < messages.size(); i++ ) {
            this.messages.put( i, messages.get( i ) );
        }
    }

    private String[] getSplitFirstLine() {
        return firstLine.split( "</h1>" );
    }

    private String[] getSplitLastLine() {
        return lastLine.split( "<div class=\"footer\">" );
    }

    public String getMessageOwnerName() {
        return getSplitFirstLine()[ 0 ].split( "<h1>" )[ 1 ];
    }

    public String getMessageDownloadInfo() {
        return getSplitLastLine()[ 1 ].split( "</div>" )[ 0 ];
    }

    public Map<Integer, String> getHashMapWithMessagesOnly() {
        messages.put( 0, getSplitFirstLine()[ 1 ] );
        messages.put( messages.size() - 1, getSplitLastLine()[ 0 ] );
        return messages;
    }

}

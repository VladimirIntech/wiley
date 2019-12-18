package Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogReader {
    private static final Logger log = LogManager.getLogger(LogReader.class.getName());

    public static Logger getLog() {return log;
    }
}


package log;

public class Logger {
    private LogWindowSource logSource = new LogWindowSource(10);
    private static Logger INSTANCE;

    public Logger() {

    }

    public static Logger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logger();
        }
        return INSTANCE;
    }


    public void debug(String strMessage) {
        logSource.append(LogLevel.Debug, strMessage);
    }

    public void info(String strMessage) {
        logSource.append(LogLevel.Info, strMessage);
    }

    public void error(String strMessage) {
        logSource.append(LogLevel.Error, strMessage);
    }

    public void gameInfo(String strMessage) {
        logSource.append(LogLevel.GameInfo, strMessage);
    }

    /**
     * Может пригодиться в будущем
     */
    public void warning(String strMessage) {
        logSource.append(LogLevel.Warning, strMessage);
    }


    /**
     * Может пригодиться в будущем
     */
    public void fatal(String strMessage) {
        logSource.append(LogLevel.Fatal, strMessage);
    }

    /**
     * Может пригодиться в будущем
     */
    public void trace(String strMessage) {
        getLogSource().append(LogLevel.Trace, strMessage);
    }

    public LogWindowSource getLogSource() {
        return logSource;
    }

    public void setLogSource(LogWindowSource logSource) {
        this.logSource = logSource;
    }
}

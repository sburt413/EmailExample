package com.bsc.email.report;

/**
 * Low level email utilities.
 */
public class EmailRelay {
    static boolean debug;

    public void enableDebug() {
        debug = true;
    }

    public static void send(Object obj) throws Exception {
        if (debug) {
            throw new Exception();
        }

        // Intentionally blank
        // Beyond this point, assume any logic needed to send `obj` correctly exists here
    }
}

package com.neotasker.platform;

/**
 * This class contains constants that may be used anywhere on the system,
 * and must not be instanced - it should only be accessed statically.
 */
public class Constants {
    /** The project's name. */
    public static final String PROJECT_NAME = "NeoTasker";
    /** Maximum size for titles in fields. */
    public static final int TITLE_SIZE = 100;
    /** Maximum size for description in fields. */
    public static final int DESCRIPTION_SIZE = 1000;
    /** Maximum size for small labels in fields. */
    public static final int LABEL_SIZE = 16;
    /** A size large enough to fit ISO 8601 timestamps.  */
    public static final int TIMESTAMP_SIZE = 32;

    /** Do nothing on instantiation */
    public Constants() {
    }
}


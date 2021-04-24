package com.koneska.interview.exception;

/**
 * Custom exceptions
 */
public class KoneskaException extends  RuntimeException {

    public static class DeserializerException extends KoneskaException {

        public DeserializerException(String s, Throwable e) {
            super(s, e);
        }
    }

    public static class SerializerException extends KoneskaException {

        public SerializerException(String s, Throwable e) {
            super(s, e);
        }
    }

    public KoneskaException(String s, Throwable e) {
        super(s, e);
    }
}

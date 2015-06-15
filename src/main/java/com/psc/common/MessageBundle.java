package com.psc.common;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageBundle {

    private static final Logger log = Logger.getLogger(MessageBundle.class);

    private static final String MESSAGE_FILE = "message";
    private static final String DEFAULT_ERROR_MESSAGE = "MessageBundle doesn't contain such key";

    private static MessageBundle messageBundle;
    private static ResourceBundle resourceBundle;

    public static MessageBundle getInstance() {
        if (messageBundle == null) {
            messageBundle = new MessageBundle();
        }
        return messageBundle;
    }

    private ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            try {
                resourceBundle = ResourceBundle.getBundle(MESSAGE_FILE, Locale.ENGLISH);
            } catch (Exception e) {
                log.error(MESSAGE_FILE + ".properties file not found. Will use default error message for all errors: " + DEFAULT_ERROR_MESSAGE, e);
            }
        }
        return resourceBundle;
    }

    /**
     * Returns messages from the bundle for a given key
     */
    public String getMessage(String messageKey) {
        String message = null;
        try {
            resourceBundle = getResourceBundle();
            message = resourceBundle.getString(messageKey);
        } catch (Exception e) {
            log.debug("Couldn't find key: " + messageKey + " in " + MESSAGE_FILE + ".properties file. Using default: " + message);
        }
        return message;
    }

    /**
     * Returns messages from the bundle for a given key
     * Handles message arguments
     */
    public String getMessage(String messageKey, String... args) {
        if ((args == null) || (args.length == 0)) {
            return getMessage(messageKey);
        }
        MessageFormat formatter = new MessageFormat("");
        String pattern = getMessage(messageKey);
        formatter.applyPattern(pattern);
        return formatter.format(args);
    }
}
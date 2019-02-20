package com.silbury.selenium.exception;

public class InvalidConfigurationException extends Throwable
{
    private final String message;

    public InvalidConfigurationException(String message)
    {
        this.message = message;
    }

    @Override
    public void printStackTrace()
    {
        System.err.println(
                "Key or value must exist in the format 'key::value', your configuration has '" +
                        message + "'");
        super.printStackTrace();
    }
}

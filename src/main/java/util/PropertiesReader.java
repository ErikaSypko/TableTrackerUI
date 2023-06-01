package util;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Slf4j
public class PropertiesReader {
    Properties property = new Properties();
    public PropertiesReader() {
        FileInputStream file;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
            property.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            log.error(e.toString());
            ReportPortal.emitLog("Test failed", LogLevel.ERROR.name(), new Date());
        } catch (IOException e) {
            log.error(e.toString());
            ReportPortal.emitLog("Test failed", LogLevel.ERROR.name(), new Date());
        }
    }

    public String getSocketAddress() {
        return property.getProperty("SOCKET_ADDRESS");
    }

    public String getHomeEndpoint() {
        return property.getProperty("HOME_ENDPOINT");
    }

    public String getLoginEndpoint() {
        return property.getProperty("LOGIN_ENDPOINT");
    }

    public String getEmail() {
        return property.getProperty("USER_EMAIL");
    }

    public String getPassword() {
        return property.getProperty("USER_PASSWORD");
    }

    public String getName() {
        return property.getProperty("USER_NAME");
    }

    public String getInvalidEmail() {
        return property.getProperty("INVALID_USER_EMAIL");
    }

    public String getInvalidPassword() {
        return property.getProperty("INVALID_USER_PASSWORD");
    }

    public String getAuthenticationErrorMessage() {
        return property.getProperty("AUTHENTICATION_ERROR_MESSAGE");
    }

    public String getBlankEmail() {
        return property.getProperty("BLANK_USER_EMAIL");
    }

    public String getBlankPassword() {
        return property.getProperty("BLANK_USER_PASSWORD");
    }

    public String getMissingEmailErrorMessage() {
        return property.getProperty("MISSING_EMAIL_ERROR_MESSAGE");
    }

    public String getMissingPasswordErrorMessage() {
        return property.getProperty("MISSING_PASSWORD_ERROR_MESSAGE");
    }
}

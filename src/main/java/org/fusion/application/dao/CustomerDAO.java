package org.fusion.application.dao;

import java.sql.Timestamp;
import java.util.Date;

public interface CustomerDAO {
    Integer getId();

    String getName();

    String getAddress();

    String getPhone();

    String getEmail();

    Byte getActive();

    String getCreated();
}

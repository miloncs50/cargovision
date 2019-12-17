package org.fusion.application.dao;

import java.sql.Date;
import java.sql.Timestamp;

public interface ImportDAO {
    Integer getId();

    String getDate();

    String getVehicale();

    String getTransport();

    String getWeight();

    String getNote();

    String getCreated();

    String getUpdate();

    String getEntryby();

    String getAuthby();
}

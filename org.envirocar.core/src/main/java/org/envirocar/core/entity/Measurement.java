/**
 * Copyright (C) 2013 - 2015 the enviroCar community
 *
 * This file is part of the enviroCar app.
 *
 * The enviroCar app is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The enviroCar app is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with the enviroCar app. If not, see http://www.gnu.org/licenses/.
 */
package org.envirocar.core.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO JavaDoc
 *
 * @author dewall
 */
public interface Measurement extends BaseEntity<Measurement> {

    // All measurement values
    enum PropertyKey {
        SPEED {
            public String toString() {
                return "Speed";
            }
        },
        MAF {
            public String toString() {
                return "MAF";
            }
        },
        CALCULATED_MAF {
            public String toString() {
                return "Calculated MAF";
            }
        },
        RPM {
            public String toString() {
                return "Rpm";
            }
        },
        INTAKE_TEMPERATURE {
            public String toString() {
                return "Intake Temperature";
            }
        },
        INTAKE_PRESSURE {
            public String toString() {
                return "Intake Pressure";
            }
        },
        CO2 {
            public String toString() {
                return "CO2";
            }
        },
        CONSUMPTION {
            public String toString() {
                return "Consumption";
            }
        },
        THROTTLE_POSITON {
            @Override
            public String toString() {
                return "Throttle Position";
            }
        },
        ENGINE_LOAD {
            @Override
            public String toString() {
                return "Engine Load";
            }
        },
        GPS_ACCURACY {
            @Override
            public String toString() {
                return "GPS Accuracy";
            }
        },
        GPS_SPEED {
            @Override
            public String toString() {
                return "GPS Speed";
            }
        },
        GPS_BEARING {
            @Override
            public String toString() {
                return "GPS Bearing";
            }
        },
        GPS_ALTITUDE {
            @Override
            public String toString() {
                return "GPS Altitude";
            }
        },
        GPS_PDOP {
            @Override
            public String toString() {
                return "GPS PDOP";
            }
        },
        GPS_HDOP {
            @Override
            public String toString() {
                return "GPS HDOP";
            }
        },
        GPS_VDOP {
            @Override
            public String toString() {
                return "GPS VDOP";
            }
        },
        LAMBDA_VOLTAGE {
            @Override
            public String toString() {
                return "O2 Lambda Voltage";
            }
        },
        LAMBDA_VOLTAGE_ER {
            @Override
            public String toString() {
                return LAMBDA_VOLTAGE.toString().concat(" ER");
            }
        },
        LAMBDA_CURRENT {
            @Override
            public String toString() {
                return "O2 Lambda Current";
            }
        },
        LAMBDA_CURRENT_ER {
            @Override
            public String toString() {
                return LAMBDA_CURRENT.toString().concat(" ER");
            }
        },
        FUEL_SYSTEM_LOOP {
            @Override
            public String toString() {
                return "Fuel System Loop";
            }
        },
        FUEL_SYSTEM_STATUS_CODE {
            @Override
            public String toString() {
                return "Fuel System Status Code";
            }
        },
        LONG_TERM_TRIM_1 {
            @Override
            public String toString() {
                return "Long-Term Fuel Trim 1";
            }
        },
        SHORT_TERM_TRIM_1 {
            @Override
            public String toString() {
                return "Short-Term Fuel Trim 1";
            }
        }
    }

    static final Map<String, PropertyKey> PropertyKeyValues = new HashMap<String,
            PropertyKey>() {
        {
            for (PropertyKey pk : PropertyKey.values()) {
                put(pk.toString(), pk);
            }
        }
    };

    Track.TrackId getTrackId();

    void setTrackId(Track.TrackId trackId);

    Double getLatitude();

    void setLatitude(double latitude);

    Double getLongitude();

    void setLongitude(double longitude);

    long getTime();

    void setTime(long time);

    Double getProperty(PropertyKey key);

    void setProperty(PropertyKey key, Double value);

    boolean hasProperty(PropertyKey key);

    Map<PropertyKey, Double> getAllProperties();

    void setAllProperties(Map<PropertyKey, Double> properties);

    Measurement carbonCopy();

    @Deprecated
    void reset();
}
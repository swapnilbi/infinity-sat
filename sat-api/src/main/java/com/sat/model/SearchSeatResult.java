package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchSeatResult {

    private List<FloorLayout> floorLayout = new ArrayList<>();

    @Data
    public static class FloorLayout {

        private List<ZoneLayout> zones = new ArrayList<>();

        @Data
        public static class ZoneLayout {

            private Long zoneId;
            private String zoneName;
            private List<List<SeatDetails>> seats = new ArrayList<>();

        }
    }
}

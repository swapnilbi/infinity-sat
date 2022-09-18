package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class FloorLayoutConfig {

	private List<Layout> layout;

	@Data
	public static class Layout{
		private List<ZoneLayout> zones;

		@Data
		public static class ZoneLayout {
			private Long zoneId;
			private List<List<Integer>> seats;
		}

	}
}

package com.createcivilization.capitol.common.data;

import com.createcivilization.capitol.common.managers.DatabaseManager;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public record Alliance(UUID id, String name, String tag, UUID teamId) {

	public Team getLeadingTeam() {
		return DatabaseManager.database.getTeam(teamId);
	}

	public List<Team> getTeams() {
		throw new NotImplementedException();
	}

	public static Alliance fromResultSet(ResultSet rs) throws SQLException {
		return new Alliance(
			UUID.fromString(rs.getString("id")),
			rs.getString("name"),
			rs.getString("tag"),
			UUID.fromString(rs.getString("team_id"))
		);
	}
}

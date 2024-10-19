package org.example.model;

import java.util.IntSummaryStatistics;

public record PostCountTitlesLikesStats(long postCount, String titles, IntSummaryStatistics likesStats) {
}

package se.tarlinder.foodlog

import se.tarlinder.foodlog.service.StatsService

class StatsController {

    StatsService statsService

    def index() {
        [stats: statsService.computeAggregatedStats(session.user)]
    }
}

package se.tarlinder.foodlog

import se.tarlinder.foodlog.service.StatsService

class StatsController {

    StatsService statsService

    def index() {
        def user = session.user
        [stats         : statsService.computeAggregatedStats(user),
         userDataPoints: statsService.getUserDataPoints(user)]
    }
}

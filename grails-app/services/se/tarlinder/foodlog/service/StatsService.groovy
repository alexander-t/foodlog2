package se.tarlinder.foodlog.service

import grails.transaction.Transactional
import groovy.sql.Sql
import org.postgresql.util.PGobject
import se.tarlinder.foodlog.AggregatedStats

@Transactional
class StatsService {

    def dataSource

    AggregatedStats computeAggregatedStats() {
        Sql sql = new Sql(dataSource)
        def rows = sql.rows("select compute_total_stats()")
        String unparsedRecord = ((PGobject) rows[0]["compute_total_stats"]).value.replaceAll(/[^\d,]/, "")
        def (energyBalanceKcal, foodKcal, workoutKcal) = unparsedRecord.split(/,/, -1)
        def aggregatedStats = new AggregatedStats()
        aggregatedStats.energyBalanceKcal = Integer.parseInt(energyBalanceKcal)
        aggregatedStats.foodKcal = foodKcal?.trim() ? Integer.parseInt(foodKcal) : 0
        aggregatedStats.workoutKcal = workoutKcal?.trim() ? Integer.parseInt(workoutKcal) : 0
        return aggregatedStats
    }
}

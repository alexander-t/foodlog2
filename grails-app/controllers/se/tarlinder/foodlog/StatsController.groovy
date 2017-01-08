package se.tarlinder.foodlog

import groovy.sql.Sql
import org.postgresql.util.PGobject

class StatsController {

    def index() {
        Sql sql = new Sql(grailsApplication.mainContext.getBean('dataSource'))
        def rows = sql.rows("select compute_total_stats()")
        String unparsedRecord = ((PGobject) rows[0]["compute_total_stats"]).value.replaceAll(/[^\d,]/, "")
        def (energyBalanceKcal, foodKcal, workoutKcal) = unparsedRecord.split(/,/, -1)

        return [energyBalanceKcal: Integer.parseInt(energyBalanceKcal),
                foodKcal         : foodKcal?.trim() ? Integer.parseInt(foodKcal) : 0,
                workoutKcal      : workoutKcal?.trim() ? Integer.parseInt(workoutKcal) : 0]
    }
}
